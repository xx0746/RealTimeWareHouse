package com.youfan.sink;

import com.alibaba.fastjson.JSONObject;
import com.youfan.enums.YeWuType;
import com.youfan.liuLiang.log.dwm.ProductCartStatitisDay;
import com.youfan.liuLiang.log.dwm.ProducthuodongStatitisDay;
import com.youfan.utils.DorisDbUtils;
import com.youfan.utils.KafkaUtils;
import com.youfan.utils.ObjectToMapUtils;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ProductHuodongStatitisSink implements SinkFunction<ProducthuodongStatitisDay> {

    @Override
    public void invoke(ProducthuodongStatitisDay value, Context context) throws Exception {
        Map data = ObjectToMapUtils.transferToMap(value);
        Set<String> intField = new HashSet<String>();
        intField.add("scantimes");
        intField.add("scanTimetotals");
        intField.add("avgTime");
        DorisDbUtils.insertdata("ProducthuodongStatitis",data,intField);
        value.setYeWuType(YeWuType.PRODUCTHUODONG);
        KafkaUtils.sendData("liuliangdws", JSONObject.toJSONString(value));
    }
}
