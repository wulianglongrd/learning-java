package cn.logx.learning.java.jvm.classloader;

/**
 * @see ClassLoader description
 */
public class ArrayClassLoader {
	public static void main(String[] args) {
		String[] strings = new String[2];
		System.out.println(strings.getClass().getClassLoader());

		System.out.println("-------------------");

		StaticInit[] arr = new StaticInit[2];
		System.out.println(arr.getClass().getClassLoader());

		System.out.println("-------------------");

		int[] ints = new int[2];
		System.out.println(ints.getClass().getClassLoader());
	}
}
/*
null
-------------------
sun.misc.Launcher$AppClassLoader@18b4aac2
-------------------
null
* */
