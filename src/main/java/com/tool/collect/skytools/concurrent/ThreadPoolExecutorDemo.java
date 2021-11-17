package com.tool.collect.skytools.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @Descriiption
 * @Author bo
 * @Date 2021/10/18 下午5:26
 **/
public class ThreadPoolExecutorDemo {
	public static void main(String[] args) throws Exception{
		//fixThreadPoolDemo();
		//cachedThreadPoolDemo();
		//singleThreadPoolDemo;

		final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(new MyRunnable(), 3, 1, TimeUnit.SECONDS);
		final Future<?> future = executor.submit(new MyRunnable());
		future.get();
	}


	/**
	 * 外面用FinalizableDelegatedExecutorService包了一层，实际上还是通过ThreadPoolExecutor执行任务，
	 * 效果与Executors.newFixedThreadPool(1)一样的，不知道包一层的目的是啥
	 */
	private static void singleThreadPoolDemo() {
		final ExecutorService executor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			executor.execute(new MyRunnable());
		}
	}

	/**
	 * 使用SynchronousQueue无缓冲等待队列实现，不存储任务，put/offer任务时，如果没有线程take/poll任务，则阻塞，需要等待take/poll线程唤醒
	 * 通过put线程和take线程配对的方式获取任务
	 * SynchronousQueue默认非公平模式，即后入先出
	 */
	private static void cachedThreadPoolDemo() {
		final ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			try {
				executor.execute(new MyRunnable());
				//executor.submit()
				TimeUnit.SECONDS.sleep(1);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	private static void fixThreadPoolDemo() {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
		for (int i = 0; i < 10; i++) {
			executor.execute(new MyRunnable());
		}
		executor.shutdown();
		System.out.println("任务已经全部添加到队列线程池");
	}

	static class MyRunnable implements Runnable {
		@Override
		public void run() {
			System.out.println("执行线程" + Thread.currentThread());
			try {
				TimeUnit.SECONDS.sleep(1);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


}
