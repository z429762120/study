package com.tool.collect.skytools;

import com.tool.collect.skytools.hystrix.GetProductCommand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @Descriiption
 * @Author bo
 * @Date 2020/1/17 上午10:03
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class HystrixTest {


    @Test
    public void circuitBreakerTest() throws Exception{
        for (int i = 0; i < 30; i++) {
            GetProductCommand command = new GetProductCommand((long) i);
            command.execute();
        }
        TimeUnit.SECONDS.sleep(3);

        for (int i = 31; i < 40; i++) {
            GetProductCommand command = new GetProductCommand((long) i);
            command.execute();
            System.out.println( "responseFromFallback: " + command.isResponseFromFallback() + ".isCircuitBreakerOpen:" + command.isCircuitBreakerOpen());
            TimeUnit.MILLISECONDS.sleep(500);
        }
    }

}
