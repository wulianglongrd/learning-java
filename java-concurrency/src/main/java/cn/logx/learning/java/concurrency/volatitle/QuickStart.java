package cn.logx.learning.java.concurrency.volatitle;

/**
 * private volatile long count;
 *
 * volatile 关键字主要有三方面的作用：
 * 1. 实现long/double类型变量的原子操作
 *   64位是分低32位、高32位两步写
 * 2. 防止指令重排序
 * 3. 实现变量修改的可见性
 *
 *  当使用volatile修饰变量时，应用就不会从寄存器中获取该变量的值，而是从内存（高速缓存）中获取。
 *  volatile与锁类似的地方有两点：
 *   a. 确保变量的内存可见性
 *   b. 防止指令重排序
 *
 *  volatile可以确保对变量写操作的原子性，但不具备排他性
 *  另外的重点一点在于：使用锁可能会导致线程的上下文切换，但使用volatile并不会出现这种情况
 *
 *	如果要实现volatile写操作原子性，那么在等号右侧的赋值变量中就不能出现被多线程所共享的变量，哪怕这个变量使用volatile修饰也不可以。
 *
 *
 *  防止指令重排序和实现变量的可见性都是通过一种手段来实现的：内存屏障（memory barrier）
 *
 *  -- store barrier 插入点
 *  volatile boolean v = false; // 写操作
 *  -- store barrier 插入点
 *
 *  -- load barrier 插入点
 *  boolean v1 = v; // 读操作
 *  -- acquire barrier 插入点
 *
 *  - release barrier 释放屏障：防止下面的volatile与上面的所有操作的指令重排序
 *  - store barrier 存储屏障：重要作用是刷新处理器缓存，结果是可以确保该存储屏障之前一切的操作所生成的结果对于其它处理器来说都可见。
 *  - load barrier 加载屏障：刷新处理器缓存，同步其它处理器对该volatile变量的修改结果
 *  - acquire barrier 获取屏障：防止上面的volatile读取操作与下面的所有操作语句的指令重排序
 *
 */
public class QuickStart {

	private volatile int count;
}
