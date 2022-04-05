package miniProject;

public class Hourly extends SalaryForMonth {
	private int standardHoursPerDay = 8;
	private float overtimeRate = 1.5f;
	private int totalHoursWorked = 0;
	
	Hourly(float pAmount) {
		super(pAmount);
	}

	public int getStandardHoursPerDay() {
		return standardHoursPerDay;
	}

	public void setStandardHoursPerDay(int sHours) {
		this.standardHoursPerDay = sHours;
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
	
	public boolean promptForInput() {
		String input = "";
		boolean invalid = true;
		
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("000. Exit system.");
		System.out.println("00. Previous menu.");
		System.out.println("-----------------------------------------------------------------------------------------------");
		
		while(invalid) {
			System.out.printf("Current total hours worked: %d%n",totalHoursWorked);
			System.out.printf("Input total hours worked for this month (%d): ",totalHoursWorked);
			input = scan.nextLine();
			
			if(input.matches("[1-9]\\d*")) {
				setTotalHoursWorked(Integer.parseInt(input));
				invalid = false;
			}
			else if(input.isBlank()) {
				invalid =  false;
			}
			else if(input.matches("00")) {
				return true;
			}
			else if(input.matches("000+")) {
				System.exit(0);
			}
			else {
				System.out.println("Invalid input, try again.");
			}
		}
		
		invalid = true;
		while(invalid) {
			System.out.printf("Current performance bonus: %.2f%n",getPerformanceBonusAmount());
			System.out.printf("Input performance bonus for this month (%.2f): ",getPerformanceBonusAmount());
			input = scan.nextLine();
			if(input.matches("^\\d+\\.{0,1}\\d{0,2}$")) {
				setPerformanceBonusAmount(Float.parseFloat(input));
				invalid = false;
			}
			else if(input.isBlank()) {
				invalid =  false;
			}
			else if(input.matches("00")) {
				return true;
			}
			else if(input.matches("000+")) {
				System.exit(0);
			}
			else {
				System.out.println("Invalid input, try again.");
			}
		}
		
		return false;
	}

	@Override
	public void computeSalary() {
		float overtimePay = 0;
		float normalPay = 0;
		int standardHoursInMonth = getWorkDaysForMonth() * standardHoursPerDay;
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
		
		System.out.printf("\nWork days in %s %d: %d days%n",currentDate.getMonth(), currentDate.getYear(),getWorkDaysForMonth());
		System.out.println("Standard work hours: " + standardHoursInMonth);
		System.out.println("Total hours worked: " + totalHoursWorked);
		System.out.println("Total overtime hours worked: " + overtimeHoursInMonth);
		System.out.println("Basic salary: " + normalPay);
		System.out.println("Overtime salary: " + overtimePay);
		System.out.println("Performance bonus: " + getPerformanceBonusAmount());
		System.out.println("Gross salary: " + totalPay);
	}
	
	@Override
	public void displaySalaryDetails() {
		System.out.printf("4. Standard work hours: %d%n", standardHoursPerDay);
		System.out.printf("5. Overtime rate: %.2f%n", overtimeRate);
		System.out.printf("6. Total hours worked: %d%n", totalHoursWorked);
	}

	@Override
	public boolean promptAndUpdateSalary(int option) {
		String input;
		
		if(option == 4) {
			System.out.println("\nEnter new standard work hours per day.");
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("No input defaults to current amount.");
			System.out.println("0. Previous menu.");
			System.out.println("00. Exit system.");
			System.out.println("-----------------------------------------------------------------------------------------------");
			while(true) {
				System.out.printf("Current standard work hours: %d%n",getStandardHoursPerDay());
				System.out.print("Hours: ");
				input = scan.next();
				if(input.matches("^[1-12]$")) {
					setStandardHoursPerDay(Integer.parseInt(input));
					return false;
				}
				else if(input.isEmpty()) {
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
					System.out.println("Invalid input, try again");
				}
			}
		}
		else if(option == 5) {
			System.out.println("\nEnter new overtime pay rate");
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("No input defaults to current rate.");
			System.out.println("0. Previous menu.");
			System.out.println("00. Exit system.");
			System.out.println("-----------------------------------------------------------------------------------------------");
			while(true) {
				System.out.printf("Current rate: $%.2f%n",getOvertimeRate());
				System.out.print("Rate in decimal: ");
				input = scan.next();
				if(input.matches("^0\\.[1-9][0-9]+$")) {
					setStandardHoursPerDay(Integer.parseInt(input));
					return false;
				}
				else if(input.isEmpty()) {
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
					System.out.println("Invalid input, try again");
				}
			}
		}
		else {
			System.out.println("\nEnter new total hours worked.");
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("No input defaults to current hours.");
			System.out.println("00. Previous menu.");
			System.out.println("000. Exit system.");
			System.out.println("-----------------------------------------------------------------------------------------------");
			while(true) {
				System.out.printf("Current total hours worked: %d%n",getTotalHoursWorked());
				System.out.print("Total hours: ");
				input = scan.next();
				if(input.matches("^\\d{0,2}$")) {
					this.setTotalHoursWorked(Integer.parseInt(input));
					return false;
				}
				else if(input.isEmpty()) {
					return false;
				}
				else if(input.matches("^00$")) {
					return true;
				}
				else if(input.matches("^000+$")) {
					System.out.println("Exiting system.");
					System.exit(0);
				}
				else {
					System.out.println("Invalid input, try again");
				}
			}
		}
	}
}
