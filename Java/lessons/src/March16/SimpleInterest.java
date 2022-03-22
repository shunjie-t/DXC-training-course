package March16;

public class SimpleInterest {
	private static float annualInterestRate;
	private int principle;
	private int durationInYears;
	private double simpleInterest;
	
	// static block
	static {
		annualInterestRate = 2.5f;
		System.out.println("From SimpleInterest static\n");
	}
	
	// non static block
	{
		System.out.println("\nNon static block SimpleInterest\n");
	}
	
	public static void main(String[] args) {
		SimpleInterest si = new SimpleInterest();
		Farmer farmer1 = new Farmer(40000, 5);
		si.input(farmer1.getPrinciple(), farmer1.getDurationInYears());
		si.compute();
		si.disp("farmer1");
		
		Farmer farmer2 = new Farmer(85000, 7);
		si.input(farmer2.getPrinciple(), farmer2.getDurationInYears());
		si.compute();
		si.disp("farmer2");
		
		Farmer farmer3 = new Farmer(1500, 1);
		si.input(farmer3.getPrinciple(), farmer3.getDurationInYears());
		si.compute();
		si.disp("farmer3");
	}
	
	public void input(int amount, int years) {
		principle = amount;
		durationInYears = years;
	}
	
	public void compute() {		
		simpleInterest = principle * (annualInterestRate / 100) * durationInYears;
	}
	
	public void disp(String user) {
		System.out.println(user + ", your interest payable is " + simpleInterest);
	}
}

class Farmer {
	private int principle;
	private int durationInYears;
	
	static {
		System.out.println("From Farmer static\n");
	}
	
	{
		System.out.println("\nNon static block Farmer\n");
	}
	
	public Farmer() {}
	
	public Farmer(int amount, int years) {
		this.principle = amount;
		this.durationInYears = years;
	}
	
	public void setPrinciple(int amount) {
		this.principle = amount;
	}
	
	public int getPrinciple() {
		return this.principle;
	}
	
	public void setDurationInYears(int years) {
		this.durationInYears = years;
	}
	
	public int getDurationInYears() {
		return this.durationInYears;
	}
}
