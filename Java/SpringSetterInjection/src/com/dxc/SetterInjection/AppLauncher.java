package com.dxc.SetterInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppLauncher {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
		
		// scope=prototype creates a separate instance of employee class; 
		Employee e = (Employee) context.getBean("employee");
		System.out.println(e);
		Employee e1 = (Employee) context.getBean("employee");
		System.out.println(e1);
		
		context.close();
	}

}
