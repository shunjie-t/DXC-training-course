import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateManagerGetCourses {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(StudentDetail.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		System.out.println("Connection established to database");
		
		session.beginTransaction();
		Instructor inst = (Instructor) session.get(Instructor.class, 5);
		
		System.out.println("List of courses taught by "+inst.getFirstname()+" "+inst.getLastname());
		for(Course c : inst.getCourses()) {
			System.out.println(c.getTitle());
		}
		session.getTransaction().commit();
	}
}
