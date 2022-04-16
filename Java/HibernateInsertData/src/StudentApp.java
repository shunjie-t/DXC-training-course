public class StudentApp {
	public static void main(String[] args) {
		Student s = new Student(3, "Sophia");
		
		HibernateManager hm = new HibernateManager();
		hm.connect();
		hm.insert(s);
	}
}
