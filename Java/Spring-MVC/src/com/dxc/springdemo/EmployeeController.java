package com.dxc.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Employee")
public class EmployeeController {
	@RequestMapping("/showForm")
	public String showForm() {
		return "employee-form";
	}
}
