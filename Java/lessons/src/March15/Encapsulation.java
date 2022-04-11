package march15;

public class Encapsulation {

	public static void main(String[] args) {
		ElectricFan ef1 = new ElectricFan("Sharp", "gray");
		ElectricFan ef2 = new ElectricFan();
	}
}

class ElectricFan {
	private String brand;
	private String color;
	private int size;
	
	int a;
	public int b;
	protected int c;
	
	ElectricFan() {}
	
	ElectricFan(String brand, String color) {
		this.brand = brand;
		this.color = color;
	}
}
