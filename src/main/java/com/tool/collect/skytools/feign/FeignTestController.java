package com.tool.collect.skytools.feign;

import com.alibaba.fastjson.JSONObject;
import com.ywkj.base.bean.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Descriiption
 * @Author bo
 * @Date 2019/10/8 下午2:28
 **/
@Slf4j
@RestController
@RequestMapping("test")
public class FeignTestController {
    ExecutorService service = Executors.newFixedThreadPool(50);
    @Autowired
    DemoClientApi demoClientApi;
   /* @Autowired
    TestClientApi testClientApi;*/

    @GetMapping("feignClient")
    public Long feignClient(String personIds,String token) throws Exception{
        CountDownLatch latch = new CountDownLatch(50);
        new Thread(new printTime(latch)).start();
        for (int j = 0; j < 50; j++) {
            service.execute(()->{
                String threadName = Thread.currentThread().getName();
                long start = System.currentTimeMillis();
                for (int i = 0; i < 10; i++) {
                    long start11 = System.currentTimeMillis();

                    ResponseResult<List<JSONObject>> responseResult = demoClientApi.findPerson(personIds,token);
                    long end11 = System.currentTimeMillis() - start11;
                    if (responseResult.isSuccess()) {
                        log.info("threadName={} 第{}次请求成功,耗时{}ms", threadName,i,end11);
                    } else {
                        log.error("threadName={} 第{}次请求失败,耗时{}ms", threadName,i,end11);
                    }
                }
                long end = System.currentTimeMillis();
                long time = end - start;
                System.out.println("线程"+threadName+"耗时" + time + "毫秒");
                latch.countDown();
            });
        }

        return 1L;
    }


    public static class printTime implements Runnable {
        CountDownLatch latch ;
        public printTime(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            try {
                latch.await();
                long total = System.currentTimeMillis() - start;
                System.out.println(String.format("总共耗时%s毫秒", total));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
