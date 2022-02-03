package cn.logx.learning.java.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

public class Demo {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);

		IntStream.range(0, 3).forEach(i -> new Thread(() -> {
			try {
				Thread.sleep(1000);
				System.out.println("hello");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				latch.countDown();
			}
		}).start());

		System.out.println("启动子线程完毕");
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("主线程执行完毕");
	}
}
