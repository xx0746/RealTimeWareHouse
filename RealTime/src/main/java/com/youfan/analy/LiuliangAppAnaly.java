package com.youfan.analy;

import com.youfan.liuLiang.log.app.Diveceanaly;
import com.youfan.liuLiang.log.app.ProductCartanaly;
import com.youfan.map.app.DiveceanalyMap;
import com.youfan.map.app.ProductCartanalyMap;
import com.youfan.map.ods.AppOdsMap;
import com.youfan.reduce.DiveceanalyReduce;
import com.youfan.reduce.ProductCartanalyReduce;
import com.youfan.reduce.UserthemeDayReduce;
import com.youfan.sink.DiveceanalySink;
import com.youfan.sink.ProductCartanalySink;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class LiuliangAppAnaly {

    public static void main(String[] args) {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.enableCheckpointing(5000);
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "192.168.37.163:9092");
        properties.setProperty("group.id", "youfananaly1111");
        //构建FlinkKafkaConsumer
        FlinkKafkaConsumer<String> myConsumer = new FlinkKafkaConsumer<String>("liuliangapp", new SimpleStringSchema(), properties);
//        //指定偏移量
        myConsumer.setStartFromEarliest();


        DataStream<String> stream = env
                .addSource(myConsumer);
        DataStream<ProductCartanaly> mapstreamProductCart  = stream.map(new ProductCartanalyMap());
        DataStream<ProductCartanaly>  reduceProductcart = mapstreamProductCart.keyBy("groupField").timeWindow(Time.seconds(1l)).reduce(new ProductCartanalyReduce());
        DataStream<Diveceanaly> mapstreamDivece  = stream.map(new DiveceanalyMap());
        DataStream<Diveceanaly>  reduceDivece = mapstreamDivece.keyBy("groupField").timeWindow(Time.seconds(1l)).reduce(new DiveceanalyReduce());
        reduceProductcart.addSink(new ProductCartanalySink());
        reduceDivece.addSink(new DiveceanalySink());
        try {
            env.execute("LiuliangAppOdsAnaly");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
