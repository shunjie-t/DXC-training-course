import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateManager {
	Session session;
	public void connect() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.buildServiceRegistry());
		
		session = sessionFactory.openSession();
		System.out.println("Connected to Employee hibernate....");
	}
	
	public void insert(Employee e) {
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();
		System.out.println("Employee inserted.");
	}
	
	public void select(int id) {
		session.beginTransaction();
		Employee e = (Employee) session.get(Employee.class, id);
		session.getTransaction().commit();
		System.out.println(e);
	}
	
	public void selectAllData() {
		session.beginTransaction();
		List<Employee> empList = session.createQuery("from Employee").list();
		display(empList);
		session.getTransaction().commit();
	}

	public void display(List<Employee> empList) {
		for (Employee e : empList) {
			System.out.println(e);
		}
	}
	
	public void selectByName() {
		session.beginTransaction();
		List<Employee> empList = session.createQuery("from Employee emp where emp.efirstname = 'Sally'").list();
		display(empList);
		session.getTransaction().commit();
	}
	
	public void update(int id, String firstname, String lastname, String email) {
		session.beginTransaction();
		Employee e = (Employee) session.get(Employee.class, id);
		e.setEfirstname(firstname);
		e.setEsecondname(lastname);
		e.setEemail(email);
		session.update(e);
		session.getTransaction().commit();
		System.out.println("Employee updated.");
	}
	
	public void delete(int id) {
		session.beginTransaction();
		Employee e = (Employee) session.get(Employee.class, id);
		session.delete(e);
		session.getTransaction().commit();
		System.out.println("Employee deleted.");
	}
}
