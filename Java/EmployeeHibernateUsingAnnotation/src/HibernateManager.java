import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateManager {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		System.out.println("Connection to EMPLOYEE database established.");
		
		/*
		Employee emp1 = new Employee("Sally","Hopkins","sally.hopkins@dxc.com");
		Employee emp2 = new Employee("Freddy","Jones","freddy.jones@dxc.com");
		Employee emp3 = new Employee("Alice","Smith","alice.smith@dxc.com");
		Employee emp4 = new Employee("Catherine","Johnson","catherine.johnson@dxc.com");
		
		session.beginTransaction();
		session.save(emp1);
		session.save(emp2);
		session.save(emp3);
		session.save(emp4);
		session.getTransaction().commit();
		System.out.println("Employee inserted.");
		*/
		
		/*
		List<Employee> empList = session.createQuery("from Employee").list();
		
		Iterator itr = empList.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		session.getTransaction().commit();
		System.out.println("\nAll employees selected:");
		*/
		
		/*
		session.beginTransaction();
		Employee emp = (Employee) session.get(Employee.class, 1);
		System.out.println(emp);
		session.getTransaction().commit();
		System.out.println("\nEmployee selected:");
		*/
		
		/*
		session.beginTransaction();
		Employee emp = (Employee) session.get(Employee.class, 2);
		emp.setEfirstname("Peter");
		emp.setElastname("Hoffman");
		emp.setEemail("peter.hoffman@dxc.com");
		session.update(emp);
		session.getTransaction().commit();
		System.out.println("\nEmployee updated:");
		*/
		
		/*
		session.beginTransaction();
		Employee emp = (Employee) session.get(Employee.class, 2);
		session.delete(emp);
		session.getTransaction().commit();
		System.out.println("\nEmployee deleted:");
		*/
		
		/*
		session.beginTransaction();
		List<Employee> empList = session.createQuery("from Employee").list();
		
		Iterator itr = empList.iterator();
		while(itr.hasNext()) {
			Employee emp = (Employee) itr.next();
			session.delete(emp);
		}
		session.getTransaction().commit();
		System.out.println("\nAll employees deleted:");
		*/
	}
}
