package cn.logx.learning.java.basic.initialization;

class Bowl {
	public Bowl(int marker) {
		System.out.println("Bowl("+ marker +")");
	}
	void f1 (int marker) {
		System.out.println("f1("+ marker +")");
	}
}


class Table {
	static Bowl bowl1 = new Bowl(1);

	public Table() {
		System.out.println("Table()");
		bowl2.f1(1);
	}
	void f2(int marker) {
		System.out.println("f2("+ marker +")");
	}
	static Bowl bowl2 = new Bowl(2);
}


class Cupboard {
	Bowl bowl3 = new Bowl(3);
	static Bowl bowl4 = new Bowl(4);

	public Cupboard() {
		System.out.println("Cupboard()");
		bowl4.f1(2);
	}
	void f3(int marker) {
		System.out.println("f2("+ marker +")");
	}
	static Bowl bowl5 = new Bowl(5);
}


/**
 * 要执行main方法，必须先加载StaticInitialization类，然后其静态域table和cupboard被初始化，这将导致它们对应的类也被加载，
 * 并且由于他们也都包含静态的Bowl对象，因此Bowl随后也被加载。
 */
public class StaticInitialization {

	public static void main(String[] args) {
		System.out.println("Creating new Cupboard() in main");
		new Cupboard();
		System.out.println("Creating new Cupboard() in main");
		new Cupboard();
		table.f2(1);
		cupboard.f3(1);
	}

	static Table table = new Table();
	static Cupboard cupboard = new Cupboard();

}
/* output
Bowl(1)
Bowl(2)
Table()
f1(1)
Bowl(4)
Bowl(5)
Bowl(3)
Cupboard()
f1(2)
Creating new Cupboard() in main
Bowl(3)
Cupboard()
f1(2)
Creating new Cupboard() in main
Bowl(3)
Cupboard()
f1(2)
f2(1)
f2(1)
 */
