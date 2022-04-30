package com.youfan.analy;

import com.youfan.map.dws.MerchantinfothemeDayMap;
import com.youfan.product.dwm.ProductInfoDwm;
import com.youfan.product.dws.MerchatnubmerThemeDws;
import com.youfan.reduce.MerchatnubmerThemeDwsReduce;
import com.youfan.reduce.ProductInfodwmReduce;
import com.youfan.sink.MerchartinfodwsthemeDaySink;
import com.youfan.sink.ProductInfodwmSink;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class ProductInfoMerchantThmedwsAnaly {

    public static void main(String[] args) {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.enableCheckpointing(5000);
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "192.168.37.163:9092");
        properties.setProperty("group.id", "youfananaly");
        //构建FlinkKafkaConsumer
        FlinkKafkaConsumer<String> myConsumer = new FlinkKafkaConsumer<String>("productInfoDws", new SimpleStringSchema(), properties);
//        //指定偏移量
        myConsumer.setStartFromLatest();


        DataStream<String> stream = env
                .addSource(myConsumer);
        DataStream<MerchatnubmerThemeDws> mapstream  = stream.map(new MerchantinfothemeDayMap());
        DataStream<MerchatnubmerThemeDws> reducestream =  mapstream.keyBy("groupField").timeWindow(Time.hours(1l)).reduce(new MerchatnubmerThemeDwsReduce());
        reducestream.addSink(new MerchartinfodwsthemeDaySink());
        try {
            env.execute("ProductInfoMerchantThmedwsAnaly");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
