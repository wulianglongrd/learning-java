package cn.logx.learning.java.concurrency.lock;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer {

	private String[] elements = new String[10];

	private Lock lock = new ReentrantLock();

	private Condition notFull = lock.newCondition();

	private Condition notEmpty = lock.newCondition();

	private int count;

	private int putptr;

	private int takeptr;

	public void put(String element) throws InterruptedException {
		lock.lock();
		try {
			while (count == elements.length) {
				notFull.await();
			}

			elements[putptr] = element;
			if (++putptr == elements.length) {
				putptr = 0;
			}
			++count;
			System.out.println("put method: " + Arrays.toString(elements));

			notEmpty.signal();
		} finally {
			lock.unlock();
		}
	}

	public String take() throws InterruptedException {
		lock.lock();
		try {
			while (count == 0) {
				notEmpty.wait();
			}

			String element = elements[takeptr];
			elements[takeptr] = null;
			if (++takeptr == elements.length) {
				takeptr = 0;
			}

			System.out.println("take method: " + Arrays.toString(elements));

			--count;
			notFull.signal();

			return element;
		} finally {
			lock.unlock();
		}
	}

}
