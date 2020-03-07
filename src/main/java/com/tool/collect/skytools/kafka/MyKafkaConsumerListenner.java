package com.tool.collect.skytools.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;

import java.util.List;

/**
 * @Descriiption
 * @Author bo
 * @Date 2020/1/17 下午3:52
 **/
//@Component
public class MyKafkaConsumerListenner {

    /**
     * 如果启动批量提交，参数只接收list,AckMode={MANUAL,MANUAL_IMMEDIATE}模式下才能手动提交offset
     * @param list
     * @param ack
     * @throws Exception
     */
    @KafkaListener(topics = {"ttt"},containerFactory = "defaultKafkaListenerContainerFactory")
    public void message1(List<ConsumerRecord> list, Acknowledgment ack) throws Exception {
        System.out.println(String.format("拉取消息%d条", list.size()));
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (ConsumerRecord<?, ?> consumerRecord : list) {
            System.out.println(consumerRecord);
        }
        ack.acknowledge();
    }

    /**
     * 如果启动批量提交，AckMode={RECORD,BATCH,TIME,COUNT,COUNT_TIME}模式下不能手动提交offset
     * @param list
     * @throws Exception
     */
    //@KafkaListener(topics = {"ttt"})
    public void message1(List<ConsumerRecord> list) throws Exception {
        System.out.println(String.format("拉取消息%d条", list.size()));
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (ConsumerRecord<?, ?> consumerRecord : list) {
            System.out.println(consumerRecord);
        }
    }

    @KafkaListener(topics = {"ttt"})
    public void message1(ConsumerRecord record) throws Exception {
        System.out.println(String.format("拉取消息1条"));
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(record);

    }
}
