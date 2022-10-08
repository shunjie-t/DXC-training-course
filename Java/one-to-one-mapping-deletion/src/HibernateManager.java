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
		StudentDetail sd = (StudentDetail) session.get(StudentDetail.class, 5);
		session.delete(sd);
		session.getTransaction().commit();
		System.out.println("Student and StudentDetails are deleted from the table");
	}
}
