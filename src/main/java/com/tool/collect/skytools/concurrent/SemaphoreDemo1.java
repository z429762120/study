package com.tool.collect.skytools.concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *
 * @Descriiption 可以控制同时最多有多少个线程可以执行
 * @Author bo
 * @Date 2021/10/14 下午5:02
 **/
public class SemaphoreDemo1 {
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(2);
		for (int i = 0; i < 10; i++) {
			new MyThread(semaphore).start();
		}
	}

	static class MyThread extends Thread {
		Semaphore semaphore;

		MyThread(Semaphore semaphore) {
			this.semaphore = semaphore;
		}

		@Override
		public void run() {
			try {
				semaphore.acquire(1);
				System.out.println("线程【"+Thread.currentThread().getName()+"】占用一个名额");
				TimeUnit.SECONDS.sleep(2);
				System.out.println("线程【"+Thread.currentThread().getName()+"】释放一个名额");
				semaphore.release(1);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
