package com.youfan.sink;

import com.youfan.liuLiang.log.app.Diveceanaly;
import com.youfan.product.app.ProductinfoApp;
import com.youfan.utils.DorisDbUtils;
import com.youfan.utils.ObjectToMapUtils;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class productInfoAppanalySink implements SinkFunction<ProductinfoApp> {

    @Override
    public void invoke(ProductinfoApp value, Context context) throws Exception {
        Map data = ObjectToMapUtils.transferToMap(value);
        Set<String> intField = new HashSet<String>();
        intField.add("productnumbers");
        intField.add("producttradenumbes");
        intField.add("merchantnumbers");
        intField.add("merchantshopnubmers");
        DorisDbUtils.insertdata("productinfoApp",data,intField);
    }
}
