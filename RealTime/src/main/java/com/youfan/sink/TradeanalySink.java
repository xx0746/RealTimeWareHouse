package com.youfan.sink;

import com.youfan.liuLiang.log.app.Diveceanaly;
import com.youfan.trade.order.app.TradeApp;
import com.youfan.utils.DorisDbUtils;
import com.youfan.utils.ObjectToMapUtils;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TradeanalySink implements SinkFunction<TradeApp> {

    @Override
    public void invoke(TradeApp value, Context context) throws Exception {
        Map data = ObjectToMapUtils.transferToMap(value);
        Set<String> intField = new HashSet<String>();
        intField.add("usernumser");
        intField.add("totalAmount");
        intField.add("productnumser");

        intField.add("ordernumbers");

        DorisDbUtils.insertdata("TradeApp",data,intField);
    }
}
