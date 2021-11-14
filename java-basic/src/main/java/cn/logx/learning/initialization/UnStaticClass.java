package cn.logx.learning.initialization;

public class UnStaticClass {

	private String unStaticField;

	public UnStaticClass() {
		this.unStaticField = "foo";
	}

	public void unStaticFunc(String name) {
		System.out.println("hello " + name);
	}

	public String getUnStaticField() {
		return unStaticField;
	}
}
