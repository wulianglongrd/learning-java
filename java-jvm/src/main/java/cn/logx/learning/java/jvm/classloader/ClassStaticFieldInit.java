package cn.logx.learning.java.jvm.classloader;

/**
 * ?
 */
public class ClassStaticFieldInit {
	public static void main(String[] args) {
		System.out.println(ClassFieldDemo.a);
		System.out.println(ClassFieldDemo.b);
	}
}

class ClassFieldDemo {
	static {
//		System.out.println("a1 = " + a);
		a = 2;
	}
	static int a = 1;

	static int b = 3;
	static {
		System.out.println("b1 = " + b);
		b = 4;
	}
	public ClassFieldDemo() {
		System.out.println("a2 = " + a);
		System.out.println("b2 = " + b);
	}
}
/*
b1 = 3
1
4
* */
