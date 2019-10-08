package com.tool.collect.skytools.rabbitmq.listener;

import com.rabbitmq.client.Channel;
import com.tool.collect.skytools.support.constant.QueueConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @Descriiption
 * @Author bo
 * @Date 2019/4/10 上午11:28
 **/
@Slf4j
@Component
public class QueueBListener {

    @RabbitListener(queues = QueueConstant.TEST_B)
    public void onMessage(Message message, Channel channel) throws Exception {

        String body = new String(message.getBody(), StandardCharsets.UTF_8);
        System.out.println("queueB收到消息" + body);

    }

}
