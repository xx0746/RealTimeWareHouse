package com.youfan.sink;

import com.alibaba.fastjson.JSONObject;
import com.youfan.enums.YeWuType;
import com.youfan.liuLiang.log.dwm.ProductCartStatitisDay;
import com.youfan.utils.DorisDbUtils;
import com.youfan.utils.KafkaUtils;
import com.youfan.utils.ObjectToMapUtils;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ProductCartStatitisSink implements SinkFunction<ProductCartStatitisDay> {


    @Override
    public void invoke(ProductCartStatitisDay value, Context context) throws Exception {
        System.out.println("进入ProductCartStatitisSink");
        Map data = ObjectToMapUtils.transferToMap(value);
        data.remove("groupField");
        Set<String> intField = new HashSet<String>();
        intField.add("operatorTimes");
        DorisDbUtils.insertdata("ProductCartStatitis",data,intField);
        value.setYeWuType(YeWuType.PRODUCTCART);
        KafkaUtils.sendData("liuliangdws", JSONObject.toJSONString(value));
    }
}
