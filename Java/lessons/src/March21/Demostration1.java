package March21;

public class Demostration1 {

	public static void main(String[] args) {
		// covariant inheritance
		Example2 ex2 = new Example2();
		ex2.display();
	}

}

class Example1 {
	Animal display() {
		System.out.println("Inside example 1");
		Animal a = new Animal();
		return a;
	}
}

class Example2 extends Example1 {
	Tiger display() {
		System.out.println("Inside example 2");
		Tiger t = new Tiger();
		return t;
	}
}

class Animal {}

class Tiger extends Animal {}
