package com.dxc.springAnno;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
//		Trainer jt = (Trainer) context.getBean("javaTrainer");
		Trainer jt = (Trainer) context.getBean("Java");
		System.out.println(jt.getDailySession());
		
		Trainer wt = (Trainer) context.getBean("webTrainer");
//		Trainer wt = (Trainer) context.getBean("Web");
		System.out.println(wt.getDailySession());
		
		Trainer st = (Trainer) context.getBean("sqlTrainer");
//		Trainer st = (Trainer) context.getBean("Sql");
		System.out.println(st.getDailySession());
	}

}
