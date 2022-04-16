package com.dxc.springIOC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppIOC {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
		
		Trainer jt = (Trainer) context.getBean("java");
		System.out.println(jt.getDailyTrainingSession());
		
		Trainer wt = (Trainer) context.getBean("web");
		System.out.println(wt.getDailyTrainingSession());
	}
}
