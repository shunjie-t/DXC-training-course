import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateManager {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(StudentDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		System.out.println("Connection established to database");
		
		session.beginTransaction();
		Student s = new Student("Nick","Tyson","nick.tyson@gmail.com");
		StudentDetail sd = new StudentDetail("Aon",4);
		s.setStudentid(sd);
		session.save(s);
		session.getTransaction().commit();
		System.out.println("inserted student and studentdetails");
	}
}
