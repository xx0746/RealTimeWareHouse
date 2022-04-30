package com.youfan.sink;

import com.alibaba.fastjson.JSONObject;
import com.youfan.enums.ThemeType;
import com.youfan.liuLiang.log.dws.UserthemeDay;
import com.youfan.trade.order.dws.TradeUserthemeDay;
import com.youfan.utils.DorisDbUtils;
import com.youfan.utils.KafkaUtils;
import com.youfan.utils.ObjectToMapUtils;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TradeUserthemeDaySink implements SinkFunction<TradeUserthemeDay> {

    @Override
    public void invoke(TradeUserthemeDay value, Context context) throws Exception {
        Map data = ObjectToMapUtils.transferToMap(value);
        Set<String> intField = new HashSet<String>();

        intField.add("userId");
        intField.add("productTypeId");
        intField.add("status");
        intField.add("productnums");
        intField.add("numbers");

        intField.add("shopnumbers");

        intField.add("totalAmount");

        DorisDbUtils.insertdata("TradeUserthemeDay",data,intField);
        value.setThemeType(ThemeType.USER);
        KafkaUtils.sendData("tradeapp", JSONObject.toJSONString(value));
    }
}
