package cn.logx.learning.java.concurrency.counter;

public class IncreaseThread extends Thread {

	private Counter counter;

	public IncreaseThread(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			counter.increase();
		}
	}
}
