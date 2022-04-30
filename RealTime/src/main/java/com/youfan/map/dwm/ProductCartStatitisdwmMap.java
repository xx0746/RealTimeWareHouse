package com.youfan.map.dwm;

import com.alibaba.fastjson.JSONObject;
import com.youfan.enums.LogType;
import com.youfan.liuLiang.log.AppProductCartLog;
import com.youfan.liuLiang.log.LogParent;
import com.youfan.liuLiang.log.PcProductCartLog;
import com.youfan.liuLiang.log.XiaoChenXuProductCartLog;
import com.youfan.liuLiang.log.dwd.ProductCartLog;
import com.youfan.liuLiang.log.dwm.ProductCartStatitisDay;
import com.youfan.utils.*;
import org.apache.flink.api.common.functions.MapFunction;

import java.util.Date;
import java.util.Map;

public class ProductCartStatitisdwmMap implements MapFunction<String,ProductCartStatitisDay> {

    @Override
    public ProductCartStatitisDay map(String s) throws Exception {
        ProductCartLog productCartLog = JSONObject.parseObject(s, ProductCartLog.class);
        String userId = productCartLog.getUserId();
         String operatorTimedateString = productCartLog.getOperatorTime();

      String deviceType = productCartLog.getDeviceType();
      String deviceId = productCartLog.getDeviceId();
       String pindaoId = productCartLog.getPindaoId();
       String productTypeId = productCartLog.getProductTypeId();
       String productId = productCartLog.getProductTypeId();
       String  operatorType = productCartLog.getOperatorType();
        ProductCartStatitisDay productCartStatitisDay = new ProductCartStatitisDay();
        productCartStatitisDay.setUserId(userId );
        Date operatorTimedate = new Date(Long.valueOf(operatorTimedateString));
        String dayTime = DateUtils.transferDate(operatorTimedate,"yyyyMMdd");
        productCartStatitisDay.setOperatorTimedate(operatorTimedate);
        productCartStatitisDay.setDeviceType(deviceType);
        productCartStatitisDay.setDeviceId(deviceId);
        productCartStatitisDay.setPindaoId(pindaoId);
        productCartStatitisDay.setProductTypeId(productTypeId);
        productCartStatitisDay.setProductId(productId);
        productCartStatitisDay.setOperatorType(operatorType);
        String groupField = "productcartdwm=="+userId+"=="+dayTime+"=="+deviceType+"=="+deviceId
                +"=="+pindaoId+"=="+productTypeId+"=="+productId+"=="+operatorType;
        productCartStatitisDay.setGroupField(groupField);
        productCartStatitisDay.setOperatorTimes(1l);

        return  productCartStatitisDay;
    }

}
