package miniProject;

import java.util.Scanner;

public class Hourly extends SalaryForMonth {
	private int standardHours = 8;
	private float overtimeRate = 1.5f;
	private int totalHoursWorked;
	
	Hourly(float pAmount) {
		super(pAmount);
	}

	public int getStandardHours() {
		return standardHours;
	}

	public void setStandardHours(int sHours) {
		this.standardHours = sHours;
	}

	public float getOvertimeRate() {
		return overtimeRate;
	}

	public void setOvertimeRate(float overtimeRate) {
		this.overtimeRate = overtimeRate;
	}
	
	public int getTotalHoursWorked() {
		return this.totalHoursWorked;
	}

	public void setTotalHoursWorked(int tHoursWorked) {
		this.totalHoursWorked = tHoursWorked;
	}
	
	public void promptForInput() {
		Scanner scan = new Scanner(System.in);
		String input = "";
		boolean invalid = true;
		
		while(invalid) {
			System.out.print("Input total hours worked for this month (default 0): ");
			input = scan.nextLine();
			
			if(input.matches("\\d+")) {
				setTotalHoursWorked(Integer.parseInt(input));
				invalid = false;
			}
			else if(input.equals("")) {
				setTotalHoursWorked(0);
				invalid = false;
			}
			else {
				System.out.println("Invalid input, try again.");
			}
		}
		
		invalid = true;
		while(invalid) {
			System.out.print("Input performance bonus for this month (default 0): ");
			input = scan.nextLine();
			if(input.matches("\\d+")) {
				setPerformanceBonusAmount(Float.parseFloat(input));
				invalid = false;
			}
			else if(input.equals("")) {
				setPerformanceBonusAmount(0);
				invalid = false;
			}
			else {
				System.out.println("Invalid input, try again.");
			}
		}
	}

	@Override
	public void computeSalary() {
		float overtimePay = 0;
		float normalPay = 0;
		int standardHoursInMonth = getworkDaysForMonth() * standardHours;
		int overtimeHoursInMonth = 0;
		
		if(totalHoursWorked > standardHoursInMonth) {
			overtimePay = getPayAmount() * overtimeRate * overtimeHoursInMonth;
			normalPay = standardHoursInMonth * getPayAmount();
			overtimeHoursInMonth = totalHoursWorked - standardHoursInMonth;
		}
		else {
			normalPay = totalHoursWorked * getPayAmount();
		}
		
		float totalPay =  normalPay + overtimePay + getPerformanceBonusAmount();
		setTotalSalary(totalPay);
		
		System.out.println("\nStandard work hours: " + standardHoursInMonth);
		System.out.println("Total hours worked: " + totalHoursWorked);
		System.out.println("Total overtime hours worked: " + overtimeHoursInMonth);
		System.out.println("Basic salary: " + normalPay);
		System.out.println("Overtime salary: " + overtimePay);
		System.out.println("Performance bonus: " + getPerformanceBonusAmount());
		System.out.println("Gross salary: " + totalPay);
	}

}
