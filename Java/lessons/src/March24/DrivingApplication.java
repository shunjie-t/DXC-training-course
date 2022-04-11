package march24;

import java.util.Scanner;

public class DrivingApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Applicant {
	int age = 17;
	
	void setAge() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your age");
		age = scan.nextInt();
		scan.close();
	}
	
	int getAge() {
		return age;
	}
}

class DrivingSchool {
	public void apply(Applicant a) {
		
	}
}

class TrafficPolice {
	
}