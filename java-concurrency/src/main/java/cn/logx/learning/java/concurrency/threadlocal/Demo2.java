package cn.logx.learning.java.concurrency.threadlocal;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Demo2 {
	public static void main(String[] args) {
		Random random = new Random();
		IntStream.range(0, 5).forEach(i -> {
			System.out.println(random.nextInt(10));
		});

		System.out.println("-------------------------");

		ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
		IntStream.range(0, 5).forEach(i -> {
			System.out.println(threadLocalRandom.nextInt(10));
		});

	}
}
