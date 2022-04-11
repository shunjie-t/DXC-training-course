package march22;

public class AbstractClass {

	public static void main(String[] args) {
		SubClass3 sc = new SubClass3();
		sc.display();
		sc.show();
	}

}

abstract class SuperClass3 {
	abstract public void display();
	
	public void show() {
		System.out.println("From super class");
	}
}

class SubClass3 extends SuperClass3 {
	public void display() {
		System.out.println("From sub class");
	}
}
