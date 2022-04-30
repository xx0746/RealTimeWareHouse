package com.youfan.analy;

import com.youfan.liuLiang.log.app.Diveceanaly;
import com.youfan.liuLiang.log.app.ProductCartanaly;
import com.youfan.map.app.DiveceanalyMap;
import com.youfan.map.app.ProductCartanalyMap;
import com.youfan.map.app.TradeAnalyMap;
import com.youfan.reduce.DiveceanalyReduce;
import com.youfan.reduce.ProductCartanalyReduce;
import com.youfan.reduce.TradeAnalyReduce;
import com.youfan.sink.DiveceanalySink;
import com.youfan.sink.ProductCartanalySink;
import com.youfan.sink.TradeanalySink;
import com.youfan.trade.order.app.TradeApp;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class TradeAppAnaly {

    public static void main(String[] args) {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.enableCheckpointing(5000);
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "192.168.37.163:9092");
        properties.setProperty("group.id", "youfananaly");
        //构建FlinkKafkaConsumer
        FlinkKafkaConsumer<String> myConsumer = new FlinkKafkaConsumer<String>("tradeapp", new SimpleStringSchema(), properties);
//        //指定偏移量
        myConsumer.setStartFromLatest();


        DataStream<String> stream = env
                .addSource(myConsumer);
        DataStream<TradeApp> mapstream  = stream.map(new TradeAnalyMap());
        DataStream<TradeApp>  reducestream = mapstream.keyBy("gourpField").timeWindow(Time.hours(1l)).reduce(new TradeAnalyReduce());
        reducestream.addSink(new TradeanalySink());
        try {
            env.execute("TradeAppAnaly");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
