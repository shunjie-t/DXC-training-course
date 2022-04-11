package march23;

import java.util.Scanner;

public class Interfaces {
	
	public void allow(UserInterface ref) {
		ref.add();
		ref.sub();
		ref.mul();
		ref.div();
	}

	public static void main(String[] args) {
		Interfaces inf = new Interfaces();
		inf.allow(new UserInterface());
		
		Calculator cal = new UserInterface();
		cal.add();
		cal.sub();
		cal.mul();
		cal.div();
		((UserInterface) cal).end(); // downcast
		
		/* 
		 * variables in interfaces are final(constants) and cannot be changed 
		 * code below will produce error
		 * */
		// cal.count = 8;
	}

}

class UserInterface implements Calculator {
	private float firstNumber;
	private float secondNumber;
	private Scanner scan = new Scanner(System.in);

	@Override
	public void add() {
		System.out.println("Addition");
		System.out.print("Enter first number to add: ");
		firstNumber = scan.nextFloat();
		System.out.print("Enter second number to add: ");
		secondNumber = scan.nextFloat();
		System.out.println("Result is: " + (firstNumber + secondNumber));
	}

	@Override
	public void sub() {
		System.out.println("Subtraction");
		System.out.print("Enter first number to subtract: ");
		firstNumber = scan.nextFloat();
		System.out.print("Enter second number to subtract: ");
		secondNumber = scan.nextFloat();
		System.out.println("Result is: " + (firstNumber - secondNumber));
	}

	@Override
	public void mul() {
		System.out.println("Multiplication");
		System.out.print("Enter first number to multiply: ");
		firstNumber = scan.nextFloat();
		System.out.print("Enter second number to multiply: ");
		secondNumber = scan.nextFloat();
		System.out.println("Result is: " + (firstNumber * secondNumber));
	}

	@Override
	public void div() {
		System.out.println("Division");
		System.out.print("Enter first number to divide: ");
		firstNumber = scan.nextFloat();
		System.out.print("Enter second number to divide: ");
		secondNumber = scan.nextFloat();
		System.out.println("Result is: " + (firstNumber / secondNumber));
	}
	
	public void end() {
		scan.close();
	}
}

interface Calculator {
	// variables in interface must be final and are final by default
	public int count = 6; 
	
	// public methods in interface must be abstract and are abstract by default
	void add();
	void sub();
	void mul();
	void div();
	
	private void test() {
		System.out.println("Hey");
	}
}