package cn.logx.learning.java.concurrency.quickstart;

/**
 * javap -v SynchronizedExample2.class
 *
 public synchronized void hello();
 descriptor: ()V
 flags: ACC_PUBLIC, ACC_SYNCHRONIZED

 * 对于synchronized关键字修饰方法来说，使用ACC_SYNCHRONIZED flag来区分是否同步方法
 *
 *
 */
public class SynchronizedExample2 {

	public synchronized void hello() {
		System.out.println("hello world");
	}

}
