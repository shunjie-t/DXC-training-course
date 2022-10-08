package com.dxc.springAnno;

import org.springframework.stereotype.Component;

@Component
public interface Trainer {
	public String getDailySession();
	public String getPracticeTime();
}
