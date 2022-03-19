package cn.logx.learning.java.jvm.classloader;

import java.util.UUID;

/**
 * 目标：
 * 了解常量池
 */
public class StaticFinalInit {
	public static void main(String[] args) {
		System.out.println(Demo.str);
		System.out.println("----------------");
		System.out.println(Demo2.str);
	}
}

/**
 * 常量在编译阶段会存入到调用这个常量的方法所在的类的常量池中
 * 本质上，调用类（StaticFinalInit）并没有直接引用到定义常量的类（Demo），因此并不会触发定义常量的类（Demo）初始化
 * 注意：这里指的是将常量存放到了 StaticFinalInit 的常量池中，之后 Demo 与 StaticFinalInit 就没有任何关系了。
 * 甚至，我们可以将Demo的class文件删除
 */
class Demo {

	public static final String str = "hello world";

	/**
	 * static 块不会执行，因为 Demo 类不会初始化。
	 */
	static {
		System.out.println("demo static block");
	}
}

class Demo2 {

	/**
	 * 当一个常量的值并非编译期就可以确定的时，那么期值不会放到调用类的常量池中
	 */
	public static final String str = UUID.randomUUID().toString();

	static {
		System.out.println("demo2 static block");
	}
}

/*
hello world
----------------
demo2 static block
bedfadf3-2b77-486a-8940-b7f316019972
 */
