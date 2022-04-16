package mainProject;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
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
	private ArrayList<SalaryForMonth> salaryRecord;
	
	private String[] payTypeAvailable = {"hourly","monthly","commission","monthly with commission"};
	public Scanner scan = new Scanner(System.in);
	private LocalDate dt = LocalDate.now();
	private int idx = -1;
	
	Employee(String eNum, String fName, String lName, LocalDate dob, LocalDate jDate, String pType, float pAmount) {
		this.employeeNumber = eNum;
		this.firstName = fName;
		this.lastName = lName;
		this.dateOfBirth = dob;
		this.joinDate = jDate;
		this.payType = pType;
		this.payAmount = pAmount;
		this.salaryRecord = retrieveSalaryRecords();
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
	
	public ArrayList<SalaryForMonth> getSalaryRecord() {
		return salaryRecord;
	}

	public void displayAndUpdateDetails() {
		String input;
		int option;
		boolean repeat = true;
		int size = salaryRecord.size();
		HashMap<LocalDate,Integer> dateIdx = new HashMap<LocalDate,Integer>();
		
		System.out.println("Enter month and year in MMYYYY to view and edit past payrolls.");
		System.out.println("Defaults to lastest month if no input is entered.");
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("00. Exit system.");
		System.out.println("0. Previous menu.");
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("Date of past payrolls.");
		for(int a = 0; a < size; a+=6) {
			if(size < 6 || (a+6) > size) {
				for(int b = 0; b < (size % 6); b++) {
					dateIdx.put(LocalDate.of(salaryRecord.get(a+b).getCurrentDate().getYear(),salaryRecord.get(a+b).getCurrentDate().getMonthValue(), 1),a+b);
					System.out.print(String.format("%2s", salaryRecord.get(a+b).getCurrentDate().getMonthValue())+"-"+salaryRecord.get(a+b).getCurrentDate().getYear()+"  ");
				}
				System.out.println("");
			}
			else {
				dateIdx.put(LocalDate.of(salaryRecord.get(a).getCurrentDate().getYear(),salaryRecord.get(a).getCurrentDate().getMonthValue(),1),a);
				dateIdx.put(LocalDate.of(salaryRecord.get(a+1).getCurrentDate().getYear(),salaryRecord.get(a+1).getCurrentDate().getMonthValue(),1),a+1);
				dateIdx.put(LocalDate.of(salaryRecord.get(a+2).getCurrentDate().getYear(),salaryRecord.get(a+2).getCurrentDate().getMonthValue(),1),a+2);
				dateIdx.put(LocalDate.of(salaryRecord.get(a+3).getCurrentDate().getYear(),salaryRecord.get(a+3).getCurrentDate().getMonthValue(),1),a+3);
				dateIdx.put(LocalDate.of(salaryRecord.get(a+4).getCurrentDate().getYear(),salaryRecord.get(a+4).getCurrentDate().getMonthValue(),1),a+4);
				dateIdx.put(LocalDate.of(salaryRecord.get(a+5).getCurrentDate().getYear(),salaryRecord.get(a+5).getCurrentDate().getMonthValue(),1),a+5);
				
				System.out.print(String.format("%2s",salaryRecord.get(a).getCurrentDate().getMonthValue())+"-"+salaryRecord.get(a).getCurrentDate().getYear()+"  ");
				System.out.print(String.format("%2s",salaryRecord.get(a+1).getCurrentDate().getMonthValue())+"-"+salaryRecord.get(a+1).getCurrentDate().getYear()+"  ");
				System.out.print(String.format("%2s",salaryRecord.get(a+2).getCurrentDate().getMonthValue())+"-"+salaryRecord.get(a+2).getCurrentDate().getYear()+"  ");
				System.out.print(String.format("%2s",salaryRecord.get(a+3).getCurrentDate().getMonthValue())+"-"+salaryRecord.get(a+3).getCurrentDate().getYear()+"  ");
				System.out.print(String.format("%2s",salaryRecord.get(a+4).getCurrentDate().getMonthValue())+"-"+salaryRecord.get(a+4).getCurrentDate().getYear()+"  ");
				System.out.println(String.format("%2s",salaryRecord.get(a+5).getCurrentDate().getMonthValue())+"-"+salaryRecord.get(a+5).getCurrentDate().getYear());
			}
		}
		while(repeat) {
			System.out.printf("Select a date in MMYYYY (%d%d): ",
					salaryRecord.get(salaryRecord.size()-1).getCurrentDate().getMonthValue(),
					salaryRecord.get(salaryRecord.size()-1).getCurrentDate().getYear());
			input = scan.nextLine();
			if(input.matches("0")) {
				return;
			}
			else if(input.matches("00+")) {
				System.out.println("Exiting system.");
				System.exit(0);
			}
			else if(input.matches("\\d{5}") || input.matches("\\d{6}") || input.isBlank()) {
				int month = 0;
				int year = 0;
				
				if(input.matches("\\d{5}")) {
					month = Integer.parseInt(input.substring(0,1));
					year = Integer.parseInt(input.substring(1,5));
				}
				else if(input.matches("\\d{6}")) {
					month = Integer.parseInt(input.substring(0,2));
					year = Integer.parseInt(input.substring(2,6));
				}
				else if(input.isBlank()) {
					month = salaryRecord.get(salaryRecord.size()-1).getCurrentDate().getMonthValue();
					year = salaryRecord.get(salaryRecord.size()-1).getCurrentDate().getYear();
				}
				
				try {
					LocalDate tempDt = LocalDate.of(year, month, 1);
					idx = dateIdx.get(tempDt);
					repeat = false;
				}
				catch(NullPointerException npe) {
					System.out.println("Invalid date, try again.");
				}
				catch(DateTimeException dte) {
					System.out.println("Invalid date, try again.");
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			else {
				System.out.println("Invalid input, try again.");
			}
		}
		
		repeat = true;
		while(repeat) {
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
			System.out.printf("3. Performance bonus: %.2f%n",salaryRecord.get(idx).getPerformanceBonusAmount());
			salaryRecord.get(idx).displaySalaryDetails();
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.printf("%s %d, gross salary: %.2f%n",dt.getMonth(),dt.getYear(),salaryRecord.get(idx).getTotalSalary());
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.print("Enter an option: ");
			
			input = scan.next();
			if(input.matches("[1-6]")) {
				option = Integer.parseInt(input);
				updateDetails(option);
			}
			else if(input.matches("0")) {
				return;
			}
			else if(input.matches("00+")) {
				System.out.println("Exiting system.");
				System.exit(0);
			}
			else {
				System.out.println("Invalid input, try again");
			}
		}
	}
	
	public void updateDetails(int option) {
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
						return;
					}
					else if(input.matches("0")) {
						return;
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
				System.out.println("000. Exit system.");
				System.out.println("00. Previous menu.");
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
					
					
					if(input.matches("00")) {
						return;
					}
					else if(input.matches("000+")) {
						System.out.println("Exiting system.");
						System.exit(0);
					}
					else if(input.matches("^\\d+\\.{0,1}\\d{0,2}$")) {
						this.setPayAmount(Float.parseFloat(input));
						salaryRecord.get(idx).setPayAmount(Float.parseFloat(input));
						return;
					}
					else {
						System.out.println("Invalid input, try again.");
					}
				}
			}
			else if(option == 3) {
				System.out.println("\nEnter new performance bonus amount");
				System.out.println("-----------------------------------------------------------------------------------------------");
				System.out.println("000. Exit system.");
				System.out.println("00. Previous menu.");
				System.out.println("-----------------------------------------------------------------------------------------------");
				while(true) {
					System.out.printf("Current bonus: $%.2f%n",salaryRecord.get(idx).getPerformanceBonusAmount());
					System.out.print("Bonus amount: ");
					input = scan.next();
					
					if(input.matches("00")) {
						return;
					}
					else if(input.matches("000+")) {
						System.out.println("Exiting system.");
						System.exit(0);
					}
					else if(input.matches("^\\d+\\.{0,1}\\d{0,2}$")) {
						salaryRecord.get(idx).setPerformanceBonusAmount(Float.parseFloat(input));
						return;
					}
					else {
						System.out.println("Invalid input, try again.");
					}
				}

			}
			else if(option <= 6 ) {
				salaryRecord.get(idx).promptAndUpdateSalary(option);
				return;
			}
			else {
				System.out.print("Invalid input, try again.");
			}
		}
	}
	
	public boolean calculateTotalPay() {
		String input = "";
		boolean repeat = true;
		int size = salaryRecord.size();
		HashMap<LocalDate,Integer> dateIdx = new HashMap<LocalDate,Integer>();
		
		System.out.println("Enter month and year in MMYYYY to calculate past payrolls.");
		System.out.println("Defaults to current month if no input is entered.");
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("00. Exit system.");
		System.out.println("0. Previous menu.");
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("Date of past payrolls.");
		for(int a = 0; a < size; a+=6) {
			if(size < 6 || (a+6) > size) {
				for(int b = 0; b < (size % 6); b++) {
					dateIdx.put(LocalDate.of(salaryRecord.get(a+b).getCurrentDate().getYear(),salaryRecord.get(a+b).getCurrentDate().getMonthValue(), 1),a+b);
					System.out.print(String.format("%2s", salaryRecord.get(a+b).getCurrentDate().getMonthValue())+"-"+salaryRecord.get(a+b).getCurrentDate().getYear()+"  ");
				}
				System.out.println("");
			}
			else {
				dateIdx.put(LocalDate.of(salaryRecord.get(a).getCurrentDate().getYear(),salaryRecord.get(a).getCurrentDate().getMonthValue(),1),a);
				dateIdx.put(LocalDate.of(salaryRecord.get(a+1).getCurrentDate().getYear(),salaryRecord.get(a+1).getCurrentDate().getMonthValue(),1),a+1);
				dateIdx.put(LocalDate.of(salaryRecord.get(a+2).getCurrentDate().getYear(),salaryRecord.get(a+2).getCurrentDate().getMonthValue(),1),a+2);
				dateIdx.put(LocalDate.of(salaryRecord.get(a+3).getCurrentDate().getYear(),salaryRecord.get(a+3).getCurrentDate().getMonthValue(),1),a+3);
				dateIdx.put(LocalDate.of(salaryRecord.get(a+4).getCurrentDate().getYear(),salaryRecord.get(a+4).getCurrentDate().getMonthValue(),1),a+4);
				dateIdx.put(LocalDate.of(salaryRecord.get(a+5).getCurrentDate().getYear(),salaryRecord.get(a+5).getCurrentDate().getMonthValue(),1),a+5);
				
				System.out.print(String.format("%2s",salaryRecord.get(a).getCurrentDate().getMonthValue())+"-"+salaryRecord.get(a).getCurrentDate().getYear()+"  ");
				System.out.print(String.format("%2s",salaryRecord.get(a+1).getCurrentDate().getMonthValue())+"-"+salaryRecord.get(a+1).getCurrentDate().getYear()+"  ");
				System.out.print(String.format("%2s",salaryRecord.get(a+2).getCurrentDate().getMonthValue())+"-"+salaryRecord.get(a+2).getCurrentDate().getYear()+"  ");
				System.out.print(String.format("%2s",salaryRecord.get(a+3).getCurrentDate().getMonthValue())+"-"+salaryRecord.get(a+3).getCurrentDate().getYear()+"  ");
				System.out.print(String.format("%2s",salaryRecord.get(a+4).getCurrentDate().getMonthValue())+"-"+salaryRecord.get(a+4).getCurrentDate().getYear()+"  ");
				System.out.println(String.format("%2s",salaryRecord.get(a+5).getCurrentDate().getMonthValue())+"-"+salaryRecord.get(a+5).getCurrentDate().getYear());
			}
		}
		while(repeat) {
			System.out.printf("Select a date in MMYYYY (%d%d): ",dt.getMonthValue(),dt.getYear());
			input = scan.nextLine();
			if(input.matches("0")) {
				return true;
			}
			else if(input.matches("00+")) {
				System.out.println("Exiting system.");
				System.exit(0);
			}
			else if(input.matches("\\d{5}") || input.matches("\\d{6}") || input.isBlank()) {
				int month = 0;
				int year = 0;
				
				if(input.matches("\\d{5}")) {
					month = Integer.parseInt(input.substring(0,1));
					year = Integer.parseInt(input.substring(1,5));
				}
				else if(input.matches("\\d{6}")) {
					month = Integer.parseInt(input.substring(0,2));
					year = Integer.parseInt(input.substring(2,6));
				}
				else if(input.isBlank()) {
					month = dt.getMonthValue();
					year = dt.getYear();
				}
				
				try {
					LocalDate tempDt = LocalDate.of(year, month, 1);
					idx = dateIdx.get(tempDt);					
					repeat = false;
				}
				catch(NullPointerException npe) {
					if(year < joinDate.getYear() || month < joinDate.getMonthValue() && year == joinDate.getYear()) {
						System.out.println("Invalid date, must not be earlier than join date.");
					}
					else {
						idx = -1;
						repeat = false;
					}
				}
				catch(DateTimeException dte) {
					System.out.println("Invalid date, try again.");
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			else {
				System.out.println("Invalid input, try again.");
			}
		}
		
		if(idx == -1) {
			SalaryForMonth sfm = null;
			
			if(payType.equals("hourly")) {
				sfm = new Hourly(this.payAmount);
			}
			else if(payType.equals("monthly")) {
				sfm = new Monthly(this.payAmount);
			}
			else if(payType.equals("commission")) {
				sfm = new Commission(this.payAmount);
			}
			else if(payType.equals("monthly with commission")) {
				sfm = new MonthlyWithCommission(this.payAmount);
			}
			else {
				System.out.println("Invalid pay type!");
			}
			
			salaryRecord.add(sfm);
			idx = salaryRecord.size() - 1;
			
			repeat = salaryRecord.get(idx).promptForInput();
			if(!repeat) salaryRecord.get(idx).computeSalary();
		}
		else {
			repeat = salaryRecord.get(idx).promptForInput();
			if(!repeat) salaryRecord.get(idx).computeSalary();
		}
		
		return repeat;
	}
	
	private ArrayList<SalaryForMonth> retrieveSalaryRecords() {
		ArrayList<SalaryForMonth> s = new ArrayList<SalaryForMonth>();
		
		for(int a = joinDate.getYear(); a <= dt.getYear(); a++) {
			if(a != joinDate.getYear()) {
				for(int b = 1; b <= 12; b++) {
					if(a == dt.getYear() && b >= dt.getMonthValue()) {
						continue;
					}
					else {
						if(payType.equals("hourly")) {
							s.add(new Hourly(this.payAmount,LocalDate.of(a, b, 1)));
						}
						else if(payType.equals("monthly")) {
							s.add(new Monthly(this.payAmount,LocalDate.of(a, b, 1)));
						}
						else if(payType.equals("commission")) {
							s.add(new Commission(this.payAmount,LocalDate.of(a, b, 1)));
						}
						else if(payType.equals("monthly with commission")) {
							s.add(new MonthlyWithCommission(this.payAmount,LocalDate.of(a, b, 1)));
						}
						else {
							System.out.println("Invalid pay type!");
						}
					}
				}
			}
			else {
				for(int b = joinDate.getMonthValue(); b <= 12; b++) {
					if(a == dt.getYear() && b >= dt.getMonthValue()) {
						continue;
					}
					else {
						if(payType.equals("hourly")) {
							s.add(new Hourly(this.payAmount,LocalDate.of(a, b, 1)));
						}
						else if(payType.equals("monthly")) {
							s.add(new Monthly(this.payAmount,LocalDate.of(a, b, 1)));
						}
						else if(payType.equals("commission")) {
							s.add(new Commission(this.payAmount,LocalDate.of(a, b, 1)));
						}
						else if(payType.equals("monthly with commission")) {
							s.add(new MonthlyWithCommission(this.payAmount,LocalDate.of(a, b, 1)));
						}
						else {
							System.out.println("Invalid pay type!");
						}
					}
				}
			}
		}
		
		return s;
	}
}
