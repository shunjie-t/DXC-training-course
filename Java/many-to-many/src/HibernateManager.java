import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateManager {
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
		
		Course c = new Course("Sql");
		session.save(c);
		System.out.println("Course "+c+" saved");
		
		Instructor i1 = new Instructor("ken","smith","ken@gmail.com");
		Instructor i2 = new Instructor("tom","jones","tom@gmail.com");
		Instructor i3 = new Instructor("jane","Evans","jane@gmail.com");
		
		c.addInstructor(i1);
		c.addInstructor(i2);
		c.addInstructor(i3);
		
		session.save(i1);
		System.out.println("Instructor "+i1.getFirstname()+" "+i1.getLastname()+" saved");
		session.save(i2);
		System.out.println("Instructor "+i2.getFirstname()+" "+i2.getLastname()+" saved");
		session.save(i3);
		System.out.println("Instructor "+i3.getFirstname()+" "+i3.getLastname()+" saved");
		
		session.getTransaction().commit();
	}
}
