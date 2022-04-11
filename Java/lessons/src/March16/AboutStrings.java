package march16;

public class AboutStrings {

	public static void main(String[] args) {
		// immutable string objects
		String s1 = "test";
		String s2 = new String("test");
		
		// mutable string object
		StringBuffer sb1 = new StringBuffer("test");
		StringBuilder sb2 = new StringBuilder("test");
	}

}
