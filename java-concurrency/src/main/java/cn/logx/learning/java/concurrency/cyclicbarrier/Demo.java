package cn.logx.learning.java.concurrency.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

public class Demo {
	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3, () -> {
			System.out.println("----barrierAction----");
		});

		IntStream.range(0, 3).forEach(i -> new Thread(() -> {
			try {
				long ms = (long) (Math.random() * i * 2000);
				Thread.sleep(ms);

				System.out.println("hello - " + i);
				barrier.await();
				System.out.println("world - " + i);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start());

	}
}
