package cn.logx.learning.java.jvm.classloader;

/**
 * @see https://blog.csdn.net/pan_junbiao/article/details/123281370?spm=1001.2014.3001.5502
 */
public class ClassInitOrderTest {
	static {
		System.out.println("A");
	}

	public static void main(String[] args) {
		System.out.println("C");
		new ClassInitOrderTest();
		System.out.println("F");
	}

	public ClassInitOrderTest() {
		System.out.println("E");
	}

	{
		System.out.println("D");
	}

	static {
		System.out.println("B");
	}
}

/*
 A
 B
 C
 D
 E
 F
 */