package com.youfan.map.ods;

import com.alibaba.fastjson.JSONObject;
import com.youfan.enums.YeWuType;
import com.youfan.liuLiang.log.AppProductCartLog;
import com.youfan.liuLiang.log.AppProductHuoDong;
import com.youfan.liuLiang.log.AppProductLog;
import com.youfan.liuLiang.log.LogParent;
import com.youfan.trade.order.dwd.YoufanOrderDwd;
import com.youfan.trade.order.ods.YoufanOrder;
import com.youfan.utils.KafkaUtils;
import com.youfan.utils.ObjectCopyToUtils;
import com.youfan.utils.ObjectToMapUtils;
import com.youfan.utils.RedisUtils;
import org.apache.flink.api.common.functions.MapFunction;

import java.util.Map;

public class TradeOrderMap implements MapFunction<String,String> {

    @Override
    public String map(String s) throws Exception {
        YoufanOrder youfanOrder = JSONObject.parseObject(s, YoufanOrder.class);
        long productId = youfanOrder.getProductId();
        if(productId<0){
            return null;
        }
        int orderstatus = youfanOrder.getOrderstatus();// '0已提交 1已支付 2已取消 3已删除
        String orderStatusName = orderstatus==0?"已提交":orderstatus==1?"已支付":orderstatus==2?"已取消":"已删除";//
        int paystatus = youfanOrder.getPaystatus();// '0未支付 1已支付 2 已退款',
        String payStatusName = paystatus==0?"未支付":paystatus==1?"已支付":"已退款";//
        int paytype = youfanOrder.getPaytype();// '0支付宝 1银联 2 微信',
        String paytypeName = paytype==0?"支付宝": paytype==1?"银联":"微信";
        YoufanOrderDwd youfanOrderDwd = new YoufanOrderDwd();
        ObjectCopyToUtils.copyto(youfanOrder,youfanOrderDwd);
        youfanOrderDwd.setOrderStatusName(orderStatusName);
        youfanOrderDwd.setPayStatusName(payStatusName);
        youfanOrderDwd.setPaytypeName(paytypeName);
        KafkaUtils.sendData("tradeorderdwd",s);
        KafkaUtils.sendData("productinfodwm",s);
        RedisUtils.addScoreData("productinfotopicName",0.0d,s);
        return null;
    }

}
