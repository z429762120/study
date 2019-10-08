package com.tool.collect.skytools;

import com.tool.collect.skytools.rabbitmq.RabbitmqSender;
import com.tool.collect.skytools.support.constant.ExchangeConstant;
import com.tool.collect.skytools.support.constant.RoutingKeyConstants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Descriiption
 * @Author bo
 * @Date 2019/4/4 下午5:48
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class JunitTest {
    @Autowired
    RabbitmqSender rabbitmqSender;

    @Test
    public void testRabbitmq() {
        rabbitmqSender.send(ExchangeConstant.TOPIC_EXCHANGE, RoutingKeyConstants.TEST_KEY, "你好");
    }

}
