package March23;

import java.util.Scanner;

public class AbstractAndInterfaces {
	
	public void allow(UIPart2 ref) {
		ref.add();
		ref.sub();
		ref.mul();
		ref.div();
	}

	public static void main(String[] args) {
		AbstractAndInterfaces AandI = new AbstractAndInterfaces();
		AandI.allow(new UIPart2());
		
		Calculator1 cal1 = new UIPart2();
		cal1.add();
		cal1.sub();
		cal1.mul();
		cal1.div();
		((UIPart2) cal1).end();
	}

}

abstract class UIPart1 implements Calculator1 {
	protected float firstNumber;
	protected float secondNumber;
	protected Scanner scan = new Scanner(System.in);

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
	
	public void end() {
		scan.close();
	}
}

class UIPart2 extends UIPart1 {

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
	
}

interface Calculator1 {
	abstract public void add();
	abstract public void sub();
	abstract public void mul();
	abstract public void div();
}