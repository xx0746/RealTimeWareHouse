package com.youfan.analy;

import com.youfan.liuLiang.log.dws.ProductthemeDay;
import com.youfan.map.dws.ProductthemeDayMap;
import com.youfan.map.dws.TradeProductthemeDayMap;
import com.youfan.reduce.ProductthemeDayReduce;
import com.youfan.reduce.TradeProductthemeDayReduce;
import com.youfan.sink.ProductthemeDaySink;
import com.youfan.sink.TradeProductthemeDaySink;
import com.youfan.trade.order.dws.TradeProductthemeDay;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class TradeProductthemeDayAnaly {

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
        DataStream<TradeProductthemeDay> mapstream  = stream.map(new TradeProductthemeDayMap());
        DataStream<TradeProductthemeDay> reducestream = mapstream.keyBy("groupField").timeWindow(Time.hours(1l)).reduce(new TradeProductthemeDayReduce());
        reducestream.addSink(new TradeProductthemeDaySink());

        try {
            env.execute("TradeProductthemeDayAnaly");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
