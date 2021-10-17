package com.tool.collect.skytools.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @Descriiption
 * @Author bo
 * @Date 2021/9/29 下午4:22
 **/
public class ReentrantLockConditionDemo {

	static final ReentrantLock lock = new ReentrantLock();
	static Condition condition = lock.newCondition();

	public static void main(String[] args) {
		new Thread(()->{
			lock.lock();
			System.out.println("第一个线程加锁");
			try {
				System.out.println("第一个线程阻塞等待");
				condition.await();
				System.out.println("第一个线被唤醒");
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			lock.unlock();
			System.out.println("第一个线释放锁");
		}).start();

		new Thread(()->{
			lock.lock();
			System.out.println("第二个线程加锁");
			System.out.println("第二个线程唤醒第一个线程");
			condition.signal();

			try {
				Thread.sleep(3000L);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			lock.unlock();
			System.out.println("第二个线程释放锁");
		}).start();
	}
}
