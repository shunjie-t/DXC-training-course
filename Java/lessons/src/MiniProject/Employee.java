package MiniProject;

import java.util.Date;
import java.util.InputMismatchException;

public class Employee extends SalaryForMonth {
	private String employeeNumber;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String jobTitle;
	private int baseSalary;
	private Date joinDate;
	
	Employee() {}
	
	Employee(int tHoursWorked, String eNum, String fName, String lName, Date dob, String jTitle, int bSalary, Date jDate) {
		this.employeeNumber = eNum;
		this.firstName = fName;
		this.lastName = lName;
		this.dateOfBirth = dob;
		this.jobTitle = jTitle;
		this.baseSalary = bSalary;
		this.joinDate = jDate;
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
		this.dateOfBirth = dob;
	}
	
	public String getJobTitle() {
		return this.jobTitle;
	}
	
	public void setJobTitle(String jTitle) {
		this.jobTitle = jTitle;
	}
	
	public int getBaseSalary() {
		return this.baseSalary;
	}
	
	public void setBaseSalary(int bSalary) {
		this.baseSalary = bSalary;
	}
	
	public Date getJoinDate() {
		return this.joinDate;
	}
	
	public void setJoinDate(Date jDate) {
		this.joinDate = jDate;
	}

	@Override
	public void calculateBaseSalary() {
		// TODO Auto-generated method stub
		
	}
}
