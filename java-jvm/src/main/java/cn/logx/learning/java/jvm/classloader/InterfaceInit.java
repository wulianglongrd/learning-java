package cn.logx.learning.java.jvm.classloader;

/**
 a. 在初始化一个类时，并不会先初始化它所实现的接口
 b. 在初始化一个接口时，并不会先初始化它的父接口
 因此：一个父接口并不会因为它的子接口或者实现类的初始化而初始化。只有当程序首次使用特定接口的静态变量时，才会导致该接口初始化。
 */
public class InterfaceInit {
	public static void main(String[] args) {
		System.out.println(Child1.a);
		System.out.println("----------------");
		System.out.println(Parent1.b);
	}
}

interface Parent1 {
	public static int b = 1;
	// 不会输出，证明没有被初始化
	public static Thread thread = new Thread() {
		{
			System.out.println("Parent1 init");
		}
	};
}

class Child1 implements Parent1 {
	public static int a = 2;
}

/*
2
----------------
1
* */