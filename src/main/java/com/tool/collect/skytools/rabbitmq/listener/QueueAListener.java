package com.tool.collect.skytools.rabbitmq.listener;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

import java.nio.charset.StandardCharsets;

/**
 * @Descriiption
 * @Author bo
 * @Date 2019/4/10 上午11:28
 **/
@Slf4j
public class QueueAListener implements ChannelAwareMessageListener {
    private static int count = 0;
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {

        String body = new String(message.getBody(), StandardCharsets.UTF_8);
        ++count;
        System.out.println("queueA收到消息次数=" + count);
        System.out.println("queueA收到消息" + body);

    }

}
