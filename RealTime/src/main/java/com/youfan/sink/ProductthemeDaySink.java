package com.youfan.sink;

import com.alibaba.fastjson.JSONObject;
import com.youfan.enums.ThemeType;
import com.youfan.liuLiang.log.dws.ProductthemeDay;
import com.youfan.utils.DorisDbUtils;
import com.youfan.utils.KafkaUtils;
import com.youfan.utils.ObjectToMapUtils;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ProductthemeDaySink implements SinkFunction<ProductthemeDay> {

    @Override
    public void invoke(ProductthemeDay value, Context context) throws Exception {
        Map data = ObjectToMapUtils.transferToMap(value);
        data.remove("groupField");
        Set<String> intField = new HashSet<String>();
        intField.add("devicenums");
        intField.add("operatornums");
        intField.add("scanproducttotal");

        intField.add("scanproducttotaltime");
        intField.add("scanproductavgtime");
        intField.add("usernums");
        DorisDbUtils.insertdata("productthemeDay",data,intField);
        value.setThemeType(ThemeType.PRODUCT);
        KafkaUtils.sendData("liuliangapp", JSONObject.toJSONString(value));
    }
}
