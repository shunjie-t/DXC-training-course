package March24;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExploringExpections {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Connection established.");
		try {
			System.out.print("Enter the numerator: ");
			int a = scan.nextInt();
//			float a = scan.nextFloat();
			System.out.print("Enter the denominator: ");
			int b = scan.nextInt();
//			float b = scan.nextFloat();
			int c = a/b;
//			float c = a/b;
			System.out.printf("Result is: %d%n%n",c);
//			System.out.printf("Result is: %.2f%n%n",c);
			
			System.out.print("Creating an array, enter size of array: ");
			int size = scan.nextInt();
			int arr[] = new int[size];
			System.out.print("Enter the element to be inserted: ");
			int element = scan.nextInt();
			System.out.print("Enter the index which the element is to be inserted: ");
			int index = scan.nextInt();
			arr[index] = element;
		}
		catch(ArithmeticException e) {
			System.out.println("0 value as denominator is not allowed. Cannot divide by 0.");
		}
		catch(InputMismatchException e) {
			System.out.println("Non integer input is not allowed. Input only whole number.");
		}
		catch(NegativeArraySizeException e) {
			System.out.println("Negative integer input is not allowed. Input only positive number.");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid index entered. Input an index within the array size.");
		}
		catch(Exception e) {
			System.out.println("Exception occurred.");
		}
		scan.close();
		System.out.println("Connection terminated.");
	}

}
