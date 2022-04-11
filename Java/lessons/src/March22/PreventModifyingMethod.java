package march22;

public class PreventModifyingMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class SuperClass2 {
	// final variable or constants cannot be modified after declaring.
	int a = 3;
	
	// final method prevents sub class from modifying it 
	final public void disp() {
		System.out.println("From super class");
	}
}

class SubClass2 extends SuperClass2 {	
	// cannot override final method from super class
//	@Override
//	public void disp() {
//		System.out.println("From sub class");
//	}
}
