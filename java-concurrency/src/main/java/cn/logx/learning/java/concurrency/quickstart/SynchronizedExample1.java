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
 * 当多个线程同时访问一段同步代码时，这些线程会被放到一个EntryList集合中，处于阻断状态的线程都会被放到该列表当中。
 * 接下来，当线程获取到对象的monitor时，monitor是依赖于底层操作系统的mutex lock来实现互斥的，
 * 线程获取mutex lock成功，则会持有该mutex lock，这时其它线程就无法再获取到该mutex lock
 *
 *
 * 如果线程调用了wait方法，那么该线程就会释放掉所持有的mutex lock，并且该线程会进入到wait set（等待集合）中，
 * 等待下一次被其它线程调用notify/notifyAll唤醒。如果当前线程顺利执行完毕方法，那么它也会释放掉所持有的mutex lock
 *
 *
 * 同步锁在这种实现方式当中，因为monitor是依赖于底层的操作系统实现，这样就存在用户态与内核态之间的切换，所以会增加性能开销。
 *
 * 处于EntryList与WaitSet中的线程都是阻塞状态，阻塞操作是由操作系统实现的，在linux下是通过pthread_mutext_lock函数实现的。
 * 线程被阻塞后便会进入到内核调度状态，这会导致系统在用户态与内核态之间来回切换，影响锁的性能。
 * 优化性能的方法是使用自旋。其原理是：当发生monitor争用（多个线程竞争获取monitor）时，若owner（已经持有monitor的线程）能够
 * 在很短的时间内释放掉锁，则那些正在争用的线程可以通过自旋稍微等待一下，在owner线程释放锁之后，争用线程可能会立即获取到锁，
 * 从而避免了系统阻塞；不过，若owner运行的时间超过了临界值，争用线程自旋一段时间后依然无法获取到锁，这时争用线程会停止自旋而进入
 * 阻塞状态。即总体思路是：先自旋，不成功再进行阻塞，尽量降低阻塞的可能性，这对那些执行时间很短的代码来说有不错的性能提高。
 * 自旋在多核处理器上才有意义。
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
