import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateManager {
	Session session;
	public void connect() {
       Configuration configuration = new Configuration().configure("hibernate.cfg.xml"); //connects to cfg
       ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
       SessionFactory sessionFactory = configuration.buildSessionFactory(builder.buildServiceRegistry());       		   
          		 
        session = sessionFactory.openSession();	
        System.out.println("Connected to Student hibernate....");
	}
	
	public void deleteData(int sid) {
		session.beginTransaction();
		Student s = (Student) session.get(Student.class, sid);
		session.delete(s);
		session.getTransaction().commit();
		System.out.println("Student data deleted");
	}
	
	public void updateData(int sid, String sname) {
		session.beginTransaction();
		Student s = (Student) session.get(Student.class, sid);
		s.setSname(sname);
		session.update(s);
		session.getTransaction().commit();
		System.out.println("Student details are updated.");
	}
}
