package March28;

public class DeadLock {

	public static void main(String[] args) {	
		Contester c1 = new Contester();
		Contester c2 = new Contester();
		
		c1.setName("Maximus");
		c2.setName("Augustus");

		c1.start();
		c2.start();
	}

}

class Contester extends Thread {
	String resource1 = "Knife";
	String resource2 = "Gun";
	String resource3 = "Bomb";
	String resource4 = "Oil";
	String resource5 = "Ammunition";
	String resource6 = "Ammored Vehicle";
	String resource7 = "Anti tank Weapon";

	@Override
	public void run() {
		if(this.getName().equals("Maximus")) {
			maximusAccquiredResources();
		}
		else {
			augustusAccquiredResources();
		}
	}
	
	public void maximusAccquiredResources() {
		try {
			synchronized(resource1) {
				System.out.println("Maximus has accquired "+resource1);
				Thread.sleep(3000);
				synchronized(resource2) {
					System.out.println("Maximus has accquired "+resource2);
					Thread.sleep(3000);
					synchronized(resource3) {
						System.out.println("Maximus has accquired "+resource3);
						Thread.sleep(3000);
						synchronized(resource4) {
							System.out.println("Maximus has accquired "+resource4);
							Thread.sleep(3000);
							synchronized(resource5) {
								System.out.println("Maximus has accquired "+resource5);
								Thread.sleep(3000);
								synchronized(resource6) {
									System.out.println("Maximus has accquired "+resource6);
									Thread.sleep(3000);
									synchronized(resource7) {
										System.out.println("Maximus has accquired "+resource7);
										Thread.sleep(3000);
									}
								}
							}
						}
					}
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void augustusAccquiredResources() {
		try {
			synchronized(resource7) {
				System.out.println("Maximus has accquired "+resource7);
				Thread.sleep(3000);
				synchronized(resource6) {
					System.out.println("Augustus has accquired "+resource6);
					Thread.sleep(3000);
					synchronized(resource5) {
						System.out.println("Augustus has accquired "+resource5);
						Thread.sleep(3000);
						synchronized(resource4) {
							System.out.println("Augustus has accquired "+resource4);
							Thread.sleep(3000);
							synchronized(resource3) {
								System.out.println("Augustus has accquired "+resource3);
								Thread.sleep(3000);
								synchronized(resource2) {
									System.out.println("Augustus has accquired "+resource2);
									Thread.sleep(3000);
									synchronized(resource1) {
										System.out.println("Augustus has accquired "+resource1);
										Thread.sleep(3000);
									}
								}
							}
						}
					}
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
