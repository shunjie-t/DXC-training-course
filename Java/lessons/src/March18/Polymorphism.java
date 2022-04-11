package march18;

public class Polymorphism {

	public static void main(String[] args) {
		Forest f = new Forest();
		
		f.permit(new Tiger());
		f.permit(new Deer());
		f.permit(new Monkey());
		
		// polymorphism is instance of sub class referencing to super class type reference.
		Animal t = new Tiger();
		Animal d = new Deer();
		Animal m = new Monkey();
	}

}

class Forest {
	void permit(Animal ref) {
		ref.eat(ref);
		ref.sleep(ref);
	}
}

class Animal {
	public void eat(Animal a) {
		System.out.println("Creature is eating");
	}
	public void sleep(Animal a) {
		System.out.println("Creature is sleeping");
	}
}

class Tiger extends Animal {
	public void eat(Animal t) {
		System.out.println("Tiger is eating");
	}
	public void movement(Animal t) {
		System.out.println("Tiger is moving");
	}
}

class Deer extends Animal {
	public void eat(Animal d) {
		System.out.println("Deer is eating");
	}
	public void movement(Animal d) {
		System.out.println("Deer is moving");
	}
}

class Monkey extends Animal {
	public void eat(Animal m) {
		System.out.println("Monkey is eating");
	}
	public void movement(Animal m) {
		System.out.println("Monkey is moving");
	}
}
