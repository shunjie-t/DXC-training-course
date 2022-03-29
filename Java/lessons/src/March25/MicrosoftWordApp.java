package March25;

public class MicrosoftWordApp {

	public static void main(String[] args) {
		MicrosoftWord msw1 = new MicrosoftWord();
		MicrosoftWord msw2 = new MicrosoftWord();
		MicrosoftWord msw3 = new MicrosoftWord();
		
		msw1.setName("TYPE");
		msw2.setName("AUTOSAVE");
		msw3.setName("SPELLCHECK");
		
		msw2.setDaemon(true);
		msw3.setDaemon(true);
		
		msw2.setPriority(8);
		msw3.setPriority(9);
		
		msw1.start();
		msw2.start();
		msw3.start();
	}

}

class MicrosoftWord extends Thread {
	public void run() {
		if(getName().equals("TYPE")) {
			type();
		}
		else if(getName().equals("AUTOSAVE")) {
			autoSave();
		}
		else {
			spellCheck();
		}
	}
	
	public void type() {
		for(int i = 0; i < 5; i++) {
			System.out.println("Typing");
			try {
				Thread.sleep(2000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void autoSave() {
		for(;;) {
			System.out.println("Auto saving");
			try {
				Thread.sleep(2000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void spellCheck() {
		for(;;) {
			System.out.println("Spell checking");
			try {
				Thread.sleep(2000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}