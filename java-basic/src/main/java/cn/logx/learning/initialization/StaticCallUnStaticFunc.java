package cn.logx.learning.initialization;

public class StaticCallUnStaticFunc {

	public static void main(String[] args) {
		UnStaticClass unStaticClass = new UnStaticClass();
		staticFunc(unStaticClass);
	}

	/**
	 * 一般情况下，static方法内部不能调用非静态方法，反过来可以。
	 * 但是，这不是完全不可能。如果传递一个对象的引用到静态方法里，然后通过这个引用，就可以调用非静态方法和访问非静态数据成员了。
	 */
	private static void staticFunc(UnStaticClass unStaticClass) {
		unStaticClass.unStaticFunc("logx");
		System.out.println(unStaticClass.getUnStaticField());
	}
}
