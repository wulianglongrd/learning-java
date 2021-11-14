package cn.logx.learning.initialization;


class Mug {
	Mug(int marker) {
		System.out.println("Mug("+ marker +")");
	}
	void f(int marker) {
		System.out.println("f("+ marker +")");
	}
}

class Mugs {
	Mug mug1;
	Mug mug2;
	{
		mug1 = new Mug(1);
		mug2 = new Mug(2);
	}

	Mugs() {
		System.out.println("Mugs()");
	}
	Mugs(int i) {
		System.out.println("Mugs(int)");
	}

	public static void main(String[] args) {
		System.out.println("Inside main()");

		new Mugs();
		System.out.println("new Mugs() complete");

		new Mugs(1);
		System.out.println("new Mugs(1) complete");
	}
}
/*
Inside main()
Mug(1)
Mug(2)
Mugs()
new Mugs() complete
Mug(1)
Mug(2)
Mugs(int)
new Mugs(1) complete
 */