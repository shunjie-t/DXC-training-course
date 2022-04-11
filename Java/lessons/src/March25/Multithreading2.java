package march25;

import java.util.Scanner;

public class Multithreading2 {

	public static void main(String[] args) {
		Banking2 b = new Banking2();
		Printing2 p = new Printing2();
		Adding2 a = new Adding2();
		
		Thread t1 = new Thread(b);
		Thread t2 = new Thread(p);
		Thread t3 = new Thread(a);
		
		t1.start();
		t2.start();
		t3.start();
	}

}

class Banking2 implements Runnable {
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

class Printing2 implements Runnable {
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

class Adding2 implements Runnable {
	public void run() {
		System.out.println("Adding activity had started.");
		int a = 10;
		int b = 20;
		int c = a + b;
		System.out.println(c);
		System.out.println("Adding activity has been completed.");
	}
}