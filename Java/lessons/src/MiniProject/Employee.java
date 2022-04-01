package miniProject;

import java.util.Date;
import java.util.InputMismatchException;

public class Employee {
	private String employeeNumber;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private Date joinDate;
	private String payType; // hourly, monthly, commission, monthly with commission
	private float payAmount;
	private SalaryForMonth salary;
	
	Employee(String eNum, String fName, String lName, Date dob, Date jDate, String pType, float pAmount) {
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
	
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}
	
	public void setDateOfBirth(Date dob) {
		/*if() {
			this.dateOfBirth = dob;
		}
		else {
			System.out.println("Employee's age cannot be under 18");
		}*/
		this.dateOfBirth = dob;
	}
	
	public Date getJoinDate() {
		return this.joinDate;
	}
	
	public void setJoinDate(Date jDate) {
		/*if() {
			this.joinDate = jDate;
		}
		else {
			System.out.println("Given date cannot be later than today's date.");
		}*/
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
	
	public void displayDetail() {
		System.out.println("Employee's basic information");
		System.out.println("----------------------------------------------------");
		System.out.printf("Employee number: %s%n",getEmployeeNumber());
		System.out.printf("First name: %s%n",getFirstName());
		System.out.printf("Last name: %s%n",getLastName());
		System.out.printf("Date of birth: %d-%d-%d%n",getDateOfBirth().getDay(),getDateOfBirth().getMonth(),getDateOfBirth().getYear());
		System.out.printf("Date of join: %d-%d-%d%n",getJoinDate().getDay(),getJoinDate().getMonth(),getJoinDate().getYear());
		System.out.println("----------------------------------------------------");
		System.out.println("Employee's salary information, enter an number to edit.");
		System.out.printf("1. Pay type: %s%n",getPayType());
		System.out.printf("2. Pay amount: %f%n",getPayAmount());
		System.out.printf("3. Performance bonus: %d%n",salary.getPerformanceBonusAmount());
		
		/*if(getPayType().equals("hourly")) {
			System.out.printf("4. Standard work hours: %d",);
			System.out.printf("5. Overtime rate: %f",);
			System.out.printf("6. Total hours worked: %d",);
		}
		else if(getPayType().equals("monthly")) {
			System.out.printf("4. Unpaid leaves taken: %d",);
		}
		else if(getPayType().equals("commission")) {
			System.out.printf("4. Commission rate: %f",);
			System.out.printf("5. Total sales earning: %f",);
		}
		else {
			System.out.printf("4. Unpaid leaves taken: %d",);
			System.out.printf("5. Commission rate: %f",);
			System.out.printf("6. Total sales earning: %f",);
		}
		System.out.println("----------------------------------------------------");
		System.out.print("Enter an option: ");*/
	}
	
	public void calculateTotalPay() {
		salary.promptForInput();
		salary.computeSalary();
	}
}
