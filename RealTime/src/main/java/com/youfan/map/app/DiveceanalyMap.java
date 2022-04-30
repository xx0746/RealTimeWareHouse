package com.youfan.map.app;

import com.alibaba.fastjson.JSONObject;
import com.youfan.liuLiang.log.app.Diveceanaly;
import com.youfan.liuLiang.log.app.ProductCartanaly;
import com.youfan.liuLiang.log.dws.ProductthemeDay;
import com.youfan.liuLiang.log.dws.UserthemeDay;
import com.youfan.utils.DateUtils;
import org.apache.flink.api.common.functions.MapFunction;

import java.util.Date;

public class DiveceanalyMap implements MapFunction<String, Diveceanaly> {
    @Override
    public Diveceanaly map(String s) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(s);
        String themeType = jsonObject.getString("themeType");
        Diveceanaly diveceanaly = new Diveceanaly();
        if("USER".equals(themeType)){//USER,//用户主题
            UserthemeDay userthemeDay = JSONObject.parseObject(s,UserthemeDay.class);
            String deviceType = userthemeDay.getDeviceType();
            Date dateTime = userthemeDay.getDateTime();
            long deviceTypenumbers = userthemeDay.getDeviceTypenumbers();
            String dateTimeString = DateUtils.transferDate(dateTime,"yyyyMMdd");
            diveceanaly.setDiveceType(deviceType);
            diveceanaly.setPv(deviceTypenumbers);
            diveceanaly.setDateTime(dateTime);
            diveceanaly.setDateTimeString(dateTimeString);
            diveceanaly.setUv(1l);
            String groupField = "Diveceanaly=="+deviceType+"=="+dateTimeString;
            diveceanaly.setGroupField(groupField);

        }else if("PRODUCT".equals(themeType)){//PRODUCT,//商品主题
            ProductthemeDay productthemeDay = JSONObject.parseObject(s,ProductthemeDay.class);
            String deviceType = productthemeDay.getDeviceType();
            Date dateTime = productthemeDay.getDateTime();
            String dateTimeString = DateUtils.transferDate(dateTime,"yyyyMMdd");
            diveceanaly.setDiveceType(deviceType);
            diveceanaly.setDateTime(dateTime);
            diveceanaly.setDateTimeString(dateTimeString);
            diveceanaly.setProductnums(1l);
            String groupField = "Diveceanaly=="+deviceType+"=="+dateTimeString;
            diveceanaly.setGroupField(groupField);
        }
        return diveceanaly;
    }
}
