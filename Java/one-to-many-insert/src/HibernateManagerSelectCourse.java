import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateManagerSelectCourse {

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
		Student s = (Student) session.get(Student.class, 6);
		
		System.out.println("Student details are " + s);
		
		List<Course> courses = s.getCourse();
		System.out.println("Course details: " + courses);
		
		session.getTransaction().commit();
	}

}
