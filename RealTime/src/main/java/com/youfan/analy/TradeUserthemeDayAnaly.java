package com.youfan.analy;

import com.youfan.liuLiang.log.dws.UserthemeDay;
import com.youfan.map.dws.TradeUserthemeDayMap;
import com.youfan.map.dws.UserthemeDayMap;
import com.youfan.reduce.TradeUserthemeDayReduce;
import com.youfan.reduce.UserthemeDayReduce;
import com.youfan.sink.TradeUserthemeDaySink;
import com.youfan.sink.UserthemeDaySink;
import com.youfan.trade.order.dws.TradeUserthemeDay;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class TradeUserthemeDayAnaly {

    public static void main(String[] args) {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.enableCheckpointing(5000);
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "192.168.37.163:9092");
        properties.setProperty("group.id", "youfananaly");
        //构建FlinkKafkaConsumer
        FlinkKafkaConsumer<String> myConsumer = new FlinkKafkaConsumer<String>("youfanorderdwm", new SimpleStringSchema(), properties);
//        //指定偏移量
        myConsumer.setStartFromLatest();


        DataStream<String> stream = env
                .addSource(myConsumer);
        DataStream<TradeUserthemeDay> mapstream  = stream.map(new TradeUserthemeDayMap());
        DataStream<TradeUserthemeDay> reducestream = mapstream.keyBy("groupField").timeWindow(Time.hours(1l)).reduce(new TradeUserthemeDayReduce());
        reducestream.addSink(new TradeUserthemeDaySink());

        try {
            env.execute("TradeUserthemeDayAnaly");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
