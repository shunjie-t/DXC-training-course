package march14;

import java.util.Arrays;

public class ShiftingZeros {

	public static void main(String[] args) {
		int inArr[] = {1,0,2,0,0,0,3,4,0,5};
		int outArr[] = shiftZeroToRear(inArr);
		System.out.println(Arrays.toString(outArr));
	}
	
	public static int[] shiftZeroToRear(int[] input) {
		int result[] = new int[input.length];
		int ct = 0;
		
		for(int a = 0; a < input.length; a++) {
			if(input[a] != 0) {
				result[ct] = input[a];
				ct++;
			}
		}
		
		for(int a = ct; a < result.length; a++) {
			result[a] = 0;
		}
		
		return result;
	}
}
