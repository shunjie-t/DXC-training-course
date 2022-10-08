package com.dxc.springAnno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
@Component("Java")
public class JavaTrainer implements Trainer {
	private StandardPracticeTime spt;
	
	@Autowired
	public JavaTrainer(StandardPracticeTime sspt) {
		this.spt = sspt;
	}

	@Override
	public String getDailySession() {
		return "Java daily";
	}

	@Override
	public String getPracticeTime() {
		return spt.sendStandardPracticeTime();
	}
}
