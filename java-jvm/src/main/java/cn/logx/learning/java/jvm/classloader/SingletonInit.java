package cn.logx.learning.java.jvm.classloader;

public class SingletonInit {
	public static void main(String[] args) {
		Singleton instance = Singleton.getInstance();
		String message = "count1=" + Singleton.count1
				+ ",count2=" + Singleton.count2
				+ ",count3=" + Singleton.count3;
		System.out.println(message);
	}
}

/**
 * 主动调用类的静态方法，会触发类的初始化
 * 1. 加载阶段，count1、count2、count3 均为 0
 * 2. 调用 getInstance 方法时，触发初始化，代码从下到下依次初始化，
 * 此时，
 * 	count1 被赋值为1
 * 	count2 被赋值为0
 * 	count3 还未执行到，不被赋值
 * new Singleton() 调用 构造方法，各属性执行自增操作
 * count3 被赋值为0，初始化结束
 */
class Singleton {

	public static int count1 = 1;
	public static int count2 = 0;

	private static Singleton instance = new Singleton();

	private Singleton() {
		count1++;
		count2++;
		count3++;

		String message = "count1=" + count1
			+ ",count2=" + count2
			+ ",count3=" + count3;
		System.out.println(message);
	}

	public static int count3 = 0;

	public static Singleton getInstance() {
		return instance;
	}
}

/*
count1=2,count2=1,count3=1
count1=2,count2=1,count3=0
 */