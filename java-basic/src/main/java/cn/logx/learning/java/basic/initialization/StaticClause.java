package cn.logx.learning.java.basic.initialization;


class Cup {
	public Cup(int marker) {
		System.out.println("Cup("+ marker +")");
	}
	void f(int marker) {
		System.out.println("f("+ marker +")");
	}
}

class Cups {
	static Cup cup1;
	static Cup cup2;

	static {
		cup1 = new Cup(1);
		cup2 = new Cup(2);
	}

	public Cups() {
		System.out.println("Cups()");
	}
}

public class StaticClause {
	public static void main(String[] args) {
		System.out.println("Inside main()");
		Cups.cup1.f(99);
	}
//	static Cups cups1 = new Cups();
//	static Cups cups2 = new Cups();
}

/*
Inside main()
Cup(1)
Cup(2)
f(99)
 */