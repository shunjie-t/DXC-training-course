package miniProject;

import java.util.Scanner;

public class Commission extends SalaryForMonth {
	private float commissionRate = 0.15f;
	private float totalSalesAmount;
	
	Commission(float pAmount) {
		super(pAmount);
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
	
	public void promptForInput() {
		Scanner scan = new Scanner(System.in);
		String input = "";
		boolean invalid = true;
		
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
		float pay = totalSalesAmount * commissionRate;
		float tSalary = pay + getPerformanceBonusAmount();
		
		
		tSalary = Math.round(tSalary * 100);
		tSalary /= 100; 
		setTotalSalary(tSalary);
		
		System.out.println("\nTotal amount earned in sales: " + totalSalesAmount);
		System.out.println("Commission rate: " + Math.round(commissionRate * 100) + "%");
		System.out.println("Total commission : " + pay);
		System.out.println("Performance bonus: " + getPerformanceBonusAmount());
		System.out.println("Gross salary: " + getTotalSalary());
	}
}
