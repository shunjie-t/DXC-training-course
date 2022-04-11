package march23;

public class InterfaceEncapsulation {
	
	public static void main(String[] args) {
		System.out.println("fs");
		Medium md = new Medium();
	}
}

class Medium implements Test1 {
	
}

interface Test1 {
	private void priv() {
		System.out.println("Help");
	}
	
	default void defa() {
		System.out.println("Help");
	}
	
	static void stat() {
		System.out.println("Help");
	}
}
