package com.tool.collect.skytools.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @Descriiption
 * @Author bo
 * @Date 2019/4/10 上午11:50
 **/
@Component
public class RabbitmqSender {
    @Autowired
    AmqpTemplate amqpTemplate;


    /**
     * 默认使用directExchange交换器
     *
     * @param routingKey
     * @param context
     */
    public void send(String routingKey, String context) {
        this.amqpTemplate.convertAndSend(routingKey, context);
    }

    /**
     * 指定交换机，路由
     * @param exchange
     * @param routingKey
     * @param object
     */
    public void send(String exchange, String routingKey, Object object) {
        this.amqpTemplate.convertAndSend(exchange, routingKey, object);
    }

    /**
     * 发送延迟消息
     * 需要指定消息等延迟时间
     * @param msg
     * @throws Exception
     */
    public void delaySendDelay(String msg) throws Exception {
        MessageProperties properties = new MessageProperties();
        properties.setExpiration(String.valueOf(1233444));
        Message message = new Message(msg.getBytes(StandardCharsets.UTF_8), properties);
        amqpTemplate.convertAndSend("delayExchangeName", "delayQueueName", message);
    }

}
