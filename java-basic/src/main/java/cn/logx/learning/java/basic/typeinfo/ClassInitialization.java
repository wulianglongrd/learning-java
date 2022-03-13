package cn.logx.learning.java.basic.typeinfo;

import java.util.Random;

class Initable {
	static final int staticFinal = 47;
	static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
	static {
		System.out.println("Initializing Initable");
	}

	public Initable() {
		System.out.println("Initable Constructor");
	}
}

class Initable2 {
	static int staticNonFinal = 47;
	static {
		System.out.println("Initializing Initable2");
	}

	public Initable2() {
		System.out.println("Initable2 Constructor");
	}
}

class Initable3 {
	static int staticNonFinal = 74;
	static {
		System.out.println("Initializing Initable3");
	}

	public Initable3() {
		System.out.println("Initable3 Constructor");
	}
}

public class ClassInitialization {
	public static Random rand = new Random(47);

	public static void main(String[] args) throws Exception {
		Class initable = Initable.class;
		System.out.println("After creating Initable ref");
		System.out.println(Initable.staticFinal);
		System.out.println(Initable.staticFinal2);
		System.out.println("--------- END 1 ---------");

		System.out.println(Initable2.staticNonFinal);
		System.out.println("--------- END 2 ---------");

		Class initable3 = Class.forName("cn.logx.learning.java.basic.typeinfo.Initable3");
		System.out.println("After creating Initable3 ref");
		System.out.println(Initable3.staticNonFinal);
	}
}
/*
After creating Initable ref
47
Initializing Initable
258
--------- END 1 ---------
Initializing Initable2
47
--------- END 2 ---------
Initializing Initable3
After creating Initable3 ref
74
 */