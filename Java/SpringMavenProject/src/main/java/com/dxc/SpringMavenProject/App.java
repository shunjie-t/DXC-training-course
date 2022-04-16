package com.dxc.SpringMavenProject;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main( String[] args ) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        EmployeeData emp = (EmployeeData) context.getBean("employee");
        System.out.println(emp);
    }
}
