package com.dxc.springAnno;

import org.springframework.stereotype.Component;

//@Component
@Component("Java")
public class JavaTrainer implements Trainer {
	@Override
	public String getDailySession() {
		return "Java daily";
	}
}
