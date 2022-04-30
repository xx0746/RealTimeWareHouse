package com.youfan.analy;

import com.youfan.liuLiang.log.dws.ProductthemeDay;
import com.youfan.liuLiang.log.dws.UserthemeDay;
import com.youfan.map.dwd.ProductCartdwdMap;
import com.youfan.map.dws.ProductthemeDayMap;
import com.youfan.map.dws.UserthemeDayMap;
import com.youfan.reduce.ProductthemeDayReduce;
import com.youfan.reduce.UserthemeDayReduce;
import com.youfan.sink.ProductthemeDaySink;
import com.youfan.sink.UserthemeDaySink;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class LiuliangProductthemeDayAnaly {

    public static void main(String[] args) {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.enableCheckpointing(5000);
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "192.168.37.163:9092");
        properties.setProperty("group.id", "youfananaly");
        //构建FlinkKafkaConsumer
        FlinkKafkaConsumer<String> myConsumer = new FlinkKafkaConsumer<String>("liuliangdws", new SimpleStringSchema(), properties);
//        //指定偏移量
        myConsumer.setStartFromEarliest();


        DataStream<String> stream = env
                .addSource(myConsumer);
        DataStream<ProductthemeDay> mapstream  = stream.map(new ProductthemeDayMap());
        DataStream<ProductthemeDay> reducestream = mapstream.keyBy("groupField").timeWindow(Time.seconds(5)).reduce(new ProductthemeDayReduce());
        reducestream.addSink(new ProductthemeDaySink());

        try {
            env.execute("LiuliangProductthemeDayAnaly");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
