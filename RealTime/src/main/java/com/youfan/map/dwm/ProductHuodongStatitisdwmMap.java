package com.youfan.map.dwm;

import com.alibaba.fastjson.JSONObject;
import com.youfan.liuLiang.log.dwd.ProductCartLog;
import com.youfan.liuLiang.log.dwd.ProductHuodongLog;
import com.youfan.liuLiang.log.dwm.ProductCartStatitisDay;
import com.youfan.liuLiang.log.dwm.ProducthuodongStatitisDay;
import com.youfan.utils.DateUtils;
import com.youfan.utils.MathUtils;
import org.apache.flink.api.common.functions.MapFunction;

import java.util.Date;

public class ProductHuodongStatitisdwmMap implements MapFunction<String, ProducthuodongStatitisDay> {

    @Override
    public ProducthuodongStatitisDay map(String s) throws Exception {
        ProductHuodongLog productHuodongLog = JSONObject.parseObject(s, ProductHuodongLog.class);
        String userId = productHuodongLog.getUserId();
         String scantimeString = productHuodongLog.getScantime();

      String deviceType = productHuodongLog.getDeviceType();
      String deviceId = productHuodongLog.getDeviceId();
       String huodongId = productHuodongLog.getHuodongId();
       String jumpTime = productHuodongLog.getJumpTime();
       String scanTime = productHuodongLog.getScantime();
       long scanTimetotals =  MathUtils.betweenTime(scanTime,jumpTime);
        ProducthuodongStatitisDay producthuodongStatitisDay = new ProducthuodongStatitisDay();

        producthuodongStatitisDay.setUserId(userId );
        Date scantimedate = new Date(Long.valueOf(scantimeString));
        String dayTime = DateUtils.transferDate(scantimedate,"yyyyMMdd");
        producthuodongStatitisDay.setScanTime(scantimedate);
        producthuodongStatitisDay.setDeviceType(deviceType);
        producthuodongStatitisDay.setDeviceId(deviceId);
        producthuodongStatitisDay.setHuodongId(huodongId);
        producthuodongStatitisDay.setScantimes(1l);
        producthuodongStatitisDay.setScanTimetotals(scanTimetotals);

        String groupField = "producthuodongdwm=="+userId+"=="+dayTime+"=="+deviceType+"=="+deviceId
                +"=="+huodongId;
        producthuodongStatitisDay.setGroupField(groupField);

        return   producthuodongStatitisDay;
    }

}
