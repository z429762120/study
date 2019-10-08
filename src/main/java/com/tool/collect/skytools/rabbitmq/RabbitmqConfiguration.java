package com.tool.collect.skytools.rabbitmq;


import com.tool.collect.skytools.rabbitmq.listener.QueueAListener;
import com.tool.collect.skytools.support.constant.ExchangeConstant;
import com.tool.collect.skytools.support.constant.QueueConstant;
import com.tool.collect.skytools.support.constant.RoutingKeyConstants;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


/**
 * @Descriiption
 * @Author bo
 * @Date 2019/3/18 上午11:35
 **/
@Configuration
@ConditionalOnProperty(value = "spring.rabbitmq.enabled", havingValue = "true")
public class RabbitmqConfiguration {
    @Autowired
    ConnectionFactory connectionFactory;

    /**
     * 声明队列
     *
     * @return
     */
    @Bean
    public Queue QueueA() {
        return new Queue(QueueConstant.TEST_A);
    }

    @Bean
    public Queue QueueB() {
        return new Queue(QueueConstant.TEST_B);
    }

    /**
     * 延迟队列(设置消息过期时间,消费者不监听该队列,消息过期后路由到超时队列,执行超时后的逻辑)
     * @return
     */
    @Bean
    public Queue delayQueue(){
        Map<String, Object> arguments = new HashMap<>();
        //arguments.put("x-message-ttl", 30 * 1000);//队列消息过期时间
        arguments.put("x-dead-letter-exchange", "exchangeName");//消息过期后路由的交换机
        arguments.put("x-dead-letter-routing-key", "routingKey");//消息过期后路由的key
        return new Queue("queueName", true, false, false, arguments);
    }

    /**
     * 广播交换机，绑定了该交换机的队列都能收到消息
     * FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
     * HeadersExchange ：通过添加属性key-value匹配
     * DirectExchange:按照routingkey分发到指定队列
     * TopicExchange:多关键字匹配
     *
     * @return
     */
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(ExchangeConstant.FANOUT_EXCHANGE);
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(ExchangeConstant.TOPIC_EXCHANGE);
    }

    /**
     * 绑定队列与交换机
     *
     * @return
     */
    @Bean
    Binding bindingFanoutExchange() {
        return BindingBuilder.bind(QueueA()).to(fanoutExchange());
    }
    @Bean
    Binding bindingTopicExchange() {
        return BindingBuilder.bind(QueueB()).to(topicExchange()).with(RoutingKeyConstants.TEST_KEY);
    }

    /**
     * 绑定监听队列
     *
     * @return
     */
    @Bean
    public SimpleMessageListenerContainer QueueAListenerContainer() {

        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setQueues(QueueA());
        container.setConcurrentConsumers(1);//最小的并发消费者的数量
        container.setMaxConcurrentConsumers(10);//设置最大的并发的消费者数量
        container.setExposeListenerChannel(true);//暴露channel
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);//设置确认模式手工确认
        container.setMessageListener(new MessageListenerAdapter(new QueueAListener()));//设置监听器
        return container;
    }
}
