package mainProject;

import java.time.LocalDate;

public class Commission extends SalaryForMonth {
	private float commissionRate = 0.15f;
	private float totalSalesAmount = 0.0f;
	
	Commission(float pAmount) {
		super(pAmount);
	}
	
	// branch
	Commission(float pAmount,LocalDate cDate) {
		super(pAmount,cDate);
	}

	public float getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(float commissionRate) {
		this.commissionRate = commissionRate;
	}

	public float getTotalSalesAmount() {
		return totalSalesAmount;
	}

	public void setTotalSalesAmount(float totalSalesAmount) {
		this.totalSalesAmount = totalSalesAmount;
	}
	
	public boolean promptForInput() {
		String input = "";
		boolean invalid = true;
		
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("000. Exit system.");
		System.out.println("00. Previous menu.");
		System.out.println("-----------------------------------------------------------------------------------------------");
		
		while(invalid) {
			System.out.printf("Current total sales earnings: %.2f%n",totalSalesAmount);
			System.out.printf("Input total sales earnings for this month (%.2f): ",totalSalesAmount);
			input = scan.nextLine();
			
			if(input.isBlank()) {
				invalid =  false;
			}
			else if(input.matches("00")) {
				return true;
			}
			else if(input.matches("000+")) {
				System.exit(0);
			}
			else if(input.matches("^\\d+\\.{0,1}\\d{0,2}$")) {
				setTotalSalesAmount(Float.parseFloat(input));
				invalid = false;
			}
			else {
				System.out.println("Invalid input, try again.");
			}
		}
		
		invalid = true;
		while(invalid) {
			System.out.printf("Current performance bonus: %.2f%n",getPerformanceBonusAmount());
			System.out.print("Input performance bonus for this month (default 0): ");
			input = scan.nextLine();
			
			if(input.isBlank()) {
				invalid =  false;
			}
			else if(input.matches("00")) {
				return true;
			}
			else if(input.matches("000+")) {
				System.exit(0);
			}
			else if(input.matches("^\\d+\\.{0,1}\\d{0,2}$")) {
				setPerformanceBonusAmount(Float.parseFloat(input));
				invalid = false;
			}
			else {
				System.out.println("Invalid input, try again.");
			}
		}
		
		return false;
	}

	@Override
	public void computeSalary() {
		float pay = totalSalesAmount * commissionRate;
		float tSalary = pay + getPerformanceBonusAmount();
		
		
		tSalary = Math.round(tSalary * 100);
		tSalary /= 100; 
		setTotalSalary(tSalary);
		
		System.out.printf("%nTotal amount earned in sales: %.2f%n", totalSalesAmount);
		System.out.println("Commission rate: " + Math.round(commissionRate * 100) + "%");
		System.out.printf("Total commission: %.2f%n", pay);
		System.out.printf("Performance bonus: %.2f%n", getPerformanceBonusAmount());
		System.out.printf("Gross salary: %.2f%n", getTotalSalary());
	}

	@Override
	public void displaySalaryDetails() {
		System.out.printf("4. Commission rate: %.2f%n", commissionRate);
		System.out.printf("5. Total sales earning: %.2f%n", totalSalesAmount);
	}

	@Override
	public boolean promptAndUpdateSalary(int option) {
		String input;
		
		if(option == 4) {
			System.out.println("\nEnter new commission rate.");
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("No input defaults to current commission rate.");
			System.out.println("0. Previous menu.");
			System.out.println("00. Exit system.");
			System.out.println("-----------------------------------------------------------------------------------------------");
			while(true) {
				System.out.printf("Current commission rate: %.2f%n",getCommissionRate());
				System.out.print("Rate in decimal: ");
				input = scan.next();
				
				if(input.isBlank()) {
					return false;
				}
				else if(input.matches("0")) {
					return true;
				}
				else if(input.matches("00+")) {
					System.out.println("Exiting system.");
					System.exit(0);
				}
				else if(input.matches("^\\d{1}\\.*\\d{0,2}$")) {
					setCommissionRate(Float.parseFloat(input));
					return false;
				}
				else {
					System.out.println("Invalid input, try again");
				}
			}
		}
		else {
			System.out.println("\nEnter new total sales earnings amount");
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("No input defaults to current sales earnings amount.");
			System.out.println("0. Previous menu.");
			System.out.println("00. Exit system.");
			System.out.println("-----------------------------------------------------------------------------------------------");
			while(true) {
				System.out.printf("Current sales earnings amount: %.2f%n",getTotalSalesAmount());
				System.out.print("Amount: ");
				input = scan.next();
				
				if(input.isBlank()) {
					return false;
				}
				else if(input.matches("0")) {
					return true;
				}
				else if(input.matches("00+")) {
					System.out.println("Exiting system.");
					System.exit(0);
				}
				else if(input.matches("^\\d+\\.{0,1}\\d{0,2}$")) {
					this.setTotalSalesAmount(Float.parseFloat(input));
					return false;
				}
				else {
					System.out.println("Invalid input, try again");
				}
			}
		}
	}
}
