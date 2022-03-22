package March14;

public class AnonymousObjects {
	static int arr[] = new int[]{1,2,3,4,5};
	
	public static void main(String[] args) {
		new AnonClass().sumElements(arr);
	}
}

class AnonClass {
	public void sumElements(int[] input) {
		int res = 0;
		for(int i = 0; i < input.length; i++) {
			res += input[i];
		}
		System.out.println(res);
	}
}
