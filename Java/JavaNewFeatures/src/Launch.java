import java.util.function.Function;
import java.util.function.Predicate;

//@FunctionalInterface
//interface Interf {
//	void add(int a, int b);
//}

//class Demo implements Interf {
//	public void add(int a, int b) {
//		System.out.println(a+b);
//	}
//}

public class Launch {
	public static void main(String[] args) {
//		Function<Integer, Integer> square = i -> i * i;
//		System.out.println(square.apply(5));
		
//		Predicate<Integer> evenOrOdd = i -> i % 2 == 0;
//		System.out.println(evenOrOdd.test(22));
		
//		Interf i = (a, b) -> System.out.println(a+b);
//		i.add(2, 3);
		
		Runnable r = () -> {
			for(int i = 0; i < 10; i++) {
				System.out.println("inside run method");
			}
		};
		Thread t = new Thread(r);
		t.start();
		
		for(int i = 0; i < 10; i++) {
			System.out.println("Main method");
		}
	}
}