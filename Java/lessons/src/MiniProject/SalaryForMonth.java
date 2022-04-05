package miniProject;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public abstract class SalaryForMonth {
	private float performanceBonusAmount = 0;
	protected LocalDate currentDate = LocalDate.now();
	private int workDaysForMonth = 0;
	private float payAmount;
	private float totalSalary;
	public Scanner scan = new Scanner(System.in);
	
	SalaryForMonth(float pAmount) {
		LocalDate tempDate;
		
		for(int i = 1; i <= currentDate.lengthOfMonth(); i++) {
			tempDate = LocalDate.of(currentDate.getYear(), currentDate.getMonthValue(), i);
			if(tempDate.getDayOfWeek() != DayOfWeek.SATURDAY && tempDate.getDayOfWeek() != DayOfWeek.SUNDAY) {
				this.workDaysForMonth++;
			}
		}
		
		this.payAmount = pAmount;
	}
	
	public float getPerformanceBonusAmount() {
		return this.performanceBonusAmount;
	}
	
	public void setPerformanceBonusAmount(float pBonusAmount) {
		this.performanceBonusAmount = pBonusAmount;
	}
	
	public LocalDate getDate() {
		return this.currentDate;
	}
	
	public void setDate(LocalDate cDate) {
		this.currentDate = cDate;
	}
	
	public int getWorkDaysForMonth() {
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
	
	
	abstract public boolean promptForInput();
	abstract public void computeSalary();
	
	abstract public void displaySalaryDetails();
	abstract public boolean promptAndUpdateSalary(int option);
}
