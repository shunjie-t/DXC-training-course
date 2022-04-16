public class StudentApp {

	public static void main(String[] args) {
		Student s = new Student();
		s.setsid(1);
		s.setsname("Kennedy");
		
		HibernateManager hm = new HibernateManager();
		hm.connect();
		hm.insert(s);
	}

}
