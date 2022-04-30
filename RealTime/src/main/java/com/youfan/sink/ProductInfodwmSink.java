package com.youfan.sink;

import com.alibaba.fastjson.JSONObject;
import com.youfan.enums.YeWuType;
import com.youfan.liuLiang.log.dwm.ProductCartStatitisDay;
import com.youfan.product.dwm.ProductInfoDwm;
import com.youfan.utils.DorisDbUtils;
import com.youfan.utils.KafkaUtils;
import com.youfan.utils.ObjectToMapUtils;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ProductInfodwmSink implements SinkFunction<ProductInfoDwm> {

    @Override
    public void invoke(ProductInfoDwm value, Context context) throws Exception {
        Map data = ObjectToMapUtils.transferToMap(value);
        Set<String> intField = new HashSet<String>();
        intField.add("productTypeid");
        intField.add("shopid");
        intField.add("merchatid");
        intField.add("numbers");
        intField.add("tradenumbes");
        DorisDbUtils.insertdata("ProductInfoDwm",data,intField);
        KafkaUtils.sendData("productInfoDws", JSONObject.toJSONString(value));
    }
}
