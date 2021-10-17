package com.tool.collect.skytools.demo;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @Descriiption
 * @Author bo
 * @Date 2021/10/2 上午9:28
 **/
public class ReentrantReadWriteLockDemo {
	static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	public static void main(String[] args) {
		final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
		final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
		writeLock.lock();
		writeLock.unlock();
		readLock.lock();
		readLock.unlock();

		System.out.println((1<<16)-1);
	}
}
