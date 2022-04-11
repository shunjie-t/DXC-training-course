package march28;

public class RaceCondition {

	public static void main(String[] args) {
		Bathroom b = new Bathroom();
		
		Thread t1 = new Thread(b);
		Thread t2 = new Thread(b);
		Thread t3 = new Thread(b);
		
		t1.setName("Man");
		t2.setName("Woman");
		t3.setName("Other");
		
		t1.start();
		t2.start();
		t3.start();
	}

}

class Bathroom implements Runnable {
	@Override
	public synchronized void run() {
		try { 
			System.out.println(Thread.currentThread().getName()+" has entered the bathroom");
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().getName()+" is using the bathroom");
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().getName()+" has exited the bathroom");
			Thread.sleep(3000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}