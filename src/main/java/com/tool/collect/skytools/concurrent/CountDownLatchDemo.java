package com.tool.collect.skytools.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 主线程等待其他一个或者多个线程执行完成之后再执行
 * @Descriiption
 * @Author bo
 * @Date 2021/10/14 下午2:16
 **/
public class CountDownLatchDemo {

	public static void main(String[] args)throws Exception {
		CountDownLatch countDownLatch = new CountDownLatch(2);
		final MyThread myThread1 = new MyThread(countDownLatch);
		final MyThread myThread2 = new MyThread(countDownLatch);
		myThread1.start();
		myThread2.start();
		countDownLatch.await();
		System.out.println(String.format("主线程等待线程【%s】、【%s】执行完成之后执行......",myThread1.getName(),myThread2.getName()));
		System.out.println("主线程执行任务完成");

	}

	static class MyThread extends Thread {
		CountDownLatch countDownLatch;

		MyThread(CountDownLatch countDownLatch) {
			this.countDownLatch = countDownLatch;
		}

		@Override
		public void run() {
			System.out.println("线程"+Thread.currentThread()+"执行任务完成......");
			try {
				TimeUnit.SECONDS.sleep(1L);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			countDownLatch.countDown();
		}
	}

}
