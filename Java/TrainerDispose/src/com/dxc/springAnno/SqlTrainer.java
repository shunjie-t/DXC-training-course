package com.dxc.springAnno;

import org.springframework.stereotype.Component;

@Component
//@Component("Sql")
public class SqlTrainer implements Trainer {
	@Override
	public String getDailySession() {
		return "Sql daily";
	}
}
