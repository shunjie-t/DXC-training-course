package March16;

public class NumberOfObjects {
	
	public static void main(String[] args) {
		new Dollar();
		System.out.println(Dollar.amount);
		new Dollar();
		System.out.println(Dollar.amount);
		new Dollar();
		System.out.println(Dollar.amount);
	}
}

class Dollar {
	// When attribute of a class is set as static, 
	// it is shared amount multiple instances of the object.
	public static int amount;
	
	public Dollar() {
		amount++;
	}
}
