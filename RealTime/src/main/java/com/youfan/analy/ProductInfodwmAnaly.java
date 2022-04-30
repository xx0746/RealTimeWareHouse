package com.youfan.analy;

import com.youfan.map.dwd.TradeOrderDwdMap;
import com.youfan.map.dwm.ProductInfodwmMap;
import com.youfan.product.dwm.ProductInfoDwm;
import com.youfan.reduce.ProductInfodwmReduce;
import com.youfan.reduce.TradeOrderReduce;
import com.youfan.sink.ProductInfodwmSink;
import com.youfan.sink.TradeOrderdwmSink;
import com.youfan.trade.order.dwm.YouFanOrderDwmDay;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class ProductInfodwmAnaly {

    public static void main(String[] args) {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.enableCheckpointing(5000);
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "192.168.37.163:9092");
        properties.setProperty("group.id", "youfananaly");
        //构建FlinkKafkaConsumer
        FlinkKafkaConsumer<String> myConsumer = new FlinkKafkaConsumer<String>("productinfodwm", new SimpleStringSchema(), properties);
//        //指定偏移量
        myConsumer.setStartFromLatest();


        DataStream<String> stream = env
                .addSource(myConsumer);
        DataStream<ProductInfoDwm> mapstream  = stream.map(new ProductInfodwmMap());
        DataStream<ProductInfoDwm> reducestream =  mapstream.keyBy("groupField").timeWindow(Time.hours(1l)).reduce(new ProductInfodwmReduce());
        reducestream.addSink(new ProductInfodwmSink());
        try {
            env.execute("ProductInfodwmAnaly");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
