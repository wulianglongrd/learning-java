package cn.logx.learning.java.jvm.classloader;

public class StaticInit {
	public static void main(String[] args) {
		System.out.println(Parent.str);
	}
}

/**
 * 目标：
 * 1. 理解 static 属性初化过程
 * 2. 理解类在什么情况下会被加载
 * 3. 理解使用VM参数打印类加载trace信息
 * 4. 理解 未主动使用，不会初始化
 */
class Parent {
	public static String str = "hello";

	static {
		System.out.println("parent static block");
	}
}

// Child类未主动使用，不会初始化
class Child extends Parent {
	static {
		System.out.println("child static block");
	}
}

/*
 parent static block
 hello
 **/