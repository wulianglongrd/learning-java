package cn.logx.learning.java.concurrency.future;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Demo1 {
	public static void main(String[] args) {
		Callable<String> callable = () -> {
			System.out.println("pre execution");
			Thread.sleep(3000);
			System.out.println("post execution");
			return "logx";
		};

		FutureTask<String> futureTask = new FutureTask<>(callable);
		new Thread(futureTask).start();
		System.out.println("thread has started");

		try {
			Thread.sleep(4000);
			System.out.println("result = " + futureTask.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
