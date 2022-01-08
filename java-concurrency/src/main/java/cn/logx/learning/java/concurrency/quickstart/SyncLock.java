package cn.logx.learning.java.concurrency.quickstart;

import java.util.Date;

/**
 * 当一个对象有多个非静态synchronized方法时，如果这些synchronized方法要被多个线程同时访问，
 * 那么在同一时刻，只能有一个方法被调用，因为当一个线程进入一个synchronized方法时，它首先需要获取对象的锁。
 *
 * 当一个类的synchronized方法是static方法时，如果一个线程进入这个static方法时，
 * 线程获取到到的是这个类的.class对象的锁，而不是这个类new的对象锁
 *
 */
public class SyncLock {

	public static void main(String[] args) {
		MyClass myClass = new MyClass();

		Thread t1 = new MyThread1(myClass);
		Thread t2 = new MyThread2(myClass);

		t1.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("t3 " + new Date());
		t2.start();
	}

}

class MyClass {
	public synchronized void hello() {
		System.out.println("t0 " + new Date());
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("hello");
		System.out.println("t1 " + new Date());
	}

	public synchronized void world() {
		System.out.println("t2 " + new Date());
		System.out.println("world");
	}
}

class MyThread1 extends Thread {
	private MyClass myClass;

	public MyThread1(MyClass myClass) {
		this.myClass = myClass;
	}

	@Override
	public void run() {
		myClass.hello();
	}
}

class MyThread2 extends Thread {
	private MyClass myClass;

	public MyThread2(MyClass myClass) {
		this.myClass = myClass;
	}

	@Override
	public void run() {
		myClass.world();
	}
}
