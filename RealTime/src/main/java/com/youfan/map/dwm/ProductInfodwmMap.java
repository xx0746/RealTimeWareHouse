package com.youfan.map.dwm;

import com.alibaba.fastjson.JSONObject;
import com.youfan.liuLiang.log.dwd.ProductLog;
import com.youfan.liuLiang.log.dwm.ProductStatitisDay;
import com.youfan.product.dwd.ProductInfoDwd;
import com.youfan.product.dwm.ProductInfoDwm;
import com.youfan.trade.order.ods.YoufanOrder;
import com.youfan.utils.DateUtils;
import com.youfan.utils.MathUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.flink.api.common.functions.MapFunction;

import java.util.Date;

public class ProductInfodwmMap implements MapFunction<String, ProductInfoDwm> {

    @Override
    public ProductInfoDwm map(String s) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(s);
        String shopname = jsonObject.getString("shopname");
        if(StringUtils.isBlank(shopname)){//订单信息
            YoufanOrder youfanOrder = JSONObject.parseObject(s,YoufanOrder.class);
            Date dateTime = youfanOrder.getCreateTime();
            String dateTimeString = DateUtils.transferDate(dateTime,"yyyyMMdd");
            long merchatid = youfanOrder.getMerchartId();
            long producttypeid = youfanOrder.getProductTypeId();
            long shopId = youfanOrder.getShopId();
            long number = youfanOrder.getNumber();
            ProductInfoDwm productInfoDwm = new ProductInfoDwm();
            productInfoDwm.setMerchatid(merchatid);
            productInfoDwm.setProductTypeid(producttypeid);
            productInfoDwm.setShopid(shopId);
            productInfoDwm.setDateTime(dateTime);
            productInfoDwm.setDateTimeString(dateTimeString);
            productInfoDwm.setGroupField("productinfodwm=="+merchatid+"=="+producttypeid+"=="+shopId+"=="+dateTimeString);
            productInfoDwm.setTradenumbes(number);
            return productInfoDwm;
        }else{//商品信息
            ProductInfoDwd productInfoDwd = JSONObject.parseObject(s,ProductInfoDwd.class);
            long merchatid = productInfoDwd.getMerchatid();
            long producttypeid = productInfoDwd.getProductTypeid();
            long shopId = productInfoDwd.getShopid();
            Date dateTime = productInfoDwd.getCreateTime();
            String dateTimeString = DateUtils.transferDate(dateTime,"yyyyMMdd");
            ProductInfoDwm productInfoDwm = new ProductInfoDwm();
            productInfoDwm.setMerchatid(merchatid);
            productInfoDwm.setProductTypeid(producttypeid);
            productInfoDwm.setShopid(shopId);
            productInfoDwm.setDateTime(dateTime);
            productInfoDwm.setDateTimeString(dateTimeString);
            productInfoDwm.setGroupField("productinfodwm=="+merchatid+"=="+producttypeid+"=="+shopId+"=="+dateTimeString);
            productInfoDwm.setNumbers(1l);
            return productInfoDwm;

        }

    }

}
