package cn.logx.learning.java.concurrency.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Demo {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		IntStream.range(0, 9).forEach(i -> {
			executorService.submit(() -> {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			});
		});

		executorService.shutdown();
	}
}
