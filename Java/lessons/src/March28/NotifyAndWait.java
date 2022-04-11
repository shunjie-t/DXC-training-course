package march28;

public class NotifyAndWait {

	public static void main(String[] args) {
		Queue q = new Queue();
		Producer p = new Producer(q);
		Consumer c = new Consumer(q);
		
		p.start();
		c.start();
	}

}

class Queue {
	int x;
	boolean value_present_in_x = false;
	
	synchronized void put(int i) {
		try {
			if(!value_present_in_x) {
				x = i;
				System.out.println("I have put "+i+" into x");
				value_present_in_x = true;
				// notify and wait appears together by convention
				notify();
			}
			else {
				wait();
				System.out.println("Producer is waiting...");
			}
		}
		catch(Exception e) {
			System.out.println("some exception occured");
			e.printStackTrace();
		}
	}
	
	synchronized void get() {
		try {
			if(value_present_in_x) {
				System.out.println("I have taken "+x+" from x");
				value_present_in_x = false;
				notify();
			}
			else {
				wait();
				System.out.println("Consumer is waiting...");
			}
		}
		catch(Exception e) {
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
	}
}

class Producer extends Thread {
	Queue a;
	
	Producer(Queue q) {
		a = q;
	}
	
	public void run() {
		try {
			int i = 1;
			while(true) {
				a.put(i);
				i++;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

class Consumer extends Thread {
	Queue b;
	
	Consumer(Queue q) {
		b = q;
	}
	
	public void run() {
		try {
			while(true) {
				b.get();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}