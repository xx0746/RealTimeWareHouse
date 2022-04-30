package com.youfan.analy;

import com.youfan.map.dwd.ProductCartdwdMap;
import com.youfan.map.dwd.TradeOrderDwdMap;
import com.youfan.reduce.ProductCartStatitisReduce;
import com.youfan.reduce.TradeOrderReduce;
import com.youfan.sink.ProductCartStatitisSink;
import com.youfan.sink.TradeOrderdwmSink;
import com.youfan.trade.order.dwm.YouFanOrderDwmDay;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class TradedwdAnaly {

    public static void main(String[] args) {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.enableCheckpointing(5000);
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "192.168.37.163:9092");
        properties.setProperty("group.id", "youfananaly");
        //构建FlinkKafkaConsumer
        FlinkKafkaConsumer<String> myConsumer = new FlinkKafkaConsumer<String>("tradeorderdwd", new SimpleStringSchema(), properties);
//        //指定偏移量
        myConsumer.setStartFromLatest();


        DataStream<String> stream = env
                .addSource(myConsumer);
        DataStream<YouFanOrderDwmDay> mapstream  = stream.map(new TradeOrderDwdMap());
        DataStream<YouFanOrderDwmDay> reducestream =  mapstream.keyBy("groupField").timeWindow(Time.hours(1l)).reduce(new TradeOrderReduce());
        reducestream.addSink(new TradeOrderdwmSink());
        try {
            env.execute("TradedwdAnaly");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
