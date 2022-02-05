package cn.logx.learning.java.concurrency.threadpool;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Demo2 {

	public static void main(String[] args) {
		ExecutorService executorService = new ThreadPoolExecutor(3, 5, 0,
			TimeUnit.SECONDS, new LinkedBlockingQueue<>(3), new ThreadPoolExecutor.CallerRunsPolicy());

		IntStream.range(0, 9).forEach(i -> {
			executorService.submit(() -> {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			});
		});

		executorService.shutdown();
	}

}
