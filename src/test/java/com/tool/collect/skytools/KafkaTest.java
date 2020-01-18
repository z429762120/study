package com.tool.collect.skytools;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @Descriiption
 * @Author bo
 * @Date 2020/1/17 上午10:03
 **/
@SpringBootTest(classes={SkytoolsApplication.class})
@RunWith(SpringRunner.class)
public class KafkaTest {
    @Autowired
    KafkaTemplate kafkaTemplate;

    @Test
    public void test1(){
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("ttt", "123");

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("发送失败");
            }

            @Override
            public void onSuccess(SendResult<String, String> sendResult) {
                RecordMetadata metadata = sendResult.getRecordMetadata();
                System.out.println(String.format("发送成功，offset=%s,partition=%s",metadata.offset(),metadata.partition()));
            }
        });
    }

    @Test
    public void test2(){
        kafkaTemplate.send("ttt", "fafds");
    }
}
