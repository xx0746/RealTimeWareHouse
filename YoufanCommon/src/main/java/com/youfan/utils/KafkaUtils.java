package com.youfan.utils;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class KafkaUtils {
    private static Properties getProps(){
        Properties properties = new Properties();
        properties.put("bootstrap.servers","192.168.37.163:9092");
        properties.put("acks","all");
        properties.put("retries",2);
        properties.put("linger.ms",1000);
        properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        return properties;
    }

    public static void sendData(String tableName,String data){
        KafkaProducer<String,String> producer = new KafkaProducer<String, String>(getProps());
        ProducerRecord<String,String> record = new ProducerRecord<String, String>(tableName,data);
        Future<RecordMetadata> recordMetadata = producer.send(record);
        try {
            RecordMetadata recordMeta = recordMetadata.get();
            System.out.println("topic:"+recordMeta.topic());
            System.out.println("partition:"+recordMeta.partition());
            System.out.println("offset:"+recordMeta.offset());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        KafkaUtils.sendData("youfanorder","haha");
    }

}
