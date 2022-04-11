package march29;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialization {
	public static void main(String[] args) throws Exception {
		Actor a1 = new Actor("Jacob",42,179.0f);
		
		FileOutputStream fos = new FileOutputStream("D://io//input.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(a1);
		oos.flush();
		oos.close();
		
		FileInputStream fis = new FileInputStream("D://io//input.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Actor a2 = (Actor) ois.readObject();
		ois.close();
		
		a2.display();
	}
}

// Serialization makes an object persistent
class Actor implements Serializable {
	String name;
	int age;
	float height;
	
	Actor(String nm, int ag, float ht) {
		this.name = nm;
		this.age = ag;
		this.height = ht;
	}
	
	void display() {
		System.out.println(this.name);
		System.out.println(this.age);
		System.out.println(this.height);
	}
}