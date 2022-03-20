package cn.logx.learning.java.jvm.classloader;

/**
 * <p> <tt>Class</tt> objects for array classes are not created by class
 * loaders, but are created automatically as required by the Java runtime.
 * The class loader for an array class, as returned by {@link
 * Class#getClassLoader()} is the same as the class loader for its element
 * type; if the element type is a primitive type, then the array class has no
 * class loader.
 *
 *
 * @see ClassLoader description learn more
 */
public class ArrayClassLoader {
	public static void main(String[] args) {
		String[] strings = new String[2];
		System.out.println(strings.getClass().getClassLoader());

		System.out.println("-------------------");

		StaticInit[] arr = new StaticInit[2];
		System.out.println(arr.getClass().getClassLoader());

		System.out.println("-------------------");

		// if the element type is a primitive type, then the array class has no
		// class loader.
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
