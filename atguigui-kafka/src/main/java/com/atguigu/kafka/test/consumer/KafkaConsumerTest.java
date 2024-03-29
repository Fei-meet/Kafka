package com.atguigu.kafka.test.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.*;


public class KafkaConsumerTest {
    public static void main(String[] args) {

        //TODO: 创建配置对象
        Map<String,Object> consumerConfig = new HashMap<>();
        consumerConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        consumerConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        consumerConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        consumerConfig.put(ConsumerConfig.GROUP_ID_CONFIG,"atguigu");

        //TODO: 创建消费者对象
        KafkaConsumer<String,String> consumer = new KafkaConsumer<String,String>(consumerConfig);

        //TODO: 订阅主题
        consumer.subscribe(Collections.singletonList("test"));

        //TODO: 从kafka主题中获取数据
        //      消费者从kafka中拉取数据

        while ( true ){
            final ConsumerRecords<String, String> dates = consumer.poll(100);
            for (ConsumerRecord<String, String> date : dates) {
                System.out.println(date);
            }
        }

        //TODO: 关闭消费者对象
        //consumer.close();

    }
}
