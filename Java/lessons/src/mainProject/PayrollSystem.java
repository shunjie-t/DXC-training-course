package mainProject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PayrollSystem {
	public Scanner scan = new Scanner(System.in);
	private ArrayList<Employee> emp = retrieveEmployeeRecords();
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
			case "3":
				addNewEmployee();
				break;
			case "4":
				deleteEmployee();
				break;
			default:
				System.out.println("Invalid input, please enter option 0-4");
			}
		}
	}
	
	private ArrayList<Employee> retrieveEmployeeRecords() {
		ArrayList<Employee> e = new ArrayList<Employee>();
		e.add(new Employee("F1290","John","Smith",LocalDate.of(1998,2,23),LocalDate.of(2020, 2, 1),"hourly",30.00f));
		e.add(new Employee("F0312","Sean","Hoffman",LocalDate.of(1987,3,30),LocalDate.of(2015,9,1),"monthly",5000.00f));
		e.add(new Employee("F1292","Faye","Johnson", LocalDate.of(1997,5,12),LocalDate.of(2022,1,1),"commission",0.00f)); 
		e.add(new Employee("F0946","Leonard","Baumer",LocalDate.of(1971,7,5),LocalDate.of(2017,1,1),"monthly with commission",2500.00f));
		return e;
	}
	
	public void displayMenu() {
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("0. Exit system.");
		System.out.println("1. Compute existing employee's salary for the month.");
		System.out.println("2. View or edit existing employee details.");
		System.out.println("3. Add a new employee.");
		System.out.println("4. Delete an employee.");
		System.out.println("-----------------------------------------------------------------------------------------------");
	}
	
	public void displayEmployees() {		
		System.out.println("Select an employee");
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("00. Exit system.");
		System.out.println("0. Previous menu.");
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("ID\tEmployee number\t\tFirst name\t\tLast name\t\tPay type");
		for(int i = 0; i < emp.size(); i++) {
			System.out.printf("%d.\t%s\t\t\t%s\t\t\t%s\t\t\t%s%n",(i+1),emp.get(i).getEmployeeNumber(),emp.get(i).getFirstName(),emp.get(i).getLastName(),emp.get(i).getPayType());
		}
	}
	
	public void computeEmployeePay() {
		String input;
		int index = 0;
		boolean prompt = true;
		
		while(prompt) {
			System.out.println("\nCompute existing employee's salary for the month.");
			displayEmployees();
			System.out.print("Enter an ID: ");
			input = scan.nextLine();
			
			if(input.matches("0")) {
				return;
			}
			else if(input.matches("00+")) {
				System.out.println("Exiting system.");
				System.exit(0);
			}
			else if(input.matches("^0*[1-"+emp.size()+"]$")) {
				index = (Integer.parseInt(input) - 1);
				prompt = false;
				
				System.out.printf("%n%s %d salary for %s %s(%s) %n",
						dt.getMonth(),
						dt.getYear(),
						emp.get(index).getFirstName(),
						emp.get(index).getLastName(),
						emp.get(index).getEmployeeNumber());
				prompt = emp.get(index).calculateTotalPay();
			}
			else {
				System.out.println("Invalid input, try again.");
			}
		}
	}
	
	public void viewOrEditEmployeeDetails() {
		String input;
		int index = 0;
		
		while(true) {
			System.out.println("\nView or edit existing employee details");
			displayEmployees();
			System.out.print("Enter an ID: ");
			input = scan.nextLine();
			
			if(input.matches("0*[1-"+emp.size()+"]")) {
				index = Integer.parseInt(input) - 1;
				emp.get(index).displayAndUpdateDetails();
			}
			else if(input.matches("00+")) {
				System.out.println("Exiting system.");
				System.exit(0);
			}
			else if(input.matches("0")) {
				return;
			}
			else {
				System.out.println("Invalid input, try again.");
			}
		}
	}
	
	public void addNewEmployee() {
		String input;
		String[] payTypeAvailable = {"hourly","monthly","commission","monthly with commission"};
		boolean prompt = true;
		
		String employeeNumber = "";
		String firstName = "";
		String lastName = "";
		LocalDate dateOfBirth = null;
		LocalDate joinDate = null;
		String payType = "";
		float payAmount = 0.0f;
		
		System.out.println("\nAdd an Employee");
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("00. Exit system.");
		System.out.println("0. Previous menu.");
		System.out.println("-----------------------------------------------------------------------------------------------");
		
		while(prompt) {
			System.out.print("Enter employee number: ");
			input = scan.nextLine();
			if(input.matches("^[A-Z]\\d{4}$")) {
				employeeNumber = input;
				prompt = false;
			}
			else if(input.matches("^0$")) {
				return;
			}
			else if(input.matches("^00+$")) {
				System.out.println("Exiting system.");
				System.exit(0);
			}
			else {
				System.out.println("Invalid input, employee number must begin with an uppercase alphabet followed by four number.");
			}
		}
		
		prompt = true;
		while(prompt) {
			System.out.print("Enter first name: ");
			input = scan.nextLine();
			if(input.matches("^[a-zA-Z]+$")) {
				firstName = input;
				prompt = false;
			}
			else if(input.matches("^0$")) {
				return;
			}
			else if(input.matches("^00+$")) {
				System.out.println("Exiting system.");
				System.exit(0);
			}
			else {
				System.out.println("Invalid input, try again.");
			}
		}
		
		prompt = true;
		while(prompt) {
			System.out.print("Enter last name: ");
			input = scan.nextLine();
			if(input.matches("^[a-zA-Z]+$")) {
				lastName = input;
				prompt = false;
			}
			else if(input.matches("^0$")) {
				return;
			}
			else if(input.matches("^00+$")) {
				System.out.println("Exiting system.");
				System.exit(0);
			}
			else {
				System.out.println("Invalid input, try again.");
			}
		}
		
		prompt = true;
		while(prompt) {
			System.out.print("Enter date of birth in format DDMMYYYY: ");
			input = scan.nextLine();
			if(input.matches("^\\d+$")) {
				try {
					dateOfBirth = LocalDate.of(
							Integer.parseInt(input.substring(4, 8)), 
							Integer.parseInt(input.substring(2, 4)), 
							Integer.parseInt(input.substring(0, 2))
					);
					prompt = false;
				}
				catch (Exception e) {
					System.out.println("Invalid date, try again");
				}
			}
			else if(input.matches("^0$")) {
				return;
			}
			else if(input.matches("^00+$")) {
				System.out.println("Exiting system.");
				System.exit(0);
			}
			else {
				System.out.println("Invalid input, try again.");
			}
		}
		
		prompt = true;
		while(prompt) {
			System.out.print("Enter date of join in format DDMMYYYY: ");
			input = scan.nextLine();
			if(input.matches("^\\d{8}$")) {
				joinDate = LocalDate.of(
						Integer.parseInt(input.substring(4, 8)), 
						Integer.parseInt(input.substring(2, 4)), 
						Integer.parseInt(input.substring(0, 2))
				);
				prompt = false;
			}
			else if(input.matches("^0$")) {
				return;
			}
			else if(input.matches("^00+$")) {
				System.out.println("Exiting system.");
				System.exit(0);
			}
			else {
				System.out.println("Invalid input, try again.");
			}
		}
		
		prompt = true;
		while(prompt) {
			System.out.println("Select pay type");
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("1. "+payTypeAvailable[0]);
			System.out.println("2. "+payTypeAvailable[1]);
			System.out.println("3. "+payTypeAvailable[2]);
			System.out.println("4. "+payTypeAvailable[3]);
			System.out.println("-----------------------------------------------------------------------------------------------");
			input = scan.nextLine();
			if(input.matches("^[1-4]$")) {
				payType = payTypeAvailable[(Integer.parseInt(input) - 1)];
				prompt = false;
			}
			else if(input.matches("^0$")) {
				return;
			}
			else if(input.matches("^00+$")) {
				System.out.println("Exiting system.");
				System.exit(0);
			}
			else {
				System.out.println("Invalid input, try again.");
			}
		}
		
		if(!payType.equals(payTypeAvailable[2])) {
			prompt = true;
			while(prompt) {
				System.out.print("Enter pay amount: ");
				input = scan.nextLine();
				if(input.matches("^\\d+\\.{0,1}\\d{0,2}$")) {
					payAmount = Float.parseFloat(input);
					prompt = false;
				}
				else if(input.matches("^0$")) {
					return;
				}
				else if(input.matches("^00+$")) {
					System.out.println("Exiting system.");
					System.exit(0);
				}
				else {
					System.out.println("Invalid input, try again.");
				}
			}
		}

		prompt = true;
		while(prompt) {
			System.out.println("\nConfirm creation of new employee");
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("00. Exit system.");
			System.out.println("0. Cancel and back to previous menu.");
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("1. Employee number: " + employeeNumber);
			System.out.println("2. First name: " + firstName);
			System.out.println("3. Last name: " + lastName);
			System.out.printf("4. Date of birth: %d %s %d%n",dateOfBirth.getDayOfMonth(),dateOfBirth.getMonth(),dateOfBirth.getYear());
			System.out.printf("5. Date of join: %d %s %d%n",joinDate.getDayOfMonth(),joinDate.getMonth(),joinDate.getYear());
			System.out.println("6. Pay type: " + payType);
			if(!payType.equals(payTypeAvailable[2])) {
				System.out.println("7. Pay amount: " + payAmount);
			}
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.print("Enter 'ok' to confirm or select option to amend: ");
			input = scan.nextLine();
			input = input.toLowerCase();
			switch(input) {
			case "00":
				System.out.println("Exiting system.");
				System.exit(0);
			case "0":
				return;
			case "1":
				while(prompt) {
					System.out.print("Enter employee number: ");
					input = scan.nextLine();
					if(input.matches("^[a-z]\\d{4}$")) {
						employeeNumber = input;
						prompt = false;
					}
					else if(input.matches("^0$")) {
						return;
					}
					else if(input.matches("^00+$")) {
						System.out.println("Exiting system.");
						System.exit(0);
					}
					else {
						System.out.println("Invalid input, employee number must begin with an alphabet followed by four number.");
					}
				}
				prompt = true;
			break;
			case "2":
				while(prompt) {
					System.out.print("Enter first name: ");
					input = scan.nextLine();
					if(input.matches("^[a-zA-Z]+$")) {
						firstName = input;
						prompt = false;
					}
					else if(input.matches("^0$")) {
						return;
					}
					else if(input.matches("^00+$")) {
						System.out.println("Exiting system.");
						System.exit(0);
					}
					else {
						System.out.println("Invalid input, try again.");
					}
				}
				prompt = true;
				break;
			case "3":
				while(prompt) {
					System.out.print("Enter last name: ");
					input = scan.nextLine();
					if(input.matches("^[a-zA-Z]+$")) {
						lastName = input;
						prompt = false;
					}
					else if(input.matches("^0$")) {
						return;
					}
					else if(input.matches("^00+$")) {
						System.out.println("Exiting system.");
						System.exit(0);
					}
					else {
						System.out.println("Invalid input, try again.");
					}
				}
				prompt = true;
				break;
			case "4":
				while(prompt) {
					System.out.print("Enter date of birth in format DDMMYYYY: ");
					input = scan.nextLine();
					
					if(input.matches("^0$")) {
						return;
					}
					else if(input.matches("^00+$")) {
						System.out.println("Exiting system.");
						System.exit(0);
					}
					else if(input.matches("^\\d{8}$")) {
						try {
							dateOfBirth = LocalDate.of(
									Integer.parseInt(input.substring(4, 8)), 
									Integer.parseInt(input.substring(2, 4)), 
									Integer.parseInt(input.substring(0, 2))
							);
							prompt = false;
						}
						catch (Exception e) {
							System.out.println("Invalid date, try again");
						}
					}
					else {
						System.out.println("Invalid input, try again.");
					}
				}
				prompt = true;
				break;
			case "5":
				while(prompt) {
					System.out.print("Enter date of join in format DDMMYYYY: ");
					input = scan.nextLine();
					
					if(input.matches("^0$")) {
						return;
					}
					else if(input.matches("^00+$")) {
						System.out.println("Exiting system.");
						System.exit(0);
					}
					else if(input.matches("^\\d{8}$")) {
						joinDate = LocalDate.of(
								Integer.parseInt(input.substring(4, 8)), 
								Integer.parseInt(input.substring(2, 4)), 
								Integer.parseInt(input.substring(0, 2))
						);
						prompt = false;
					}
					else {
						System.out.println("Invalid input, try again.");
					}
				}
				prompt = true;
				break;
			case "6":
				while(prompt) {
					System.out.println("Select pay type");
					System.out.println("-----------------------------------------------------------------------------------------------");
					System.out.println("1. "+payTypeAvailable[0]);
					System.out.println("2. "+payTypeAvailable[1]);
					System.out.println("3. "+payTypeAvailable[2]);
					System.out.println("4. "+payTypeAvailable[3]);
					System.out.println("-----------------------------------------------------------------------------------------------");
					input = scan.nextLine();
					if(input.matches("^[1-4]$")) {
						payType = payTypeAvailable[(Integer.parseInt(input) - 1)];
						prompt = false;
					}
					else if(input.matches("^0$")) {
						return;
					}
					else if(input.matches("^00+$")) {
						System.out.println("Exiting system.");
						System.exit(0);
					}
					else {
						System.out.println("Invalid input, try again.");
					}
				}
				prompt = true;
				break;
			case "7":
				if(!payType.equals(payTypeAvailable[2])) {
					while(prompt) {
						System.out.print("Enter pay amount: ");
						input = scan.nextLine();
						if(input.matches("^\\d+\\.{0,1}\\d{0,2}$")) {
							payAmount = Float.parseFloat(input);
							prompt = false;
						}
						else if(input.matches("^0$")) {
							return;
						}
						else if(input.matches("^00+$")) {
							System.out.println("Exiting system.");
							System.exit(0);
						}
						else {
							System.out.println("Invalid input, try again.");
						}
					}
					prompt = true;
				}
				else {
					System.out.println("Invalid input, try again.");
				}
				break;
			case "ok":
				prompt = false;
				break;
			default:
				System.out.println("Invalid input, try again.");
				break;
			}
		}

		emp.add(new Employee(employeeNumber,firstName,lastName,dateOfBirth,joinDate,payType,payAmount));
		System.out.println("Employee added.");
	}
	
	public void deleteEmployee() {
		String input;
		int i = 0;
		
		while(true) {
			System.out.println("\nDelete an employee");
			displayEmployees();
			System.out.println("Enter an ID");
			input = scan.nextLine();
			if(input.matches("^0*[1-"+emp.size()+"]$")) {
				i = Integer.parseInt(input) - 1;
				System.out.printf("Employee: %s %s(%s) deleted.%n",emp.get(i).getFirstName(),emp.get(i).getLastName(),emp.get(i).getEmployeeNumber());
				emp.remove(i);
				return;
			}
			else if(input.equals("0")) {
				return;
			}
			else if(input.matches("^00+$")) {
				System.out.println("Exiting system.");
				System.exit(0);
			}
			else {
				System.out.println("Invalid input, try again.");
			}
		}
	}
}
