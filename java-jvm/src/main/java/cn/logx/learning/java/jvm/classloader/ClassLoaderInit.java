package cn.logx.learning.java.jvm.classloader;

/**
 * 系统ClassLoader#loadClass 加载类不属于主动使用，不会导致初始化
 * Class.forName 属于主动调用，会触发初始化
 */
public class ClassLoaderInit {
	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		Class<?> clazz = classLoader.loadClass("cn.logx.learning.java.jvm.classloader.CL");
		System.out.println(clazz);

		System.out.println("------------------");

		clazz = Class.forName("cn.logx.learning.java.jvm.classloader.CL");
		System.out.println(clazz);
	}
}

class CL {
	static {
		System.out.println("CL init");
	}
}

/*
class cn.logx.learning.java.jvm.classloader.CL
------------------
CL init
class cn.logx.learning.java.jvm.classloader.CL
* */