package march11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AboutArrays {
	public static void main(String[] args) {
//		exercise1();
//		exercise2();
//		exercise3();
//		exercise4();
//		exercise5();
//		exercise6();
//		exercise7();
		int n[] = {1,2,1,2,4,4,3};
//		exercise8(n);
		exercise9();
	}
	
	public static void exercise1() {
		int marks[] = {10,20,30,40,50};
		System.out.println(marks);
		System.out.println(Arrays.toString(marks));
	}
	
	public static void exercise2() {
		int marks[][] = {{1,2,3,4},{11,22,33,44},{10,20,30,40}};
		System.out.println(marks);
		System.out.println(Arrays.toString(marks));
		System.out.println(Arrays.deepToString(marks));
	}
	
	public static void exercise3() {
		Scanner scan = new Scanner(System.in);
		String mark[] = new String[5];
		
		System.out.println("Enter 5 marks");
		for(int a = 0; a < mark.length; a++) {
			System.out.println("Enter mark "+ (a + 1) +": ");
			mark[a] = scan.nextLine();
		}
		System.out.println("\nprinting all marks: ");
		for(int a = 0; a < mark.length; a++) {
			System.out.println(mark[a]);
		}
	}
	
	public static void exercise4() {
		Scanner scan = new Scanner(System.in);
		String mark[][] = new String[2][5];
		
		for(int a = 0; a < mark.length; a++) {
			System.out.println("Enter 5 marks for class " + a);
			for(int b = 0; b < mark[a].length; b++) {
				System.out.println("Enter mark "+ (b + 1) +": ");
				mark[a][b] = scan.nextLine();
			}
		}
		for(int a = 0; a < mark.length; a++) {
			System.out.println("\nprinting all class " + a + " marks: ");
			for(int b = 0; b < mark[a].length; b++) {
				System.out.println(mark[a][b]);
			}
		}
	}
	
	public static void exercise5() {
		Scanner scan = new Scanner(System.in);
		String mark[][][] = new String[2][2][5];
		
		for(int a = 0; a < mark.length; a++) {
			for(int b = 0; b < mark[a].length; b++) {
				System.out.println("Enter 5 marks for school " + a + " class " + b + "\n");
				for(int c = 0; c < mark[a][b].length; c++) {
					System.out.print("Mark "+ (c + 1) +": ");
					mark[a][b][c] = scan.nextLine();
				}
			}
		}
		for(int a = 0; a < mark.length; a++) {
			for(int b = 0; b < mark[a].length; b++) {
				System.out.println("\nAll school " + a + " class " + b + " marks: ");
				for(int c = 0; c < mark[a][b].length; c++) {
					System.out.printf("mark %d: %s%n",(c + 1), mark[a][b][c]);
				}
			}
		}
	}
	
	public static void exercise6() {
		String[] classes[] = {new String[4], new String[2], new String[3]};
//		classes[0] = new String[4];
//		classes[1] = 
		Scanner scan = new Scanner(System.in);
		
		for(int a = 0; a < classes.length; a++) {
			System.out.println("Enter marks for class " + a);
			for(int b = 0; b < classes[a].length; b++) {
				System.out.print("Enter mark "+ (b + 1) +": ");
				classes[a][b] = scan.nextLine();
			}
			System.out.println("");
		}
		for(int a = 0; a < classes.length; a++) {
			System.out.println("\nAll class " + a + " marks: ");
			for(int b = 0; b < classes[a].length; b++) {
				System.out.printf("mark %d: %s%n",(b + 1),classes[a][b]);
			}
		}
	}
	
	public static void exercise7() {
		String[][] school[] = { {new String[2],new String[3]}, {new String[5], new String[4]}, {new String[4]} };
		Scanner scan = new Scanner(System.in);
		
		/*for(int a = 0; a < school.length; a++) {
			System.out.println("Enter marks for class " + a);
			for(int b = 0; b < school[a].length; b++) {
				System.out.print("Enter mark "+ (b + 1) +": ");
				school[a][b] = scan.nextLine();
			}
			System.out.println("");
		}
		for(int a = 0; a < school.length; a++) {
			System.out.println("\nAll class " + a + " marks: ");
			for(int b = 0; b < school[a].length; b++) {
				System.out.printf("mark %d: %s%n",(b + 1),school[a][b]);
			}
		}*/
	}
	
	public static void exercise8(int[] input) {
		int result = 0;
		for(int a = 0; a < input.length; a++) {
			for(int b = 0; b < input.length; b++) {
				if(a == b) {
					b++;
				}
			}
		}
	}
	
	public static void exercise9() {
		
		
		// shift left operator
		System.out.println(2<<3);
		
		// shift right operator
		System.out.println(2>>3);
		
		// shift right fill zero operator
		System.out.println(2>>>3);
		
		// & bitwise AND
		System.out.println(2&3);
		
		// | bitwise OR
		System.out.println(2|3);
		
		// XOR operator
		System.out.println(2^3);
				
		// complement operator
		System.out.println(~3);
	}
}
