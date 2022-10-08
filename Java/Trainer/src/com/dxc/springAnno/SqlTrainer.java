package com.dxc.springAnno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@Component("Sql")
public class SqlTrainer implements Trainer {
	private StandardPracticeTime spt;
	
	@Autowired
	public SqlTrainer(StandardPracticeTime sspt) {
		this.spt = sspt;
	}
	
	@Override
	public String getDailySession() {
		return "Sql daily";
	}

	@Override
	public String getPracticeTime() {
		return spt.sendStandardPracticeTime();
	}
}
