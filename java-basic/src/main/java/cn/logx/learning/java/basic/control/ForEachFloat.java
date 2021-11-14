package cn.logx.learning.java.basic.control;

import java.util.Random;

public class ForEachFloat {
	public static void main(String[] args) {
		Random rand = new Random(47);
		float f[] = new float[10];
		for (int i = 0; i < 10; i++) {
			f[i] = rand.nextFloat();
		}

		// 任何数组都可以使用foreach
		for (float x : f) {
			System.out.println(x);
		}
	}
}
