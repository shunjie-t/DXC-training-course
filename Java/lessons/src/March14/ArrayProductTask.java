package March14;

import java.util.Arrays;

public class ArrayProductTask {

	public static void main(String[] args) {
		int inArr[] = {4,2,1,7};
		int outArr[] = ArrayProduct(inArr);
//		int outArr[] = TrainerSolution(inArr);
		System.out.println(Arrays.toString(outArr));
	}
	
	public static int[] ArrayProduct(int[] input) {
		int result[] = new int[input.length];
		for(int a = 0; a < input.length; a++) {
			result[a] = 1;
			for(int b = 0; b < input.length; b++) {
				if(b != a) {
					result[a] *= input[b];
				}
			}
		}
		return result;
	}
	
	
	public static int[] TrainerSolution(int[] input) {
		int result[] = new int[input.length];
		int product = 1;
		
		for(int a = 0; a < input.length; a++) {
			product *= input[a];
		}
		
		for(int a = 0; a < result.length; a++) {
			result[a] = product / input[a];
		}
		
		return result;
	}
}
