package com.youfan.analy;

import com.youfan.map.dwd.ProductInfoDwdMap;
import com.youfan.map.dwd.ProductdwdMap;
import com.youfan.map.dwd.TradeOrderDwdMap;
import com.youfan.product.dwd.ProductInfoDwd;
import com.youfan.reduce.TradeOrderReduce;
import com.youfan.sink.TradeOrderdwmSink;
import com.youfan.trade.order.dwm.YouFanOrderDwmDay;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class ProductInfodwdAnaly {

    public static void main(String[] args) {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.enableCheckpointing(5000);
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "192.168.37.163:9092");
        properties.setProperty("group.id", "youfananaly");
        //构建FlinkKafkaConsumer
        FlinkKafkaConsumer<String> myConsumer = new FlinkKafkaConsumer<String>("productdwd", new SimpleStringSchema(), properties);
//        //指定偏移量
        myConsumer.setStartFromLatest();


        DataStream<String> stream = env
                .addSource(myConsumer);
        DataStream<ProductInfoDwd> mapstream  = stream.map(new ProductInfoDwdMap());
        try {
            env.execute("ProductInfodwdAnaly");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
