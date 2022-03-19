package cn.logx.learning.java.jvm.classloader;

public class ClassLoaderName {
	public static void main(String[] args) throws ClassNotFoundException {
		/**
		 * @see getClassLoader description
		 */
		Class<?> clazz1 = Class.forName("java.lang.String");
		System.out.println(clazz1.getClassLoader());

		System.out.println("------------1---------");
		Class<?> clazz2 = Class.forName("cn.logx.learning.java.jvm.classloader.LoadedClass");
		System.out.println(clazz2.getClassLoader());

		System.out.println("-----------2----------");
		ClassLoader threadClassLoader = Thread.currentThread().getContextClassLoader();
		System.out.println(threadClassLoader);


		Class<?> loader = ClassLoaderName.class;
		System.out.println(loader.getClassLoader());


		System.out.println("------------3---------");
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		System.out.println(classLoader);
		while (null != classLoader) {
			classLoader = classLoader.getParent();
			System.out.println(classLoader);
		}

	}
}

class LoadedClass {

}

/*
null
------------1---------
sun.misc.Launcher$AppClassLoader@18b4aac2
-----------2----------
sun.misc.Launcher$AppClassLoader@18b4aac2
sun.misc.Launcher$AppClassLoader@18b4aac2
------------3---------
sun.misc.Launcher$AppClassLoader@18b4aac2
sun.misc.Launcher$ExtClassLoader@610455d6
null
*/