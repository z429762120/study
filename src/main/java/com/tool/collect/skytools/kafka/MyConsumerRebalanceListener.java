package com.tool.collect.skytools.kafka;

import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.common.TopicPartition;

import java.util.Collection;

/**
 * @Descriiption 再均衡监听器
 * @Author bo
 * @Date 2020/3/30 下午3:50
 **/
//@Component
public class MyConsumerRebalanceListener implements ConsumerRebalanceListener {
    /**
     * 再均衡开始之前和消费者停止读取消息之后被调用，可通过此监听在再均衡之前提交偏移量
     */
    @Override
    public void onPartitionsRevoked(Collection<TopicPartition> partitions) {

    }

    /**
     * 重新分配分区之后和消费者开始读取消息之前被调用。
     */
    @Override
    public void onPartitionsAssigned(Collection<TopicPartition> partitions) {

    }
}
