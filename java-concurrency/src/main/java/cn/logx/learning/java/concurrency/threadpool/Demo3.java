package cn.logx.learning.java.concurrency.threadpool;

import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Demo3 {

	public static void main(String[] args) {
		ExecutorService executorService = new ThreadPoolExecutor(3, 4, 10,
				TimeUnit.SECONDS, new LinkedBlockingQueue<>(3), new ThreadPoolExecutor.CallerRunsPolicy());

		CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);

		IntStream.range(0, 10).forEach(i -> {
			completionService.submit(() -> {
				int s = new Random().nextInt(3);
				TimeUnit.SECONDS.sleep(s);
				System.out.println(Thread.currentThread().getName());
				return i;
			});
		});

		IntStream.range(0, 10).forEach(i -> {
			int resoult = 0;
			try {
				resoult = completionService.take().get();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(resoult);
		});

		executorService.shutdown();
	}
}
