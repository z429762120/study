package com.tool.collect.skytools.CompletableFuture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Descriiption
 * @Author bo
 * @Date 2020/1/9 下午5:03
 **/
public class CompletableFutureTestTest {

    public static final ExecutorService executor = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws Exception {
        List<Future> futures = new ArrayList<>();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        for (Integer i : list) {
            System.out.println(i+"begin");
            CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
                try {
                    Thread.sleep(1000L);
                    String threadname = Thread.currentThread().getName()+"xh"+i;
                    return threadname;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "执行出错";
            }, executor);
            futures.add(future);
        }

        futures.stream().forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

    }
}
