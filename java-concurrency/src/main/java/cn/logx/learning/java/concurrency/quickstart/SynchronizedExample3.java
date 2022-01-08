package cn.logx.learning.java.concurrency.quickstart;

/**
 * javap -v SynchronizedExample3.class
 *
 public static synchronized void hello();
 descriptor: ()V
 flags: ACC_PUBLIC, ACC_STATIC, ACC_SYNCHRONIZED
 Code:
 stack=2, locals=0, args_size=0
 0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 3: ldc           #3                  // String hello world
 5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 8: return
 LineNumberTable:
 line 5: 0
 line 6: 8
 */
public class SynchronizedExample3 {
	public static synchronized void hello() {
		System.out.println("hello world");
	}
}
