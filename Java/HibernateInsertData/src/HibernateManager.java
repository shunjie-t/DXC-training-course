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
	
	public void insert(Student s) {
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		System.out.println("Insertion success...");
	}
}
