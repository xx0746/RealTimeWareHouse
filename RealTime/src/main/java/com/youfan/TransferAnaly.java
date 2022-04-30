package com.youfan;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.youfan.utils.KafkaUtils;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class TransferAnaly {
    public static void main(String[] args) {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.enableCheckpointing(5000);
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "192.168.37.163:9092");
        properties.setProperty("group.id", "youfananaly");
        //构建FlinkKafkaConsumer
        FlinkKafkaConsumer<String> myConsumer = new FlinkKafkaConsumer<String>("test11", new SimpleStringSchema(), properties);
//        //指定偏移量
        myConsumer.setStartFromLatest();


        DataStream<String> stream = env
                .addSource(myConsumer);
        DataStream<String> filterMap  = stream.filter(new FilterFunction<String>() {
            @Override
            public boolean filter(String s) throws Exception {
                JSONObject jsonObject = JSONObject.parseObject(s);
                String type = jsonObject.getString("type");
                if("INSERT".equals(type)){
                    return  true;
                }
                return false;
            }
        });

        DataStream<String> mapStream  =  filterMap.map(new MapFunction<String, String>() {
            @Override
            public String map(String s) throws Exception {
                JSONObject jsonObject = JSONObject.parseObject(s);
                String tableName = jsonObject.getString("table");
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                JSONObject jsonObject1 = jsonArray.getJSONObject(0);
                JSONObject jsonObjectfinal = new JSONObject();
                jsonObjectfinal.put("tableName",tableName);
                jsonObjectfinal.put("data",JSONObject.toJSONString(jsonObject1));
                return JSONObject.toJSONString(jsonObjectfinal);
            }
        });
        mapStream.addSink(new SinkFunction<String>() {
            @Override
            public void invoke(String value) throws Exception {
                JSONObject jsonObject = JSONObject.parseObject(value);
                String tableName = jsonObject.getString("tableName");
                 String data = jsonObject.getString("data");
                KafkaUtils.sendData(tableName,data);
            }
        });

        try {
            env.execute("TransferAnaly");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
