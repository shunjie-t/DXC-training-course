package march25;

import java.util.Scanner;

public class Multithreading1 {

	public static void main(String[] args) {
		Banking b = new Banking();
		Printing p = new Printing();
		Adding a = new Adding();
		
		b.start();
		p.start();
		a.start();
	}

}

class Banking extends Thread {
	public void run() {
		System.out.println("Banking activity has started.");
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter account number: ");
		int an = scan.nextInt();
		System.out.print("Enter password: ");
		int pw = scan.nextInt();
		System.out.println("Collect your money.");
		System.out.println("Banking activity has been completed.");
	}
}

class Printing extends Thread {
	public void run() {
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
}

class Adding extends Thread {
	public void run() {
		System.out.println("Adding activity had started.");
		int a = 10;
		int b = 20;
		int c = a + b;
		System.out.println(c);
		System.out.println("Adding activity has been completed.");
	}
}