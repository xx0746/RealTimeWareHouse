package com.youfan.map.dwm;

import com.alibaba.fastjson.JSONObject;
import com.youfan.liuLiang.log.dwd.ProductCartLog;
import com.youfan.liuLiang.log.dwd.ProductLog;
import com.youfan.liuLiang.log.dwm.ProductCartStatitisDay;
import com.youfan.liuLiang.log.dwm.ProductStatitisDay;
import com.youfan.utils.DateUtils;
import com.youfan.utils.MathUtils;
import org.apache.flink.api.common.functions.MapFunction;

import java.util.Date;

public class ProductStatitisdwmMap implements MapFunction<String, ProductStatitisDay> {

    @Override
    public ProductStatitisDay map(String s) throws Exception {
        ProductLog productLog = JSONObject.parseObject(s, ProductLog.class);
        String userId = productLog.getUserId();
         String scantimedateString = productLog.getScantime();

      String deviceType = productLog.getDeviceType();
      String deviceId = productLog.getDeviceId();
       String pindaoId = productLog .getPindaoId();
       String productTypeId = productLog.getProductTypeId();
       String productId =productLog.getProductTypeId();
        String jumpTime = productLog.getJumpTime();
        String scanTime = productLog.getScantime();
        long scanTimetotals =  MathUtils.betweenTime(scanTime,jumpTime);

        ProductStatitisDay producStatitisDay = new ProductStatitisDay();
        producStatitisDay.setUserId(userId );
        Date scanTimedate = new Date(Long.valueOf(scantimedateString));
        String dayTime = DateUtils.transferDate(scanTimedate,"yyyyMMdd");
        producStatitisDay.setScanTime(scanTimedate);
        producStatitisDay.setDeviceType(deviceType);
        producStatitisDay.setDeviceId(deviceId);
        producStatitisDay.setPindaoId(pindaoId);
        producStatitisDay.setProductTypeId(productTypeId);
        producStatitisDay.setProductId(productId);

        String groupField = "productdwm=="+userId+"=="+dayTime+"=="+deviceType+"=="+deviceId
                +"=="+pindaoId+"=="+productTypeId+"=="+productId;
        producStatitisDay.setGroupField(groupField);

        producStatitisDay.setScantimes(1l);
        producStatitisDay.setScanTimetotals(scanTimetotals);

        return  producStatitisDay;
    }

}
