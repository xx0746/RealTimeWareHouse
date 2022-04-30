package com.youfan.sink;

import com.alibaba.fastjson.JSONObject;
import com.youfan.enums.YeWuType;
import com.youfan.liuLiang.log.dwm.ProductStatitisDay;
import com.youfan.trade.order.dwm.YouFanOrderDwmDay;
import com.youfan.utils.DorisDbUtils;
import com.youfan.utils.KafkaUtils;
import com.youfan.utils.ObjectToMapUtils;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TradeOrderdwmSink implements SinkFunction<YouFanOrderDwmDay> {

    @Override
    public void invoke(YouFanOrderDwmDay value, Context context) throws Exception {
        Map data = ObjectToMapUtils.transferToMap(value);
        Set<String> intField = new HashSet<String>();
        intField.add("userId");
        intField.add("productId");
        intField.add("shopId");
        intField.add("producttypeId");
        intField.add("merchartId");

        intField.add("orderstatus");
        intField.add("paystatus");
        intField.add("payType");

        intField.add("numbers");

        intField.add("orderAmountTotal");
        intField.add("orderAmountAvg");
        intField.add("payAmountTotal");
        intField.add("payAmountAvg");

        DorisDbUtils.insertdata("YouFanOrderDwmDay",data, intField);
        KafkaUtils.sendData("youfanorderdwm", JSONObject.toJSONString(value));
    }
}
