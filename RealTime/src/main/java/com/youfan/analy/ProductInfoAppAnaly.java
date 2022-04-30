package com.youfan.analy;

import com.youfan.map.app.ProductInfoAnalyMap;
import com.youfan.map.app.TradeAnalyMap;
import com.youfan.map.dwd.ProductInfoDwdMap;
import com.youfan.product.app.ProductinfoApp;
import com.youfan.product.dwd.ProductInfoDwd;
import com.youfan.reduce.ProductInfoAnalyReduce;
import com.youfan.reduce.TradeAnalyReduce;
import com.youfan.sink.TradeanalySink;
import com.youfan.sink.productInfoAppanalySink;
import com.youfan.trade.order.app.TradeApp;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class ProductInfoAppAnaly {

    public static void main(String[] args) {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.enableCheckpointing(5000);
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "192.168.37.163:9092");
        properties.setProperty("group.id", "youfananaly");
        //构建FlinkKafkaConsumer
        FlinkKafkaConsumer<String> myConsumer = new FlinkKafkaConsumer<String>("Productinfoapp", new SimpleStringSchema(), properties);
//        //指定偏移量
        myConsumer.setStartFromLatest();


        DataStream<String> stream = env
                .addSource(myConsumer);
        DataStream<ProductinfoApp> mapstream  = stream.map(new ProductInfoAnalyMap());
        DataStream<ProductinfoApp>  reducestream = mapstream.keyBy("dateTimeString").timeWindow(Time.hours(1l)).reduce(new ProductInfoAnalyReduce());
        reducestream.addSink(new productInfoAppanalySink());
        try {
            env.execute("ProductInfoAppAnaly");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
