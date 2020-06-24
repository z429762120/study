package com.tool.collect.skytools.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Descriiption
 * @Author bo
 * @Date 2020/1/15 上午11:35
 **/
public class ConsumerDemo {
    static final String kafkaServer="47.106.87.193:9092";
    static final String kafkaServer1="192.168.0.241:9092,192.168.0.242:9092,192.168.0.243:9092";


    public static void main(String[] args) throws InterruptedException {
        Properties properties = new Properties();
        properties.put("bootstrap.servers",kafkaServer);
        properties.put("group.id", "sky");
        //session.timeout.ms：消费者在被认为死亡之前可以与服务器断开连接的时间，默认是3s 。
        properties.put("session.timeout.ms", "30000");
        //消费者是否自动提交偏移量，默认值是true,避免出现重复数据和数据丢失，可以把它设为 false。
        properties.put("enable.auto.commit", "false");
        properties.put("auto.commit.interval.ms", "1000");
        //auto.offset.reset:消费者在读取一个没有偏移量的分区或者偏移量无效的情况下的处理
        //earliest：在偏移量无效的情况下，消费者将从起始位置读取分区的记录。
        //latest：在偏移量无效的情况下，消费者将从最新位置读取分区的记录
        properties.put("auto.offset.reset", "earliest");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        // max.partition.fetch.bytes：服务器从每个分区里返回给消费者的最大字节数
        //fetch.max.wait.ms:消费者等待时间，默认是500。
        // fetch.min.bytes:消费者从服务器获取记录的最小字节数。
        // client.id：该参数可以是任意的字符串，服务器会用它来识别消息的来源。
        // max.poll.records:用于控制单次调用 call （） 方住能够返回的记录数量
        //receive.buffer.bytes和send.buffer.bytes：指定了 TCP socket 接收和发送数据包的缓冲区大小，默认值为-1

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties);
        kafkaConsumer.subscribe(Arrays.asList("ttt"), new MyConsumerRebalanceListener());
        try {
            while (true) {
                Map<TopicPartition, OffsetAndMetadata> offsets = new HashMap<>();
                ConsumerRecords<String, String> records = kafkaConsumer.poll(3);
                for (ConsumerRecord<String, String> record : records) {
                    TopicPartition partition = new TopicPartition(record.topic(), record.partition());
                    OffsetAndMetadata metadata = new OffsetAndMetadata(record.offset()+1, "no metadata");
                    offsets.put(partition, metadata);
                }
                kafkaConsumer.commitAsync(offsets,null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            kafkaConsumer.commitSync();
        }

    }

}
