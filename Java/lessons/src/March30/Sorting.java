package march30;

import java.util.Arrays;

public class Sorting {
	public static void main(String[] args) {
		int inArr[] = {0,1,2,3,7,8,10,11};
		int outArr[] = {0,1,2,8,3,10,11};
		
		int[] res = Sort.sortByBits(inArr);
		System.out.println(Arrays.toString(res));
	}
}

class Sort {
	public static int countBits(int n) {
		int sum = 0;
		while(n != 0) {
			if(n % 2 == 1) {
				sum++;
			}
			n /= 2;
		}
		return sum;
	}
	
	public static int[] sortByBits(int arr[]) {
		int temp;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length-1; j++) {
				if(countBits(arr[j]) > countBits(arr[j+1])) {
					temp = arr[i];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}
}