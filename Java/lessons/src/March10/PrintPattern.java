package march10;

public class PrintPattern {
	public static void main(String[] args) {
		exercise1();
		exercise2();
	}
	
	public static void exercise1() {
		for(int a = 1; a <= 10; a++) {
			for(int b = 1; b <= 5; b++) {
				if(a == 1 || a == 6 || b == 1 || b == 5) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}
	
	public static void exercise2() {
		for(int a = 1; a <= 11; a++) {
			for(int b = 1; b <= 10; b++) {
				if(a == 1 || a == 6 || a == 11 || b == 1 || b == 10) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}
}
