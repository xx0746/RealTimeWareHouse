package com.youfan.map.dwd;

import com.alibaba.fastjson.JSONObject;
import com.youfan.trade.order.dwd.YoufanOrderDwd;
import com.youfan.trade.order.dwm.YouFanOrderDwmDay;
import com.youfan.trade.order.ods.YoufanOrder;
import com.youfan.utils.DateUtils;
import com.youfan.utils.KafkaUtils;
import com.youfan.utils.ObjectCopyToUtils;
import org.apache.flink.api.common.functions.MapFunction;

import java.util.Date;

public class TradeOrderDwdMap implements MapFunction<String,YouFanOrderDwmDay> {

    @Override
    public YouFanOrderDwmDay map(String s) throws Exception {
        YoufanOrderDwd youfanOrderDwd = JSONObject.parseObject(s, YoufanOrderDwd.class);
        Date createTime = youfanOrderDwd.getCreateTime();
       long  userId = youfanOrderDwd.getUserId();
       long productTypeId = youfanOrderDwd.getProductTypeId();
  long productId = youfanOrderDwd.getProductId();
  long shopId = youfanOrderDwd.getShopId();
        long merchartId = youfanOrderDwd.getMerchartId();
        int orderstatus = youfanOrderDwd.getOrderstatus();
      int paystatus = youfanOrderDwd.getPaystatus();
    int payType = youfanOrderDwd.getPaytype() ;
         long numbers = 1;
        double orderAmountTotal = youfanOrderDwd.getOrderAmount();
      double payAmountTotal = youfanOrderDwd.getPayAmount();


        YouFanOrderDwmDay youFanOrderDwmDay = new YouFanOrderDwmDay();
        youFanOrderDwmDay.setUserId(userId);
        youFanOrderDwmDay.setProductId(productId);
        youFanOrderDwmDay.setShopId(shopId);
        youFanOrderDwmDay.setMerchartId(merchartId);
        youFanOrderDwmDay.setOrderstatus(orderstatus);
        youFanOrderDwmDay.setPaystatus(paystatus);
        youFanOrderDwmDay.setPayType(payType);
        youFanOrderDwmDay.setNumbers(numbers);
        youFanOrderDwmDay.setOrderAmountTotal(orderAmountTotal);
        youFanOrderDwmDay.setPayAmountTotal(payAmountTotal);
        youFanOrderDwmDay.setProducttypeId(productTypeId);
        Date timeDate = createTime;
        String timeDateString = DateUtils.transferDate(timeDate,"yyyyMMdd");
        youFanOrderDwmDay.setTimeDate(timeDate);
        youFanOrderDwmDay.setTimeDateString(timeDateString);

        String groupField = "TradeOrderDwd=="+timeDateString+"=="+userId+"=="+productTypeId+"=="+productId+"=="+shopId+"=="+merchartId+"=="+orderstatus+"=="+paystatus+"=="+payType;


        youFanOrderDwmDay.setGroupField(groupField);

        return youFanOrderDwmDay;
    }

}
