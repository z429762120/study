package com.tool.collect.skytools.demo;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @Descriiption
 * @Author bo
 * @Date 2021/9/29 下午4:22
 **/
public class ReentrantLockDemo {

	static final ReentrantLock lock = new ReentrantLock();
	static  int a=0;

	public static void main(String[] args) {
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				lock.lock();
				a++;
				System.out.println(a);
				lock.unlock();
			}
		}).start();

		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				lock.lock();
				a++;
				System.out.println(a);
				lock.unlock();
			}
		}).start();
	}
}
