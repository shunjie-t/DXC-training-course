package March24;

import java.util.Scanner;

public class BankingProgram {

	public static void main(String[] args) {
		Bank b = new Bank();
		b.initiate();
	}

}

class Atm {
	private int accountNumber = 1111;
	private int password = 2222;
	private int ANinput, PWinput;
	
	void inputCredentials() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter your account number: ");
		ANinput = scan.nextInt();
		System.out.print("Please enter your password: ");
		PWinput = scan.nextInt();
	}
	
	void verifyCredentials() throws InvalidCredentialsException {
		if(accountNumber == ANinput && password == PWinput) {
			System.out.println("Collect your money and card.");
		}
		else {
			InvalidCredentialsException ice = new InvalidCredentialsException();
			System.out.println(ice.getMessage()+" - From Atm class");
			throw new InvalidCredentialsException();
		}
	}
}

class InvalidCredentialsException extends Exception {
	public String getMessage() {
		return "Invalid credentials entered";
	}
}

class Bank {
	public void initiate () {
		Atm atm = new Atm();
		atm.inputCredentials();
		try {
			atm.verifyCredentials();
		}
		catch(InvalidCredentialsException e) {
			System.out.println(e.getMessage()+" - From Bank class");
		}
	}
}
