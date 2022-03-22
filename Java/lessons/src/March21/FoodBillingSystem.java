package March21;

import java.util.ArrayList;
import java.util.Scanner;

public class FoodBillingSystem {

	public static void main(String[] args) {
		displayMenu();
	}
	
	private static void displayMenu() {
		Scanner scan = new Scanner(System.in);
		String customerName;
		int itemID;
		String itemName = "";
		float itemPrice;
		float subtotal = 0.0f;
		int quantity;
		String input = "";
		char display = 'Y';
		ArrayList<Bill> bill = new ArrayList<Bill>();
		
		System.out.println("Welcome to Resorts World!");
		System.out.print("Dear customer, please enter your name: ");
		customerName = scan.nextLine().trim();
		
		System.out.printf("%nHello %s, please enter an item number to place an order.%n", customerName);
		
		while(display == 'Y') {
			System.out.println("----------------------------------------------");
			System.out.println("ItemID       ItemName                    Price");
			System.out.println("----------------------------------------------");
			System.out.println("1.           mineral water               $1.50");
			System.out.println("2.           coca cola                   $1.80");
			System.out.println("3.           pizza                       $6.50");
			System.out.println("4.           burger                      $4.50");
			System.out.println("5.           fries                       $3.00");
			System.out.println("----------------------------------------------");
			
			input = scan.next();
			while(!input.matches("[1-5]")) {
				System.out.print("Invalid menu item. Please enter option 1 - 5: ");
				input = scan.next();
			}
			itemID = Integer.parseInt(input);
			
			System.out.print("Enter the quantity for item: ");
			input = scan.next();
			while(!input.matches("^[1-9]\\d*")) {
				System.out.print("Invalid input. Please enter a number: ");
				input = scan.next();
			}
			quantity = Integer.parseInt(input);
			
			switch(itemID) {
			case 1:
				itemName = "mineral water";
				itemPrice = 1.50f;
				subtotal = itemPrice * quantity;
				break;
			case 2:
				itemName = "coca cola";
				itemPrice = 1.80f;
				subtotal = itemPrice * quantity;
				break;
			case 3:
				itemName = "pizza";
				itemPrice = 6.50f;
				subtotal = itemPrice * quantity;
				break;
			case 4:
				itemName = "burger";
				itemPrice = 4.50f;
				subtotal = itemPrice * quantity;
				break;
			case 5:
				itemName = "fries";
				itemPrice = 3.00f;
				subtotal = itemPrice * quantity;
				break;
			}
			System.out.println("ItemID\t\t\tItemName\t\t\tQuantity\t\t\tSubtotal");
			System.out.printf("%d\t\t\t%s\t\t\t%d\t\t\t%.2f",itemID,itemName,quantity,subtotal);
			
			System.out.print("Would you like to order more? (Y/N)");
			input = scan.nextLine();
			input.toUpperCase();
			char inputChar[] = input.toCharArray();
			display = inputChar[0];
		}
		
		scan.close();
	}
}

class Bill {
	private String itemName;
	private float itemprice;
	private int quantity;
	private float subtotal;
	
	public Bill() {}
	
	public String toString() {
		return itemName+"\t\t\t"+itemprice+"\t\t\t"+quantity+"\t\t\t"+subtotal;
	}
}
