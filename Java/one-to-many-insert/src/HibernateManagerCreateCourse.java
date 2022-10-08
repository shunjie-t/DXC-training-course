import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateManagerCreateCourse {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(StudentDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		System.out.println("Connection established to database");
		
		session.beginTransaction();
		Student s = (Student) session.get(Student.class, 8);
		
		Course c1 = new Course("Java");
		Course c2 = new Course("Python");
		Course c3 = new Course("JavaScript");
		
		s.add(c1);
		s.add(c2);
		s.add(c3);
		
		session.save(c1);
		session.save(c2);
		session.save(c3);
		
		session.getTransaction().commit();
	}
}
