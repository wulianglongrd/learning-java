package cn.logx.learning.control;

public class IfElse {

	public static void main(String[] args) {
		ifElseTest(1, 2);
		ifElseTest(2, 2);
	}

	private static void ifElseTest(int a , int b) {
		if (a == b) {
			System.out.printf("%d = %d\n", a, b);
		} else {
			System.out.printf("%d != %d\n", a, b);
		}
	}

}
