package com.tool.collect.skytools;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import com.tool.collect.skytools.dto.Person;

/**
 *
 * @Descriiption
 * @Author bo
 * @Date 2021/8/2 下午4:50
 **/
public class L1Test {
	private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
	private ReentrantLock lock = new ReentrantLock();
	private Condition notFull = lock.newCondition();
	private Condition notEmpty = lock.newCondition();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1Test object = new L1Test();
		Producer producer = object.new Producer();
		Consumer consumer = object.new Consumer();
		producer.start();
		consumer.start();


		Person person = new Person();





	}

	class Consumer extends Thread {
		@Override
		public void run() {
			//consume();
			while (true) {
				lock.lock();
				try {
					while (queue.size() == 0) {
						try {
							System.out.println("队列为空");
							notEmpty.await();

						}
						catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();

						}
					}
					queue.poll();
					notFull.signal();
					System.out.println("取走一个元素,还有：" + queue.size());

				}
				finally {
					lock.unlock();
				}
			}
		}

		private void consume() {
			while (true) {
				lock.lock();
				try {
					while (queue.size() == 0) {
						try {
							System.out.println("队列为空");
							notEmpty.await();

						}
						catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();

						}
					}
					queue.poll();
					notFull.signal();
					System.out.println("取走一个元素,还有：" + queue.size());

				}
				finally {
					lock.unlock();
				}
			}
		}

	}

	class Producer extends Thread {
		@Override
		public void run() {
			//produce();
			while (true) {
				lock.lock();
				try {
					while (queue.size() == 10) {

						try {
							System.out.println("队列已经满了");
							notFull.await();
						}
						catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					queue.offer(1);
					notEmpty.signal();
					System.out.println("向队列中插入一个元素，长度为" + queue.size());
				}
				finally {
					lock.unlock();
				}
			}
		}

		private void produce() {
			while (true) {
				lock.lock();
				try {
					while (queue.size() == 10) {

						try {
							System.out.println("队列已经满了");
							notFull.await();
						}
						catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					queue.offer(1);
					notEmpty.signal();
					System.out.println("向队列中插入一个元素，长度为" + queue.size());
				}
				finally {
					lock.unlock();
				}
			}
		}
	}

}
