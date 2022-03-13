package cn.logx.learning.java.jvm.classloader;

public class StaticInit {
	public static void main(String[] args) {
		System.out.println(Parent.str);
	}
}

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