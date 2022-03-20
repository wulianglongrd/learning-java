package cn.logx.learning.java.jvm.classloader;

public class StaticInit2 {
	static  {
		System.out.println("main static block");
	}

	public static void main(String[] args) {
		System.out.println(Child2.a);
	}
}

/**
 * 子类初始化，会先初史化父类（如果父类是一个接口，不会初始化）
 * 反之：如果父类初始化，子类不会初始化
 */
class Parent2 {
	public static int b = 2;

	static {
		System.out.println("parent static block");
	}
}

class Child2 extends Parent2 {
	public static int a = 1;

	static {
		System.out.println("child static block");
	}
}

/*
main static block
parent static block
child static block
1
 */