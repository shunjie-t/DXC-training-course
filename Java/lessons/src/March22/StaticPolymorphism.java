package march22;

public class StaticPolymorphism {

	public static void main(String[] args) {
		SuperClass0 sc = new SubClass0();
		sc.meth();
		sc.staticMeth();
	}

}

class SuperClass0 {
	public void meth() {
		System.out.println("meth from super class");
	}
	
	public static void staticMeth() {
		System.out.println("staticMeth from super class");
	}
}

class SubClass0 extends SuperClass0 {
	public void meth() {
		System.out.println("meth from sub class");
	}
	
	// static method is hidden from polymorhpism
	public static void staticMeth() {
		System.out.println("staticMeth from sub class");
	}
}
