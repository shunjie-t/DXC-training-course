package com.dxc.springAnno;

import org.springframework.stereotype.Component;

@Component
//@Component("Web")
public class WebTrainer implements Trainer {
	@Override
	public String getDailySession() {
		return "web daily";
	}
}
