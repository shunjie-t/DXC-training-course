package miniProject;

import java.time.LocalDate;
import java.util.Scanner;

public class PayrollSystem {
	public Scanner scan = new Scanner(System.in);
	private Employee[] emp = retrieveEmployeeRecords();
	private LocalDate dt = LocalDate.now();

	public static void main(String[] args) throws Exception {
		PayrollSystem ps = new PayrollSystem();
		ps.initialize();
		ps.scan.close();
	}
	
	public void initialize() {
		String input;
		boolean running = true;
		
		System.out.println("Welcome to payroll system.");
		System.out.printf("Today's date: %d %s %d%n",dt.getDayOfMonth(), dt.getMonth(), dt.getYear());
		while(running) {
			displayMenu();
			System.out.print("Enter an option: ");
			input = scan.nextLine();
			
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
				System.out.println("Invalid input, please enter number 0-2");
			}
		}
	}
	
	private Employee[] retrieveEmployeeRecords() {
		Employee[] emp = {
				new Employee("F1290","John","Smith",LocalDate.of(1998, 2, 23),LocalDate.of(2022, 2, 1),"hourly",4000.00f),
				new Employee("F0312","Sean","Hoffman",LocalDate.of(1987,3,30),LocalDate.of(2015,9,1),"monthly",2500.00f),
				new Employee("F1292","Faye","Johnson", LocalDate.of(1997,5,12),LocalDate.of(2022,1,1),"commission",0.00f),
				new Employee("F0946","Leonard","Baumer",LocalDate.of(1971,7,5),LocalDate.of(2017,1,1),"monthly with commission",24.00f)
		};
		return emp;
	}
	
	public void displayMenu() {
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("0. Exit system.");
		System.out.println("1. Compute existing employee's salary for the month.");
		System.out.println("2. View or edit existing employee details.");
//		System.out.println("3. Add a new employee.");
//		System.out.println("4. Delete an employee.");
		System.out.println("-----------------------------------------------------------------------------------------------");
	}
	
	public void displayEmployees() {		
		System.out.println("\nSelect an employee");
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("00. Exit system.");
		System.out.println("0. Previous menu.");
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("ID\tEmployee number\t\tFirst name\t\tLast name\t\tPay type");
		for(int i = 0; i < emp.length; i++) {
			System.out.printf("%d.\t%s\t\t\t%s\t\t\t%s\t\t\t%s%n",(i+1),emp[i].getEmployeeNumber(),emp[i].getFirstName(),emp[i].getLastName(),emp[i].getPayType());
		}
	}
	
	public void computeEmployeePay() {
		String input;
		int index = 0;
		boolean prompt = true;
		
		while(prompt) {
			displayEmployees();
			System.out.print("Enter an ID: ");
			input = scan.nextLine();
			
			if(input.matches("00+")) {
				System.out.println("Exiting system.");
				System.exit(0);
			}
			else if(input.matches("0")) {
				return;
			}
			else if(input.matches("0*[1-"+emp.length+"]")) {
				index = (Integer.parseInt(input) - 1);
				prompt = false;
			}
			else {
				System.out.println("Invalid input, try again.");
			}
			
			System.out.printf("%n%s %d salary for %s %s(%s) %n",
					dt.getMonth(),
					dt.getYear(),
					emp[index].getFirstName(),
					emp[index].getLastName(),
					emp[index].getEmployeeNumber());
			prompt = emp[index].calculateTotalPay();
		}
	}
	
	public void viewOrEditEmployeeDetails() {
		String input;
		int index = 0;
		boolean prompt = true;
		
		while(prompt) {
			displayEmployees();
			System.out.print("Enter an ID: ");
			input = scan.nextLine();
			
			if(input.matches("00+")) {
				System.out.println("Exiting system.");
				System.exit(0);
			}
			else if(input.matches("0")) {
				return;
			}
			else if(input.matches("0*[1-"+emp.length+"]")) {
				index = Integer.parseInt(input) - 1;
				prompt = false;
			}
			else {
				System.out.println("Invalid input, try again.");
			}
			
			prompt = emp[index].displayAndUpdateDetails();
		}
	}
	
//	public void addNewEmployee() {}
	
//	public void deleteEmployee() {}
}
