package MiniProject;

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
		
		printMenu();
		
		while(running) {
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
//			case "2":
//				viewOrEditEmployee();
//				break;
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
	
	public static void printMenu() {
		System.out.println("Welcome to payroll system.\n");
		System.out.println("----------------------------------------------------");
		System.out.println("0. Exit system.");
		System.out.println("1. Compute existing employee's salary for the month.");
//		System.out.println("2. View or edit existing employee details.");
//		System.out.println("3. Add a new employee.");
//		System.out.println("4. Delete an employee.");
		System.out.println("----------------------------------------------------");
	}
	
	public static void computeEmployeePay() {
		String input;
		int index = 0;
		boolean prompt = true;
		boolean exit = false;
		SalaryForMonth[] employees = {
				new SalaryForMonth("F1290","John","Tan",new Date(1998,2,23),"junior accountant",2600,new Date(2022,2,1),true),
				new SalaryForMonth("F0312","Sean","Ang",new Date(1987,3,30),"senior accountant",4000,new Date(2015,9,1),true),
				new SalaryForMonth("F1292","Faye","Neo", new Date(1997,5,12),"marketing associate",2900,new Date(2022,0,1),false),
				new SalaryForMonth("F0946","Leonard","Soh",new Date(1971,7,5),"sales associate",1900,new Date(2017,0,1),false)
		};
		
		System.out.println("Select an employee");
		System.out.println("----------------------------------------------");
		System.out.println("ID\tEmployee number\t\tFirst name\t\tLast name\t\tJob title");
		for(int i = 0; i < employees.length; i++) {
			System.out.printf("%d.\t%s\t\t\t%s\t\t\t%s\t\t\t%s%n",(i+1),employees[i].getEmployeeNumber(),employees[i].getFirstName(),employees[i].getLastName(),employees[i].getJobTitle());
		}

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
		
		prompt = true;
		while(prompt && !exit) {
			System.out.print("Enter the total hours worked for the month: ");
			input = scan.nextLine();
			if(input.matches("\\d+")) {
				employees[index].setTotalHoursWorked(Integer.parseInt(input));
				prompt = false;
			}
			else {
				System.out.println("Invalid input, try again.");
			}
		}
		
		if(employees[index].getHasOvertime()) {
			prompt = true;
			while(prompt && !exit) {
				System.out.print("Enter the total overtime hours for the month (default 0): ");
				input = scan.nextLine();
				
				if(input.matches("\\d+")) {
					employees[index].setTotalOvertime(Integer.parseInt(input));
					prompt = false;
				}
				else if(input.equals("")) {
					employees[index].setTotalOvertime(0);
					prompt = false;
				}
				else {
					System.out.println("Invalid input, try again.");
				}
			}
		}
		
		prompt = true;
		while(prompt && !exit) {
			System.out.print("Enter performance bonus for the month (default 0): ");
			input = scan.nextLine();
			
			if(input.matches("\\d+")) {
				employees[index].setTotalOvertime(Integer.parseInt(input));
				prompt = false;
			}
			else if(input.equals("")) {
				employees[index].setTotalOvertime(0);
				prompt = false;
			}
			else {
				System.out.println("Invalid input, try again.");
			}
		}
	}
	
	public static void viewOrEditEmployee() {}
	
	public static void addNewEmployee() {}
	
	public static void deleteEmployee() {}
	
	private static void retrieveEmployeeRecords() {
		// connect to database and get the employee's records
	}
}
