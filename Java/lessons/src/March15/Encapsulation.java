package March15;

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
	
	ElectricFan() {}
	
	ElectricFan(String brand, String color) {
		this.brand = brand;
		this.color = color;
	}
}
