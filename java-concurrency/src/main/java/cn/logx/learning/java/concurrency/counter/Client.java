package cn.logx.learning.java.concurrency.counter;

public class Client {

	public static void main(String[] args) {
		Counter counter = new Counter();

		IncreaseThread increaseThread = new IncreaseThread(counter);
		DecreaseThread decreaseThread = new DecreaseThread(counter);

		increaseThread.start();
		decreaseThread.start();
	}
}
