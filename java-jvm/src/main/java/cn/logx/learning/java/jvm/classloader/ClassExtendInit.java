package cn.logx.learning.java.jvm.classloader;

/**
 * 初始化的一般原则：
 * 1. 静态 > 非静态
 * 2. 父类 > 子类
 * 3. 成员变量按定义顺序进行
 *
 * 普通类的执行顺序：静态代码块 > 实例代码块 > 构造函数
 *
 * 继承的代码初始化顺序：父类静态代码块 > 子类静态代码块 > [父类实例代码块 > 父类构造方法] > [子类实例代码块 > 子类构造方法]
 *
 */
public class ClassExtendInit {
	public static void main(String[] args) {
		ChildClass childClass = new ChildClass();
		System.out.println("----------");
		childClass = new ChildClass();
	}
}

class ParentClass {
	/**
	 * 实例代码块，每次new时都初始化
	 */
	{
		System.out.println("父类实例代码块");
	}

	/**
	 * 静态代码块，只初始化一次
	 */
	static {
		System.out.println("父类静态代码块");
	}

	public ParentClass() {
		System.out.println("父类构造方法");
	}
}

class ChildClass extends ParentClass {
	{
		System.out.println("子类实例代码块");
	}
	static {
		System.out.println("子类静态代码块");
	}
	public ChildClass() {
		System.out.println("子类构造方法");
	}
}
/*
父类静态代码块
子类静态代码块
父类实例代码块
父类构造方法
子类实例代码块
子类构造方法
----------
父类实例代码块
父类构造方法
子类实例代码块
子类构造方法
* */