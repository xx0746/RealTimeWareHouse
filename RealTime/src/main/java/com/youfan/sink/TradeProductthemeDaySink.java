package com.youfan.sink;

import com.alibaba.fastjson.JSONObject;
import com.youfan.enums.ThemeType;
import com.youfan.liuLiang.log.dws.ProductthemeDay;
import com.youfan.trade.order.dws.TradeProductthemeDay;
import com.youfan.utils.DorisDbUtils;
import com.youfan.utils.KafkaUtils;
import com.youfan.utils.ObjectToMapUtils;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TradeProductthemeDaySink implements SinkFunction<TradeProductthemeDay> {

    @Override
    public void invoke(TradeProductthemeDay value, Context context) throws Exception {
        Map data = ObjectToMapUtils.transferToMap(value);
        Set<String> intField = new HashSet<String>();

        intField.add("productId");
        intField.add("productTypeId");
        intField.add("status");
        intField.add("usernums");
        intField.add("numbers");

        intField.add("shopnumbers");

        intField.add("merchartnumbers");

        DorisDbUtils.insertdata("TradeProductthemeDay",data,intField);
        value.setThemeType(ThemeType.PRODUCT);
        KafkaUtils.sendData("tradeapp", JSONObject.toJSONString(value));
    }
}
