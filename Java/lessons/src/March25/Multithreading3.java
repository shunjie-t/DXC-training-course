package March25;

import java.util.Scanner;

public class Multithreading3 {

	public static void main(String[] args) {
		Activities a1 = new Activities();
		Activities a2 = new Activities();
		Activities a3 = new Activities();
		
		a1.setName("BANK");
		a2.setName("PRINT");
		a3.setName("ADD");
		
		a1.start();
		a2.start();
		a3.start();
	}

}

class Activities extends Thread {
	public void run() {
		if(getName().equals("BANK")) {
			banking();
		}
		else if(getName().equals("PRINT")) {
			printing();
		}
		else {
			adding();
		}
	}
	
	void banking() {
		System.out.println("Banking activity has started.");
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter account number: ");
		int an = scan.nextInt();
		System.out.print("Enter password: ");
		int pw = scan.nextInt();
		System.out.println("Collect your money.");
		System.out.println("Banking activity has been completed.");
	}
	
	void printing() {
		System.out.println("Printing activity has started.");
		for(int i = 0; i < 5; i++) {
			System.out.println("Printing");
			try {
				Thread.sleep(2000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Printing activity has been completed.");
	}
	
	void adding() {
		System.out.println("Adding activity had started.");
		int a = 10;
		int b = 20;
		int c = a + b;
		System.out.println(c);
		System.out.println("Adding activity has been completed.");
	}
}
