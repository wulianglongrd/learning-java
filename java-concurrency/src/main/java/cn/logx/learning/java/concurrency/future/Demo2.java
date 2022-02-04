package cn.logx.learning.java.concurrency.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Demo2 {

	public static void main(String[] args) {
		asyncRequestWithResponse();

		System.out.println("--------------");

		asyncRequestThenConsume();

		System.out.println("--------------");

		asyncRequestThenCombineResponse();

		System.out.println("--------------");

		asyncRequestAndAsyncGetResponse();
	}

	private static void asyncRequestWithResponse() {
		String result = CompletableFuture.supplyAsync(() -> "hello")
				.thenApplyAsync(response -> response + " world")
				.join();
		System.out.println(result);
	}

	private static void asyncRequestThenConsume() {
		CompletableFuture.supplyAsync(() -> "hello")
				.thenAccept(response -> System.out.println("response = " + response));
	}

	private static void asyncRequestThenCombineResponse() {
		String result = CompletableFuture.supplyAsync(() -> "hello")
			.thenCombine(
				CompletableFuture.supplyAsync(() -> "world"),
				(res1, res2) -> res1 + " " + res2
			).join();
		System.out.println(result);
	}

	private static void asyncRequestAndAsyncGetResponse() {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("task finished");
		});

		future.whenComplete((a, b) -> System.out.println("get response"));

		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
