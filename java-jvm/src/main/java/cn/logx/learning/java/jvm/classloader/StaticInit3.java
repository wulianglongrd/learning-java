package cn.logx.learning.java.jvm.classloader;

public class StaticInit3 {
	static {
		System.out.println("StaticInit3 static block");
	}
	public static void main(String[] args) {
		Parent3 p3;
		System.out.println("---------");

		p3 = new Parent3();
		System.out.println("---------");

		System.out.println(p3.a);

		System.out.println("---------");
		System.out.println(Child3.b);
	}
}

/**
 * 初始化顺序： 静态代码块 > 实例代码块 > 构造方法
 */
class Parent3 {
	static int a = 1;
	{
		System.out.println("Parent block");
	}

	static {
		System.out.println("Parent3 static block");
	}

	public Parent3() {
		System.out.println("Parent3 constructor block");
	}
}

class Child3 extends Parent3 {
	static int b = 2;
	static {
		System.out.println("Child3 static block");
	}
}

/*
StaticInit3 static block
---------
Parent3 static block
Parent block
Parent3 constructor block
---------
1
---------
Child3 static block
2
 */