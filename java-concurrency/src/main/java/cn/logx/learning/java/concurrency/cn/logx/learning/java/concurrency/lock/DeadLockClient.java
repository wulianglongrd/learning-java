package cn.logx.learning.java.concurrency.cn.logx.learning.java.concurrency.lock;

/**
 * 死锁分析
 *
 * 1. 使用 jvisualvm 分析死锁 (Java VisualVM)
 * 终端输入 jvisualvm 命令启动可视化界面
 *
 * 2. 使用命令行分析死锁
 * jps
 ➜  ~ jps
 8336 Main
 8770 Launcher
 1010
 8771 DeadLockClient
 1126 RemoteMavenServer
 8893 Jps

 ➜  ~ jstack 8771
 Found one Java-level deadlock:
 =============================
 "Thread-1":
 waiting to lock monitor 0x00007f9dfe040bf8 (object 0x00000007956ff9a0, a java.lang.Object),
 which is held by "Thread-0"
 "Thread-0":
 waiting to lock monitor 0x00007f9dfe03e4c8 (object 0x00000007956ff9b0, a java.lang.Object),
 which is held by "Thread-1"

 Java stack information for the threads listed above:
 ===================================================
 "Thread-1":
 at cn.logx.learning.java.concurrency.cn.logx.learning.java.concurrency.lock.DeadLock.method2(DeadLock.java:19)
 - waiting to lock <0x00000007956ff9a0> (a java.lang.Object)
 - locked <0x00000007956ff9b0> (a java.lang.Object)
 at cn.logx.learning.java.concurrency.cn.logx.learning.java.concurrency.lock.DeadLockClient.lambda$main$1(DeadLockClient.java:29)
 at cn.logx.learning.java.concurrency.cn.logx.learning.java.concurrency.lock.DeadLockClient$$Lambda$2/764977973.run(Unknown Source)
 at java.lang.Thread.run(Thread.java:748)
 "Thread-0":
 at cn.logx.learning.java.concurrency.cn.logx.learning.java.concurrency.lock.DeadLock.method1(DeadLock.java:11)
 - waiting to lock <0x00000007956ff9b0> (a java.lang.Object)
 - locked <0x00000007956ff9a0> (a java.lang.Object)
 at cn.logx.learning.java.concurrency.cn.logx.learning.java.concurrency.lock.DeadLockClient.lambda$main$0(DeadLockClient.java:18)
 at cn.logx.learning.java.concurrency.cn.logx.learning.java.concurrency.lock.DeadLockClient$$Lambda$1/931919113.run(Unknown Source)
 at java.lang.Thread.run(Thread.java:748)

 Found 1 deadlock.
 */
public class DeadLockClient {

	public static void main(String[] args) {
		DeadLock deadLock = new DeadLock();

		new Thread(() -> {
			while (true) {
				deadLock.method1();
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(() -> {
			while (true) {
				deadLock.method2();
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

}
