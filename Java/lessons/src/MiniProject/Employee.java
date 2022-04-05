package miniProject;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Employee {
	private String employeeNumber;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private LocalDate joinDate;
	private String payType;
	private float payAmount;
	private SalaryForMonth salary;
	
	private String[] payTypeAvailable = {"hourly","monthly","commission","monthly with commission"};
	public Scanner scan = new Scanner(System.in);
	private LocalDate dt = LocalDate.now();
	
	Employee(String eNum, String fName, String lName, LocalDate dob, LocalDate jDate, String pType, float pAmount) {
		this.employeeNumber = eNum;
		this.firstName = fName;
		this.lastName = lName;
		this.dateOfBirth = dob;
		this.joinDate = jDate;
		this.payType = pType;
		this.payAmount = pAmount;
		
		if(pType.equals("hourly")) {
			this.salary = new Hourly(this.payAmount);
		}
		else if(pType.equals("monthly")) {
			this.salary = new Monthly(this.payAmount);
		}
		else if(pType.equals("commission")) {
			this.salary = new Commission(this.payAmount);
		}
		else if(pType.equals("monthly with commission")) {
			this.salary = new MonthlyWithCommission(this.payAmount);
		}
		else {
			System.out.println("Invalid pay type!");
		}
		
		this.salary.setPayAmount(this.payAmount);
	}
	
	public String getEmployeeNumber() {
		return this.employeeNumber;
	}
	
	public void setEmployeeNumber(String eNum) {
		this.employeeNumber = eNum;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String fName) throws InputMismatchException {
		try {
			if(fName.matches("\\d+")) {
				throw new InputMismatchException();
			}
			else {
				this.firstName = fName;
			}
		}
		catch(InputMismatchException e) {
			System.out.println("First name cannot contain numbers");
		}
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lName) throws InputMismatchException {
		try {
			if(lName.matches("\\d+")) {
				throw new InputMismatchException();
			}
			else {
				this.lastName = lName;
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Last name cannot contain numbers");
		}
	}
	
	public LocalDate getDateOfBirth() {
		return this.dateOfBirth;
	}
	
	public void setDateOfBirth(LocalDate dob) {
		this.dateOfBirth = dob;
	}
	
	public LocalDate getJoinDate() {
		return this.joinDate;
	}
	
	public void setJoinDate(LocalDate jDate) {
		this.joinDate = jDate;
	}
	
	public String getPayType() {
		return this.payType;
	}
	
	public void setPayType(String pType) {
		this.payType = pType;
	}
	
	public float getPayAmount() {
		return this.payAmount;
	}
	
	public void setPayAmount(float pAmount) {
		this.payAmount = pAmount;
	}
	
	public SalaryForMonth getSalary() {
		return this.salary;
	}
	
	public boolean displayAndUpdateDetails() {
		String input;
		int option;
		
		while(true) {
			System.out.println("\nEmployee's basic information");
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.printf("Employee number: %s%n",getEmployeeNumber());
			System.out.printf("First name: %s%n",getFirstName());
			System.out.printf("Last name: %s%n",getLastName());
			System.out.printf("Date of birth: %d-%d-%d%n",getDateOfBirth().getDayOfMonth(),getDateOfBirth().getMonthValue(),getDateOfBirth().getYear());
			System.out.printf("Date of join: %d-%d-%d%n",getJoinDate().getDayOfMonth(),getJoinDate().getMonthValue(),getJoinDate().getYear());
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("Employee's salary information, enter an number to edit.");
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("00. Exit system.");
			System.out.println("0. Previous menu.");
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.printf("1. Pay type: %s%n",getPayType());
			System.out.printf("2. Pay amount: %.2f%n",getPayAmount());
			System.out.printf("3. Performance bonus: %.2f%n",salary.getPerformanceBonusAmount());
			salary.displaySalaryDetails();
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.printf("%s %d, gross salary: %.2f%n",dt.getMonth(),dt.getYear(),salary.getTotalSalary());
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.print("Enter an option: ");
			
			input = scan.next();
			if(input.matches("[1-6]")) {
				option = Integer.parseInt(input);
				return updateDetails(option);
			}
			else if(input.matches("0")) {
				return true;
			}
			else if(input.matches("00")) {
				System.out.println("Exiting system.");
				System.exit(0);
			}
			else {
				System.out.println("Invalid input, try again");
			}
		}
	}
	
	public boolean updateDetails(int option) {
		String input = "";
		
		while(true) {
			if(option == 1) {
				System.out.println("Select a new pay type to change to");
				System.out.println("-----------------------------------------------------------------------------------------------");
				System.out.println("00. Exit system.");
				System.out.println("0. Previous menu.");
				System.out.println("-----------------------------------------------------------------------------------------------");
				for(int i = 0; i < payTypeAvailable.length; i++) {
					if(payTypeAvailable[i].equals(payType)) 
						System.out.printf("%d. %s (current)%n",(i+1), payTypeAvailable[i]);
					else System.out.printf("%d. %s%n",(i+1), payTypeAvailable[i]);
				}
				System.out.println("-----------------------------------------------------------------------------------------------");
				while(true) {
					System.out.print("Enter an option: ");
					input = scan.next();
					if(input.matches("[1-4]")) {
						this.setPayType(payTypeAvailable[ (Integer.parseInt(input) - 1) ]);
						return false;
					}
					else if(input.matches("0")) {
						return true;
					}
					else if(input.matches("00+")) {
						System.out.println("Exiting system.");
						System.exit(0);
					}
					else {
						System.out.println("Invalid input, try again.");
					}
				}
			}
			else if(option == 2) {
				System.out.println("\nEnter new pay amount");
				System.out.println("-----------------------------------------------------------------------------------------------");
				System.out.println("00. Exit system.");
				System.out.println("0. Previous menu.");
				System.out.println("-----------------------------------------------------------------------------------------------");
				while(true) {
					if(payType.equals(payTypeAvailable[0])) {
						System.out.printf("Current pay per hour: $%.2f%n",getPayAmount());
						System.out.print("Pay per hour amount: ");
					}
					else {
						System.out.printf("Current pay per month: $%.2f%n",getPayAmount());
						System.out.print("Pay per month amount: ");
					}
					
					input = scan.next();
					
					if(input.matches("^[1-9]\\d+\\.*\\d{2}$")) {
						this.setPayAmount(Float.parseFloat(input));
						salary.setPayAmount(Float.parseFloat(input));
						return false;
					}
					else if(input.matches("0")) {
						return true;
					}
					else if(input.matches("00+")) {
						System.out.println("Exiting system.");
						System.exit(0);
					}
					else {
						System.out.println("Invalid input, try again.");
					}
				}
			}
			else if(option == 3) {
				System.out.println("\nEnter new performance bonus amount");
				System.out.println("-----------------------------------------------------------------------------------------------");
				System.out.println("00. Exit system.");
				System.out.println("0. Previous menu.");
				System.out.println("-----------------------------------------------------------------------------------------------");
				while(true) {
					System.out.printf("Current bonus: $%.2f%n",getPayAmount());
					System.out.print("Bonus amount: ");
					input = scan.next();
					if(input.matches("^[1-9]\\d+\\.*\\d{2}$")) {
						salary.setPerformanceBonusAmount(Float.parseFloat(input));
						return false;
					}
					else if(input.matches("0")) {
						return true;
					}
					else if(input.matches("00+")) {
						System.out.println("Exiting system.");
						System.exit(0);
					}
					else {
						System.out.println("Invalid input, try again.");
					}
				}

			}
			else if(option <= 6 ) {
				salary.promptAndUpdateSalary(option);
				return false;
			}
			else {
				System.out.print("Invalid input, try again.");
			}
		}
	}
	
	public boolean calculateTotalPay() {
		boolean repeat = false;
		
		repeat = salary.promptForInput();
		if(!repeat) salary.computeSalary();
		
		return repeat;
	}
}
