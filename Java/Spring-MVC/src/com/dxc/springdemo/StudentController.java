package com.dxc.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Student")
public class StudentController {
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		StudentModel student = new StudentModel();
		model.addAttribute("student",student);
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") StudentModel student) {
		return "student-confirmation";
	}
}
