package cn.logx.learning.java.concurrency.counter;

public class DecreaseThread extends Thread {

	private Counter counter;

	public DecreaseThread(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			this.counter.decrease();
		}
	}
}
