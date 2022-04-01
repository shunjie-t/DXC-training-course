package miniProject;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class PayrollSystem {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		initiate();
		scan.close();
	}
	
	public static void initiate() {
		String input;
		boolean running = true;
		
		System.out.println("Welcome to payroll system.");
		while(running) {
			displayMenu();
			System.out.print("Enter an option: ");
			input = scan.nextLine(); // outofmemory exception
			System.out.println("");
			
			switch(input) {
			case "0":
				scan.close();
				running = false;
				System.out.println("Exiting system.");
				break;
			case "1":
				computeEmployeePay();
				break;
			case "2":
				viewOrEditEmployeeDetails();
				break;
//			case "3":
//				addNewEmployee();
//				break;
//			case "4":
//				deleteEmployee();
//				break;
			default:
				System.out.println("Invalid input, please enter number 0-4");
			}
		}
	}
	
	public static void displayMenu() {
		System.out.println("\n----------------------------------------------------");
		System.out.println("0. Exit system.");
		System.out.println("1. Compute existing employee's salary for the month.");
		System.out.println("2. View or edit existing employee details.");
//		System.out.println("3. Add a new employee.");
//		System.out.println("4. Delete an employee.");
		System.out.println("----------------------------------------------------");
	}
	
	public static Employee[] displayEmployees() {
//		Employee[] emp = retrieveEmployeeRecords();
		Employee[] emp = {
				new Employee("F1290","John","Smith",new Date(1998,2,23),new Date(2022,2,1),"monthly",4000.00f),
				new Employee("F0312","Sean","Hoffman",new Date(1987,3,30),new Date(2015,9,1),"monthly with commission",2500.00f),
				new Employee("F1292","Faye","Johnson", new Date(1997,5,12),new Date(2022,0,1),"commission",0.00f),
				new Employee("F0946","Leonard","Baumer",new Date(1971,7,5),new Date(2017,0,1),"hourly",24.00f)
		};
		
		System.out.println("Select an employee");
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("ID\tEmployee number\t\tFirst name\t\tLast name\t\tPay type");
		for(int i = 0; i < emp.length; i++) {
			System.out.printf("%d.\t%s\t\t\t%s\t\t\t%s\t\t\t%s%n",(i+1),emp[i].getEmployeeNumber(),emp[i].getFirstName(),emp[i].getLastName(),emp[i].getPayType());
		}
		
		return emp;
	}
	
	public static void computeEmployeePay() {
		String input;
		int index = 0;
		boolean prompt = true;
		boolean exit = false;
		
		Employee[] emp = displayEmployees();

		while(prompt && !exit) {
//			System.out.print("Enter an ID or filter by employee number or name: ");
			System.out.print("Enter an ID: ");
			input = scan.nextLine();
			
			if(input.matches("\\d+")) {
				index = (Integer.parseInt(input) - 1);
				prompt = false;
			}
			else {
				System.out.println("Invalid input, try again.");
			}
		}
		
		emp[index].calculateTotalPay();
	}
	
	public static void viewOrEditEmployeeDetails() {
		String input;
		int index = 0;
		boolean prompt = true;
		boolean exit = false;
		
		Employee[] emp = displayEmployees();
		
		while(prompt && !exit) {
//			System.out.print("Enter an ID or filter by employee number or name: ");
			System.out.print("Enter an ID: ");
			input = scan.nextLine();
			
			if(input.matches("\\d+")) {
				index = Integer.parseInt(input);
				prompt = false;
			}
			else {
				System.out.println("Invalid input, try again.");
			}
		}
		
		emp[index].displayDetail();
		input = scan.nextLine();
		System.out.println(input);
	}
	
//	public static void addNewEmployee() {}
	
//	public static void deleteEmployee() {}
	
	/*private static Employee[] retrieveEmployeeRecords() {
		// connect to database and get the employee's records
		return new Employee[0];
	}*/
}
