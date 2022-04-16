package com.dxc.SpringMavenConstructorInjector.SpringMavenConstructorInjector;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main( String[] args ) {
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    	Employee e = (Employee) context.getBean("employee");
    	System.out.println(e);
    }
}
