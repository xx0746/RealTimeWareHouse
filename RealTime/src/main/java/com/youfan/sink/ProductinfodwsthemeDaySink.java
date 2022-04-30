package com.youfan.sink;

import com.alibaba.fastjson.JSONObject;
import com.youfan.enums.ThemeType;
import com.youfan.liuLiang.log.dws.ProductthemeDay;
import com.youfan.product.dws.ProductThemeDws;
import com.youfan.utils.DorisDbUtils;
import com.youfan.utils.KafkaUtils;
import com.youfan.utils.ObjectToMapUtils;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ProductinfodwsthemeDaySink implements SinkFunction<ProductThemeDws> {

    @Override
    public void invoke(ProductThemeDws value, Context context) throws Exception {
        Map data = ObjectToMapUtils.transferToMap(value);
        Set<String> intField = new HashSet<String>();
        intField.add("productTypeid");
        intField.add("shopnubmers");
        intField.add("merchatnumbers");

        intField.add("numbers");
        intField.add("tradenumbes");

        DorisDbUtils.insertdata("productThemeDws",data,intField);
        value.setThemeType(ThemeType.PRODUCT);
        KafkaUtils.sendData("Productinfoapp", JSONObject.toJSONString(value));
    }
}
