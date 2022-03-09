package cn.logx.learning.java.concurrency.lock;

/**
 * 死锁：线程1等待线程2互斥持有的资源，而线程2也在等待线程1互斥持有的资源，两个线程都无法继续执行
 * 活锁：线程持续重试一个总是失败的操作,导致无法继续执行
 * 俄死：线程一直被调度器延迟访问其赖以执行的资源，也许是调度器先于低优先级的线程而执行高优先級的线程，
 *     同时总是会有一个高优先级的线程可以执行，饿死也叫做无限延迟
 */
public class DeadLock {

	private final Object lock1 = new Object();
	private final Object lock2 = new Object();

	public void method1() {
		synchronized (lock1) {
			synchronized (lock2) {
				System.out.println("method1 invoked");
			}
		}
	}

	public void method2() {
		synchronized (lock2) {
			synchronized (lock1) {
				System.out.println("method2 invoked");
			}
		}
	}

}
