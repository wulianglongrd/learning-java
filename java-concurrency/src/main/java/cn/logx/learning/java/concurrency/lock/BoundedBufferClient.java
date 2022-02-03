package cn.logx.learning.java.concurrency.lock;

import java.util.stream.IntStream;

public class BoundedBufferClient {

	public static void main(String[] args) {
		BoundedBuffer bf = new BoundedBuffer();

		IntStream.range(0, 20).forEach(i -> new Thread(() -> {
			try {
				bf.put("hello");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start());


		IntStream.range(0, 20).forEach(i -> new Thread(() -> {
			try {
				bf.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start());
	}

}
