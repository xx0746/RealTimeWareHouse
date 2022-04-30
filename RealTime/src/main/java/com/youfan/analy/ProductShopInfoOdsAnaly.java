package com.youfan.analy;

import com.youfan.map.ods.ProductTypeInfoMap;
import com.youfan.map.ods.ShopInfoMap;
import com.youfan.map.ods.TradeOrderMap;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class ProductShopInfoOdsAnaly {

    public static void main(String[] args) {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.enableCheckpointing(5000);
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "192.168.37.163:9092");
        properties.setProperty("group.id", "youfananaly");
        //构建FlinkKafkaConsumer
        FlinkKafkaConsumer<String> myConsumer = new FlinkKafkaConsumer<String>("shopinfo", new SimpleStringSchema(), properties);
//        //指定偏移量
        myConsumer.setStartFromLatest();


        DataStream<String> stream = env
                .addSource(myConsumer);
        DataStream<String> mapstream  = stream.map(new ShopInfoMap());

        try {
            env.execute("ProductShopInfoOdsAnaly");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
