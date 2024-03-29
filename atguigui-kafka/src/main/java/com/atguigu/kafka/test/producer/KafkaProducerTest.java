package com.atguigu.kafka.test.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.HashMap;
import java.util.Map;

public class KafkaProducerTest {
    public static void main(String[] args) {

        //TODO: 创建配置对象
        Map<String,Object> configMap = new HashMap<>();
        configMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        // TODO: 对生产的数据K,V进行序列化的操作
        configMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        configMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        //TODO:创建生产者对象
        //      生产者对象需要设定泛型：数据的类型约束
        KafkaProducer<String,String> producer = new KafkaProducer<String,String>(configMap);

        //TODO:创建数据
        //      构建数据时，需要传递三个参数
        //      第一个参数表示主题的名称
        //      第二个参数表示数据的KEY
        //      第三个参数表示数据的VALUE
        ProducerRecord<String,String> record = new ProducerRecord<String,String>(
                "test","key","value"
        );

        //TODO: 通过生产者对象将数据发送到 Kafka
        producer.send(record);

        //TODO: 关闭生产者对象
        producer.close();
    }

}
