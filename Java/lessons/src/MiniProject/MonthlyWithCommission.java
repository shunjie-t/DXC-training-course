package miniProject;

public class MonthlyWithCommission extends Commission {
	private int unpaidLeaveTaken = 0;
	
	MonthlyWithCommission(float pAmount) {
		super(pAmount);
	}
	
	public int getUnpaidLeaveTaken() {
		return this.unpaidLeaveTaken;
	}
	
	public void setUnpaidLeaveTaken(int uLeaveTaken) {
		this.unpaidLeaveTaken = uLeaveTaken;
	}
	
	@Override
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
			if(input.matches("^[0-20]$")) {
				setUnpaidLeaveTaken(Integer.parseInt(input));
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
			else if(input.equals("") || input.matches("0")) {
				setUnpaidLeaveTaken(0);
				invalid = false;
			}
			else {
				System.out.println("Invalid input, please enter again");
			}
		}
		
		invalid = true;
		while(invalid) {
			System.out.printf("Current total sales earnings: %.2f%n",getTotalSalesAmount());
			System.out.printf("Input total sales earnings for this month (%.2f): ",getTotalSalesAmount());
			input = scan.nextLine();
			if(input.matches("^\\d+\\.*[0-9]{0,2}$")) {
				setTotalSalesAmount(Float.parseFloat(input));
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
			System.out.print("Input performance bonus for this month (default 0): ");
			input = scan.nextLine();
			if(input.matches("^\\d+\\.*[0-9]{0,2}$")) {
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
		float tSalary = 0;
		float pay = getPayAmount();
		float bonus = getPerformanceBonusAmount();
		float commission = getTotalSalesAmount() * getCommissionRate();
		
		if(unpaidLeaveTaken > 0) {
			tSalary = pay - (pay / getWorkDaysForMonth()) * unpaidLeaveTaken;
			tSalary += commission + bonus;
		}
		else {
			tSalary = pay + commission + bonus;
		}
		
		tSalary = Math.round(tSalary * 100);
		tSalary /= 100; 
		setTotalSalary(tSalary);
		
		System.out.println("\nUnpaid leaves taken: " + unpaidLeaveTaken);
		System.out.println("Total amount earned in sales: " + getTotalSalesAmount());
		System.out.println("Commission rate: " + Math.round(getCommissionRate() * 100) + "%");
		System.out.println("Basic salary: " + pay);
		System.out.println("Total commission : " + commission);
		System.out.println("Performance bonus: " + bonus);
		System.out.println("Gross salary: " + getTotalSalary());
	}

	@Override
	public void displaySalaryDetails() {
		System.out.printf("4. Unpaid leaves taken: %d%n", unpaidLeaveTaken);
		System.out.printf("5. Commission rate: %.2f%n", getCommissionRate());
		System.out.printf("6. Total sales earning: %.2f%n", getTotalSalesAmount());
	}
	
	@Override
	public boolean promptAndUpdateSalary(int option) {
		String input;
		
		if(option == 4) {
			System.out.println("\nEnter new unpaid leaves taken.");
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("No input defaults to current leaves.");
			System.out.println("0. Previous menu.");
			System.out.println("00. Exit system.");
			System.out.println("-----------------------------------------------------------------------------------------------");
			while(true) {
				System.out.printf("Current unpaid leaves taken: %d%n",getUnpaidLeaveTaken());
				System.out.print("Leaves: ");
				input = scan.next();
				if(input.matches("^[0-20]$")) {
					this.setUnpaidLeaveTaken(Integer.parseInt(input));
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
				if(input.matches("^0\\.[0-9]{0,2}[1-9]$")) {
					setCommissionRate(Float.parseFloat(input));
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
				if(input.matches("^\\d*\\.[0-9]{0,2}$") || input.matches("^[1-9]+$")) {
					this.setTotalSalesAmount(Float.parseFloat(input));
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
	}
}
