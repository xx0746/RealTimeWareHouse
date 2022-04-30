package com.youfan.sink;

import com.alibaba.fastjson.JSONObject;
import com.youfan.enums.ThemeType;
import com.youfan.liuLiang.log.app.ProductCartanaly;
import com.youfan.utils.DorisDbUtils;
import com.youfan.utils.KafkaUtils;
import com.youfan.utils.ObjectToMapUtils;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ProductCartanalySink implements SinkFunction<ProductCartanaly> {

    @Override
    public void invoke(ProductCartanaly value, Context context) throws Exception {
        Map data = ObjectToMapUtils.transferToMap(value);
        Set<String> intField = new HashSet<String>();
        data.remove("groupField");
        intField.add("pv");
        intField.add("uv");
        intField.add("productnums");
        DorisDbUtils.insertdata("ProductCartanaly",data,intField);
    }
}
