package March24;

import java.util.Scanner;

public class ExploringException2 {

	public static void main(String[] args) {
		try {
			Cls1 c1 = new Cls1();
			c1.func1();
		}
		catch(ArithmeticException e) {
			// Exception from func4 method is caught here by main method.
			System.out.println("Arithmetic exception caught in main method.");
			e.printStackTrace();
		}
	}

}

class Cls1 {
	public void func1() {
		Cls2 c2 = new Cls2();
		c2.func2();
	}
}
class Cls2 {
	public void func2() {
		Cls3 c3 = new Cls3();
		c3.func3();
	}
}
class Cls3 {
	public void func3() {
		Cls4 c4 = new Cls4();
		c4.func4();
	}
}
class Cls4 {
	public void func4() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Connection established");
		System.out.print("Enter the numerator: ");
		int a = scan.nextInt();
		System.out.print("Enter the denominator: ");
		int b = scan.nextInt();
		
		// Exception will be passed down to the previous methods in the stack if not handled within this current method.
		int c = a/b;
		// Subsequent lines will not be executed as runtime exits func4 when exception occurs during the division.
		System.out.printf("Result is: %d%n%n",c);
		
		scan.close();
		System.out.println("Connection terminated");
	}
}