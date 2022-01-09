package cn.logx.learning.java.concurrency.quickstart;

/**
 * javap -v SynchronizedExample1.class
 *
 * 当我们使用synchronized关键字来修饰代码块时，字节码层面上是通过monitorenter和monitorexit指令
 * 来实现的锁的获取与释放动作。
 *
 * JVM中的同步是基于进入与退出监视器对象（管程对象 Monitor）来实现的，每个对象实例都会有一个monitor对象，
 * monitor对象会和java对象一同创建并销毁。monitor对象是由c++来实现的。
 *
 */
public class SynchronizedExample1 {

	// 可以使用任意对象
	private Object lock = new Object();

	public void hello() {
		synchronized (lock) {
			System.out.println("hello world");
		}
	}

}
