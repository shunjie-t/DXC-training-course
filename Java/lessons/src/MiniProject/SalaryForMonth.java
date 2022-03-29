package MiniProject;

import java.util.Date;

public abstract class SalaryForMonth {
	private int totalHoursWorked;
	private int currentMonth = new Date().getMonth();
	private int currentYear = new Date().getYear();
	
	SalaryForMonth() {}
	
	SalaryForMonth(int tHoursWorked) {
		this.totalHoursWorked = tHoursWorked;
	}
	
//	SalaryForMonth() {
//		super();
//	}
//	
//	SalaryForMonth(String eNum, String fName, String lName, Date dob, String jTitle, int bSalary, Date jDate, boolean hOvertime) {
//		super(eNum, fName, lName, dob, jTitle, bSalary, jDate);
//		this.hasOvertime = hOvertime;
//	}
	
	public int getTotalHoursWorked() {
		return this.totalHoursWorked;
	}
	
	public void setTotalHoursWorked(int tHoursWorked) {
		this.totalHoursWorked = tHoursWorked;
	}
	
	public int getCurrentMonth() {
		return this.currentMonth;
	}
	
	public void setCurrentMonth(int cMonth) {
		this.currentMonth = cMonth;
	}
	
	public int getCurrentYear() {
		return this.currentYear;
	}
	
	public void setCurrentYear(int cYear) {
		this.currentYear = cYear;
	}
	
	
	
	
	abstract public void calculateBaseSalary();
}
