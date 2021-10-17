package com.tool.collect.skytools.concurrent;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *
 * @Descriiption 可以将一个任务给不同的线程/机器执行，谁先执行完毕就用谁的结果
 * @Author bo
 * @Date 2021/10/14 下午5:02
 **/
public class SemaphoreDemo2 {
	public static void main(String[] args) throws Exception {
		Semaphore semaphore = new Semaphore(0);
		for (int i = 0; i < 2; i++) {
			new Thread(()->{
				try {
					System.out.println("将任务分配给不同的机器.....");
					final int sleepTime = 1 + new Random().nextInt(5);
					System.out.println("线程【" + Thread.currentThread() + "】耗时" + sleepTime);
					TimeUnit.SECONDS.sleep(sleepTime);
					semaphore.release();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();
		}
		semaphore.acquire();
		System.out.println("一台机器已经执行完毕了，可以获取结果");
	}

}
