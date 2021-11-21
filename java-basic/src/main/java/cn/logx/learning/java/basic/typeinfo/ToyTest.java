package cn.logx.learning.java.basic.typeinfo;

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
	Toy () {}
	Toy(int i) {}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
	FancyToy() {
		super(1);
	}
}

public class ToyTest {
	static void printInfo (Class cc) {
		System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
		System.out.println("Simple name: " + cc.getSimpleName()); // 不含包名的类名
		System.out.println("Canonical name : " + cc.getCanonicalName()); // 全限定名
		System.out.println("-----------------------------------");
	}

	public static void main(String[] args) {
		Class c = null;
		try {
			c = Class.forName("cn.logx.learning.java.basic.typeinfo.FancyToy");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		printInfo(c);

		for (Class face : c.getInterfaces()) {
			printInfo(face);
		}

		Class up = c.getSuperclass();
		try {
			Object obj = up.newInstance();
			printInfo(obj.getClass());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
}

/* output
Class name: cn.logx.learning.java.basic.typeinfo.FancyToy is interface? [false]
Simple name: FancyToy
Canonical name : cn.logx.learning.java.basic.typeinfo.FancyToy
-----------------------------------
Class name: cn.logx.learning.java.basic.typeinfo.HasBatteries is interface? [true]
Simple name: HasBatteries
Canonical name : cn.logx.learning.java.basic.typeinfo.HasBatteries
-----------------------------------
Class name: cn.logx.learning.java.basic.typeinfo.Waterproof is interface? [true]
Simple name: Waterproof
Canonical name : cn.logx.learning.java.basic.typeinfo.Waterproof
-----------------------------------
Class name: cn.logx.learning.java.basic.typeinfo.Shoots is interface? [true]
Simple name: Shoots
Canonical name : cn.logx.learning.java.basic.typeinfo.Shoots
-----------------------------------
Class name: cn.logx.learning.java.basic.typeinfo.Toy is interface? [false]
Simple name: Toy
Canonical name : cn.logx.learning.java.basic.typeinfo.Toy
-----------------------------------
 */