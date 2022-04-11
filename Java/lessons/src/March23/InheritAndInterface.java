package march23;

public class InheritAndInterface {

	public static void main(String[] args) {
		Calculator2 cal2 = new Calculator2();
		cal2.add();
		cal2.sub();
		cal2.mul();
		cal2.div();
	}

}

class Calculator2 extends AddAndSub implements MulAndDiv {

	@Override
	public void mul() {
		int a = 10;
		int b = 5;
		System.out.println(a * b);
	}

	@Override
	public void div() {
		int a = 35;
		int b = 5;
		System.out.println(a / b);
	}
	
}

class AddAndSub {	
	public void add() {
		int a = 10;
		int b = 5;
		System.out.println(a + b);
	}
	
	public void sub() {
		int a = 35;
		int b = 5;
		System.out.println(a - b);
	}
}

interface MulAndDiv {
	public void mul();
	public void div();
}