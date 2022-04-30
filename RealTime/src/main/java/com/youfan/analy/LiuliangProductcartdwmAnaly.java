package com.youfan.analy;

import com.youfan.liuLiang.log.dwm.ProductCartStatitisDay;
import com.youfan.map.dwd.ProductCartdwdMap;
import com.youfan.map.dwm.ProductCartStatitisdwmMap;
import com.youfan.reduce.ProductCartStatitisReduce;
import com.youfan.sink.ProductCartStatitisSink;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class LiuliangProductcartdwmAnaly {

    public static void main(String[] args) {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.enableCheckpointing(5000);
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "192.168.37.163:9092");
        properties.setProperty("group.id", "youfananaly11");
        //构建FlinkKafkaConsumer
        FlinkKafkaConsumer<String> myConsumer = new FlinkKafkaConsumer<String>("productcartdwm", new SimpleStringSchema(), properties);
//        //指定偏移量
        myConsumer.setStartFromEarliest();


        DataStream<String> stream = env
                .addSource(myConsumer);
        DataStream<ProductCartStatitisDay> mapstream  = stream.map(new ProductCartStatitisdwmMap());
        DataStream<ProductCartStatitisDay> reducestream = mapstream.keyBy("groupField").timeWindow(Time.seconds(5)).reduce(new ProductCartStatitisReduce());
        reducestream.addSink(new ProductCartStatitisSink());
        try {
            env.execute("LiuliangProductcartdwmAnaly");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
