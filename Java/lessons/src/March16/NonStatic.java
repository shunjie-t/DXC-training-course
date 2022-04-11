package march16;

public class NonStatic {

	public static void main(String[] args) {
		Demo.dip2();
	}

}

class Demo {
	public int a;
	public static int b;
	
	{
		a = 10;
	}
	
	static {
		b = 20;
	}
	
	public void dip1() {
		System.out.println(a);
		System.out.println(b);
	}
	
	public static void dip2() {
//		System.out.println(a);
		System.out.println(b);
	}
}
