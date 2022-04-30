package com.youfan.sink;

import com.alibaba.fastjson.JSONObject;
import com.youfan.enums.YeWuType;
import com.youfan.liuLiang.log.dwm.ProductCartStatitisDay;
import com.youfan.liuLiang.log.dwm.ProductStatitisDay;
import com.youfan.utils.DorisDbUtils;
import com.youfan.utils.KafkaUtils;
import com.youfan.utils.ObjectToMapUtils;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ProductStatitisSink implements SinkFunction<ProductStatitisDay> {

    @Override
    public void invoke(ProductStatitisDay value, Context context) throws Exception {
        Map data = ObjectToMapUtils.transferToMap(value);
        Set<String> intField = new HashSet<String>();
        intField.add("scantimes");
        intField.add("scanTimetotals");
        intField.add("avgTime");
        DorisDbUtils.insertdata("ProductStatitis",data,intField);
        value.setYeWuType(YeWuType.PRODUCT);
        KafkaUtils.sendData("liuliangdws", JSONObject.toJSONString(value));
    }
}
