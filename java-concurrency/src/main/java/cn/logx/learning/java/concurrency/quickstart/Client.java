package cn.logx.learning.java.concurrency.quickstart;

public class Client {
	public static void main(String[] args) {
		PrimeThread ph = new PrimeThread();
		ph.start();

		PrimeRun pr = new PrimeRun();
		new Thread(pr).start();
	}
}
