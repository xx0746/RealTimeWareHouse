package com.youfan.sink;

import com.alibaba.fastjson.JSONObject;
import com.youfan.enums.ThemeType;
import com.youfan.enums.YeWuType;
import com.youfan.liuLiang.log.dws.UserthemeDay;
import com.youfan.utils.DorisDbUtils;
import com.youfan.utils.KafkaUtils;
import com.youfan.utils.ObjectToMapUtils;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UserthemeDaySink implements SinkFunction<UserthemeDay> {

    @Override
    public void invoke(UserthemeDay value, Context context) throws Exception {
        Map data = ObjectToMapUtils.transferToMap(value);
        data.remove("groupField");
        Set<String> intField = new HashSet<String>();
        intField.add("devicenums");

        intField.add("deviceTypenumbers");
        intField.add("operatornumbers");
        intField.add("scanhuodongnums");

        intField.add("scanproudctnums");

        intField.add("scanproducttypenums");
        intField.add("scanpingdaonums");
        intField.add("scanproducttotal");
        DorisDbUtils.insertdata("userthemeDay",data,intField);
        value.setThemeType(ThemeType.USER);
        KafkaUtils.sendData("liuliangapp", JSONObject.toJSONString(value));
    }
}
