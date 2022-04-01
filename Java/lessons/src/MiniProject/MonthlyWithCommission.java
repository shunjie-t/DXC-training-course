package miniProject;

import java.util.Scanner;

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
	public void promptForInput() {
		Scanner scan = new Scanner(System.in);
		String input = "";
		boolean invalid = true;
		
		while(invalid) {
			System.out.print("Input unpaid leave taken (default 0): ");
			input = scan.nextLine();
			if(input.matches("\\d+")) {
				setUnpaidLeaveTaken(Integer.parseInt(input));
				invalid = false;
			}
			else if(input.equals("")) {
				setUnpaidLeaveTaken(0);
				invalid = false;
			}
			else {
				System.out.println("Invalid input, please enter again");
			}
		}
		
		invalid = true;
		while(invalid) {
			System.out.print("Input total sales income for this month: ");
			input = scan.nextLine();
			if(input.matches("\\d+")) {
				setTotalSalesAmount(Float.parseFloat(input));
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
		float tSalary = 0;
		float pay = getPayAmount();
		float bonus = getPerformanceBonusAmount();
		float commission = getTotalSalesAmount() * getCommissionRate();
		
		if(unpaidLeaveTaken > 0) {
			tSalary = pay - (pay / getworkDaysForMonth()) * unpaidLeaveTaken;
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

}
