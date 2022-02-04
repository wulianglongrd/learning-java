package cn.logx.learning.java.concurrency.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 当于CAS来说，其操作数主要涉及如下三个：
 * 1. 需要被操作的内存值V
 * 2. 需要进行比较的值A
 * 3. 需要进行写入的值B
 *
 * 只有当V==A的时候，CAS才会通过原子操作的手段来将V的值更新为B
 *
 * 关于CAS的限制
 * 1. 循环开销问题：并发量大的情况下会导致线程一直自旋
 * 2. 只能保证一个变量的原子操作：可以通过AtomicReference来实现多个变量的原子操作
 * 3. ABA问题：1 -> 3 -> 1
 *
 */
public class Demo {

	public static void main(String[] args) {
		AtomicInteger atomicInteger = new AtomicInteger(1);
		System.out.println(atomicInteger.getAndSet(8));
	}

}
