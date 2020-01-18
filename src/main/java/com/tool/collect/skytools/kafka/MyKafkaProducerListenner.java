package com.tool.collect.skytools.kafka;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListenerAdapter;
import org.springframework.stereotype.Component;

/**
 * @Descriiption 生产者监听器
 * @Author bo
 * @Date 2020/1/17 下午3:27
 **/
@Component
public class MyKafkaProducerListenner extends ProducerListenerAdapter {

    @Override
    public void onSuccess(String topic, Integer partition, Object key, Object value, RecordMetadata recordMetadata) {
        super.onSuccess(topic, partition, key, value, recordMetadata);
        System.out.println(
                String.format("message send success,topic=%s,partition=%s,offset=%s,value=%s", topic, partition, recordMetadata.offset(), value));
    }

    @Override
    public void onError(String topic, Integer partition, Object key, Object value, Exception exception) {
        super.onError(topic, partition, key, value, exception);
        System.out.println(
                String.format("message send fail,topic=%s,partition=%s,value=%s,exception=%s", topic, partition, value,exception));

    }

    /**
     * true 消息发送成功才会有通知
     * @return
     */
    @Override
    public boolean isInterestedInSuccess() {
        return true;
    }
}
