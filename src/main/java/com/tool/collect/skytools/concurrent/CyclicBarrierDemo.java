package com.tool.collect.skytools.concurrent;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 *
 * @Descriiption 可以多个线程等到某一个状态一起执行
 * @Author bo
 * @Date 2021/10/14 下午2:47
 **/
public class CyclicBarrierDemo {

	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
			@Override
			public void run() {
				System.out.println("其他线程都执行到某一个状态了");
			}
		});
		for (int i = 0; i < 9; i++) {
			new MyThread(cyclicBarrier).start();
			new MyThread(cyclicBarrier).start();
			new MyThread(cyclicBarrier).start();
		}

	}

	static class MyThread extends Thread {
		CyclicBarrier cyclicBarrier;

		MyThread(CyclicBarrier cyclicBarrier) {
			this.cyclicBarrier = cyclicBarrier;
		}

		@Override
		public void run() {
			System.out.println("线程"+Thread.currentThread()+"准备数据中......");
			try {
				TimeUnit.SECONDS.sleep(1L);
				//返回还有几个线程在等待
				final int await = cyclicBarrier.await();
				System.out.println("线程"+Thread.currentThread()+"准备数据完毕,await="+await);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
