package March17;

public class Inheritance {

	public static void main(String[] args) {
		SubClass sbc = new SubClass();
		sbc.display();
	}

}

class SubClass extends SuperClass {
	
}

class SuperClass {
	int a = 10;
	float b = 20.5f;
	
	public void display() {
		System.out.println(a);
		System.out.println(b);
	}
}
