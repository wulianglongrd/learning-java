package cn.logx.learning.java.concurrency.quickstart;

public class PrimeThread extends Thread {
	@Override
	public void run() {
		System.out.println("PrimeThread run");
	}

}
