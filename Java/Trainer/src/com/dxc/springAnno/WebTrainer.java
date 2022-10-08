package com.dxc.springAnno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@Component("Web")
public class WebTrainer implements Trainer {
	private StandardPracticeTime spt;
	
	@Autowired
	public WebTrainer(StandardPracticeTime sspt) {
		this.spt = sspt;
	}
	
	@Override
	public String getDailySession() {
		return "Web daily";
	}

	@Override
	public String getPracticeTime() {
		return spt.sendStandardPracticeTime();
	}
}
