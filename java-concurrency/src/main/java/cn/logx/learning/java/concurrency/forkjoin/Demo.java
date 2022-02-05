package cn.logx.learning.java.concurrency.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Demo {
	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool(4);

		MyTask myTask = new MyTask(1, 100);
		int result = forkJoinPool.invoke(myTask);
		System.out.println(result);

		forkJoinPool.shutdown();
	}
}

class MyTask extends RecursiveTask<Integer> {

	private int limit = 4;
	private int firstIndex;
	private int lastIndex;

	public MyTask(int firstIndex, int lastIndex) {
		this.firstIndex = firstIndex;
		this.lastIndex = lastIndex;
	}

	@Override
	protected Integer compute() {
		int result = 0;

		int gap = lastIndex - firstIndex;

		// 任务足够小，直接计算
		if (gap <= limit) {
			System.out.println(Thread.currentThread().getName());
			for (int i = 0; i < lastIndex; i++) {
				result += i;
			}
		}

		// 任务过大，继续拆分
		else {
			int middleIndex = (firstIndex + lastIndex) / 2;

			MyTask leftTask = new MyTask(firstIndex, middleIndex);
			MyTask rightTask = new MyTask(middleIndex + 1, lastIndex);

			invokeAll(leftTask, rightTask);

			int leftTaskResult = leftTask.join();
			int rightTaskResult = rightTask.join();

			result = leftTaskResult + rightTaskResult;
		}

		return result;
	}
}