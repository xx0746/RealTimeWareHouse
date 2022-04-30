package com.youfan.analy;

import com.youfan.liuLiang.log.dwm.ProductCartStatitisDay;
import com.youfan.liuLiang.log.dwm.ProducthuodongStatitisDay;
import com.youfan.map.dwm.ProductCartStatitisdwmMap;
import com.youfan.map.dwm.ProductHuodongStatitisdwmMap;
import com.youfan.reduce.ProductCartStatitisReduce;
import com.youfan.reduce.ProductHuodongStatitisReduce;
import com.youfan.sink.ProductCartStatitisSink;
import com.youfan.sink.ProductHuodongStatitisSink;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class LiuliangProducthuodongdwmAnaly {

    public static void main(String[] args) {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.enableCheckpointing(5000);
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "192.168.37.163:9092");
        properties.setProperty("group.id", "youfananaly");
        //构建FlinkKafkaConsumer
        FlinkKafkaConsumer<String> myConsumer = new FlinkKafkaConsumer<String>("productHuoDongdwm", new SimpleStringSchema(), properties);
//        //指定偏移量
        myConsumer.setStartFromLatest();


        DataStream<String> stream = env
                .addSource(myConsumer);
        DataStream<ProducthuodongStatitisDay> mapstream  = stream.map(new ProductHuodongStatitisdwmMap());
        DataStream<ProducthuodongStatitisDay> reducestream = mapstream.keyBy("groupField").timeWindow(Time.hours(1l)).reduce(new ProductHuodongStatitisReduce());
        reducestream.addSink(new ProductHuodongStatitisSink());
        try {
            env.execute("LiuliangProducthuodongdwmAnaly");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
