package cn.logx.learning.java.concurrency.counter;

public class Counter {

	private int i = 0;

	public synchronized void increase() {
//		if (i != 0) {
//			try {
//				wait();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}

		while (i != 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		i++;
		System.out.println(i);

		notify();
	}

	public synchronized void decrease() {
//		if (i == 0) {
//			try {
//				wait();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}

		// 当多个线程时
		while (i == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}



		i--;
		System.out.println(i);

		notify();
	}
}
