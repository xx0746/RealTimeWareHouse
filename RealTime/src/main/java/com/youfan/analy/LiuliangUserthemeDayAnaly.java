package com.youfan.analy;

import com.youfan.liuLiang.log.dwm.ProducthuodongStatitisDay;
import com.youfan.liuLiang.log.dws.UserthemeDay;
import com.youfan.map.dwd.ProductCartdwdMap;
import com.youfan.map.dwm.ProductHuodongStatitisdwmMap;
import com.youfan.map.dws.UserthemeDayMap;
import com.youfan.reduce.ProductHuodongStatitisReduce;
import com.youfan.reduce.UserthemeDayReduce;
import com.youfan.sink.ProductHuodongStatitisSink;
import com.youfan.sink.UserthemeDaySink;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class LiuliangUserthemeDayAnaly {

    public static void main(String[] args) {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.enableCheckpointing(5000);
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "192.168.37.163:9092");
        properties.setProperty("group.id", "youfananaly33");
        //构建FlinkKafkaConsumer
        FlinkKafkaConsumer<String> myConsumer = new FlinkKafkaConsumer<String>("liuliangdws", new SimpleStringSchema(), properties);
//        //指定偏移量
        myConsumer.setStartFromEarliest();


        DataStream<String> stream = env
                .addSource(myConsumer);
        DataStream<UserthemeDay> mapstream  = stream.map(new UserthemeDayMap());
        DataStream<UserthemeDay> reducestream = mapstream.keyBy("groupField").timeWindow(Time.seconds(5)).reduce(new UserthemeDayReduce());
        reducestream.addSink(new UserthemeDaySink());

        try {
            env.execute("LiuliangUserthemeDayAnaly");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
