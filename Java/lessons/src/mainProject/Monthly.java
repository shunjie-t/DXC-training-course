package mainProject;

import java.time.LocalDate;

public class Monthly extends SalaryForMonth {
	private int unpaidLeaveTaken = 0;
	
	Monthly(float pAmount) {
		super(pAmount);
	}
	
	// branch
	Monthly(float pAmount,LocalDate cDate) {
		super(pAmount,cDate);
	}
	
	public int getUnpaidLeaveTaken() {
		return this.unpaidLeaveTaken;
	}
	
	public void setUnpaidLeaveTaken(int uLeaveTaken) {
		this.unpaidLeaveTaken = uLeaveTaken;
	}
	
	public boolean promptForInput() {
		String input = "";
		boolean invalid = true;
		
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("000. Exit system.");
		System.out.println("00. Previous menu.");
		System.out.println("-----------------------------------------------------------------------------------------------");
		
		while(invalid) {
			System.out.printf("Current unpaid leave taken: %d%n",unpaidLeaveTaken);
			System.out.printf("Input unpaid leave taken (%d): ",unpaidLeaveTaken);
			input = scan.nextLine();
			
			if(input.matches("00")) {
				return true;
			}
			else if(input.matches("000+")) {
				System.exit(0);
			}
			else if(input.matches("^[0-20]$")) {
				setUnpaidLeaveTaken(Integer.parseInt(input));
				invalid = false;
			}
			else if(input.isBlank()) {
				invalid =  false;
			}
			else {
				System.out.println("Invalid input, please enter again");
			}
		}
		
		invalid = true;
		while(invalid) {
			System.out.printf("Current performance bonus: %.2f%n",getPerformanceBonusAmount());
			System.out.printf("Input performance bonus for this month (%.2f): ",getPerformanceBonusAmount());
			input = scan.nextLine();
			
			if(input.matches("00")) {
				return true;
			}
			else if(input.matches("000+")) {
				System.exit(0);
			}
			else if(input.matches("^\\d+\\.{0,1}\\d{0,2}$")) {
				setPerformanceBonusAmount(Float.parseFloat(input));
				invalid = false;
			}
			else if(input.isBlank()) {
				invalid =  false;
			}
			
			else {
				System.out.println("Invalid input, try again.");
			}
		}
		
		return false;
	}

	@Override
	public void computeSalary() {
		float tSalary = 0;
		float pay = getPayAmount();
		float bonus = getPerformanceBonusAmount();
		
		if(unpaidLeaveTaken > 0) {
			tSalary = pay - (pay / getWorkDaysForMonth()) * unpaidLeaveTaken;
			tSalary += bonus;
		}
		else {
			tSalary = pay + bonus;
		}
		
		tSalary = Math.round(tSalary * 100);
		tSalary /= 100; 
		setTotalSalary(tSalary);
		
		System.out.printf("\nWork days in %s %d: %d days%n",currentDate.getMonth(), currentDate.getYear(),getWorkDaysForMonth());
		System.out.println("Unpaid leaves taken: " + unpaidLeaveTaken);
		System.out.printf("Basic salary: %.2f%n", pay);
		System.out.printf("Performance bonus: %.2f%n", bonus);
		System.out.printf("Gross salary: %.2f%n", getTotalSalary());
	}

	@Override
	public void displaySalaryDetails() {
		System.out.printf("4. Unpaid leaves taken: %d%n", unpaidLeaveTaken);
	}

	@Override
	public boolean promptAndUpdateSalary(int option) {
		String input;
		
		System.out.println("\nEnter new unpaid leaves taken.");
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("No input defaults to current leaves.");
		System.out.println("00. Previous menu.");
		System.out.println("000. Exit system.");
		System.out.println("-----------------------------------------------------------------------------------------------");
		while(true) {
			System.out.printf("Current unpaid leaves taken: %d%n",getUnpaidLeaveTaken());
			System.out.print("Leaves: ");
			input = scan.next();
			
			if(input.isEmpty()) {
				return false;
			}
			else if(input.matches("00")) {
				return true;
			}
			else if(input.matches("000+")) {
				System.out.println("Exiting system.");
				System.exit(0);
			}
			else if(input.matches("^[1-2]*\\d$")) {
				this.setUnpaidLeaveTaken(Integer.parseInt(input));
				return false;
			}
			else {
				System.out.println("Invalid input, try again");
			}
		}
	}
}
