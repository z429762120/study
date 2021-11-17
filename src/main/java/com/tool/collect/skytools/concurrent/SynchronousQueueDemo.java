package com.tool.collect.skytools.concurrent;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 *
 * @Descriiption 无缓冲等待队列，本身不存储元素 put操作与take操作配对执行
 * 如果有线程先put，此时没有线程take,那么put线程会挂起，等待take线程唤醒
 * @Author bo
 * @Date 2021/10/19 下午4:42
 **/
public class SynchronousQueueDemo {
	static volatile boolean flag = false;

	public static void main(String[] args) {
		// 分为公平模式和非公平模式
		// 公平模式基于TransferQueue<E>()实现   先入先出
		// 非公平模式基于TransferStack<E>()实现  后入先出
		SynchronousQueue queue = new SynchronousQueue(false);
		for (int i = 0; i < 5; i++) {
			new PutThread(queue,i).start();
		}
		new TakeThread(queue).start();
	}

	static class PutThread extends Thread{
		SynchronousQueue queue;
		int i;
		PutThread(SynchronousQueue queue,int i) {
			this.queue = queue;
			this.i = i;
		}
		@Override
		public void run() {
			try {
				System.out.println(Thread.currentThread() + "put之前 i=" + i);
				queue.put("put "+i);
				System.out.println(Thread.currentThread() + "put之后 i=" + i);

			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static class TakeThread extends Thread{
		SynchronousQueue queue;

		TakeThread(SynchronousQueue queue) {
			this.queue = queue;
		}
		@Override
		public void run() {
			try {

				while (true) {
					TimeUnit.SECONDS.sleep(2);
					System.out.println(Thread.currentThread() + "take的值" + queue.take());
				}

			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
