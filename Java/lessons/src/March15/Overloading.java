package march15;

public class Overloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Addition ad = new Addition();
		ad.add(34, 3.9f);
	}

}

class Addition {
	int add(int x, int y) {
		return x + y;
	}
	
	float add(int x, float y) {
		return x + y;
	}
	
	float add(float x, int y) {
		return x + y;
	}
	
	float add(float x, float y) {
		return x + y;
	}
}
