package miniProject;

import java.util.Date;
import java.util.Scanner;

public abstract class SalaryForMonth {
	private float performanceBonusAmount = 0;
	private int currentMonth = new Date().getMonth();
	private int currentYear = new Date().getYear();
	private int workDaysForMonth;
	private float payAmount;
	private float totalSalary;
	
	SalaryForMonth(float pAmount) {
		// set workDaysForMonth based on currentMonth and currentYear
		this.workDaysForMonth = 23;
		
		this.payAmount = pAmount;
	}
	
	public float getPerformanceBonusAmount() {
		return this.performanceBonusAmount;
	}
	
	public void setPerformanceBonusAmount(float pBonusAmount) {
		this.performanceBonusAmount = pBonusAmount;
	}
	
	public int getCurrentMonth() {
		return this.currentMonth;
	}
	
	public void setCurrentMonth(int cMonth) {
		/*if() {
			this.currentMonth = cMonth;
		}
		else {
			System.out.println("Invalid month.");
		}*/
		this.currentMonth = cMonth;
	}
	
	public int getCurrentYear() {
		return this.currentYear;
	}
	
	public void setCurrentYear(int cYear) {
		/*if() {
			this.currentYear = cYear;
		}
		else {
			System.out.println("Invalid year.");
		}*/
		this.currentYear = cYear;
	}
	
	public int getworkDaysForMonth() {
		return this.workDaysForMonth;
	}
	
	public float getPayAmount() {
		return this.payAmount;
	}
	
	protected void setPayAmount(float pAmount) {
		this.payAmount = pAmount;
	}
	
	public float getTotalSalary() {
		return this.totalSalary;
	}
	
	protected void setTotalSalary(float tSalary) {
		this.totalSalary = tSalary;
	}
	
	public void displaySalaryForMonth() {
		System.out.printf("Gross salary: %.2f%n", totalSalary);
	}
	
	abstract public void promptForInput();
	abstract public void computeSalary();
}
