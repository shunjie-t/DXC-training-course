package march22;

public class Launcher1 {
	
	public static void main(String[] args) {
		Sky s = new Sky();
		
		s.permit(new Sparrow());
		s.permit(new GoldenEagle());
		s.permit(new SerpentEagle());
	}
	
}

class Sky {
	void permit(Bird ref) {
		ref.eat();
		ref.fly();
	}
}

abstract class Bird {
	abstract protected void fly();
	abstract protected void eat();

}

abstract class Eagle extends Bird {
	abstract protected void fly();
	
	protected void eat() {
		System.out.println("Eagle is eating");
	}
}

class Sparrow extends Bird {
	protected void fly() {
		System.out.println("Sparrow is flying");
	}
	
	protected void eat() {
		System.out.println("Sparrow is eating");
	}
}

class GoldenEagle extends Eagle {
	protected void fly() {
		System.out.println("Golden eagle is flying");
	}
}

class SerpentEagle extends Eagle {
	protected void fly() {
		System.out.println("Serpent eagle is flying");
	}
}
