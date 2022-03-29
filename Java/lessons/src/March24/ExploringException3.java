package March24;

import java.util.Scanner;

public class ExploringException3 {

	public static void main(String[] args) {
		ThrowingClass tc = new ThrowingClass();
		try {
			tc.throwingMethod();
		}
		catch(ArithmeticException e) {
			System.out.println("Handled arithmetic exception in main method");
		}
	}

}

class ThrowingClass {
		
	public void throwingMethod() {
		Scanner scan = new Scanner(System.in);
		
		try {
			System.out.print("Enter the numerator: ");
			int a = scan.nextInt();
			System.out.print("Enter the denominator: ");
			int b = scan.nextInt();
			int c = a/b;
			System.out.printf("Result is: %d%n%n",c);
		}
		catch(Exception e) {
			System.out.println("Handled exception in throwingMethod method.");
			throw e;
		}
		finally {
			scan.close();
			System.out.println("Connection terminated");
		}
	}
}