package March18;

public class Inheritance2 {

	public static void main(String[] args) {
		SubClass sbc = new SubClass();
		sbc.display();
	}
}

class SubClass extends SuperClass {
	int a = 100;
	
	public void display() {
		int a = 1000;
		System.out.println("local variable: " + a);
		System.out.println("instance variable: " + this.a);
		System.out.println("inheritance variable: " + super.a);
	}
	
}

class SuperClass {
	int a = 10;
}
