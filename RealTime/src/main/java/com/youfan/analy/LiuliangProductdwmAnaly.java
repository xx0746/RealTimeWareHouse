package com.youfan.analy;

import com.youfan.liuLiang.log.dwm.ProductCartStatitisDay;
import com.youfan.liuLiang.log.dwm.ProductStatitisDay;
import com.youfan.map.dwm.ProductCartStatitisdwmMap;
import com.youfan.map.dwm.ProductStatitisdwmMap;
import com.youfan.reduce.ProductCartStatitisReduce;
import com.youfan.reduce.ProductStatitisReduce;
import com.youfan.sink.ProductCartStatitisSink;
import com.youfan.sink.ProductStatitisSink;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class LiuliangProductdwmAnaly {

    public static void main(String[] args) {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.enableCheckpointing(5000);
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "192.168.37.163:9092");
        properties.setProperty("group.id", "youfananaly");
        //构建FlinkKafkaConsumer
        FlinkKafkaConsumer<String> myConsumer = new FlinkKafkaConsumer<String>("productdwm", new SimpleStringSchema(), properties);
//        //指定偏移量
        myConsumer.setStartFromEarliest();


        DataStream<String> stream = env
                .addSource(myConsumer);
        DataStream<ProductStatitisDay> mapstream  = stream.map(new ProductStatitisdwmMap());
        DataStream<ProductStatitisDay> reducestream = mapstream.keyBy("groupField").timeWindow(Time.hours(1l)).reduce(new ProductStatitisReduce());
        reducestream.addSink(new ProductStatitisSink());
        try {
            env.execute("LiuliangProductdwmAnaly");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
