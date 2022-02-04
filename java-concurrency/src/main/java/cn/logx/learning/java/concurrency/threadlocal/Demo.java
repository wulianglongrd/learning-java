package cn.logx.learning.java.concurrency.threadlocal;


/**
 * ThreadLocal
 *
 * 本质上，ThreadLocal是通过空间来换取时间，实现每个线程当中都会有一个变量的副本，这样每个线程都会操作
 * 该副本，从而完全规避了多线程的并发问题。
 *
 * Java中存的四种引用类型：
 * 1. 强引用 strong
 * 2. 软引用 soft
 * 3. 弱引用 weak
 * 4. 虚引用 phantom
 *
 *
 * // ThreadLocal 常见写法
 * public class Test {
 *     private static final ThreadLocal<String></String> threadLocal = new ThreadLocal();
 * }
 *
 * try {
 *     threadLocal.set("foo");
 *     ...
 * } finally {
 *     threadLocal.remove();
 * }
 */
public class Demo {

	public static void main(String[] args) {
		ThreadLocal<String> threadLocal = new ThreadLocal<>();
		threadLocal.set("welcome");
		System.out.println(threadLocal.get());

		threadLocal.set("logx");
		System.out.println(threadLocal.get());
	}

}
