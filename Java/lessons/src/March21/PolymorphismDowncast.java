package march21;

public class PolymorphismDowncast {

	public static void main(String[] args) {
		Child1 c1 = new Child1();
		Child2 c2 = new Child2();
		
		Parent ref;
		
		ref = c1;
		ref.eat();
		((Child1) ref).cry(); // down casting
		
		ref = c2;
		ref.eat();
		((Child2) ref).cry();
	}

}

class Parent {
	public void eat() {
		System.out.println("parent is eating");
	}
}

class Child1 extends Parent {
	public void eat() {
		System.out.println("child1 eats heavily");
	}
	
	public void cry() {
		System.out.println("child1 cries loudly");
	}
}

class Child2 extends Parent {
	public void eat() {
		System.out.println("child2 eats lightly");
	}
	
	public void cry() {
		System.out.println("child2 does not cry");
	}
}
