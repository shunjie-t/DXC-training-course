package com.dxc.springdemo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String showHomePage() {
		return "main-menu";
	}
	
	@RequestMapping("/showTrail")
	public String showTrailPage() {
		return "show-trail";
	}
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "show-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "hello-world";
	}
	
	@RequestMapping("/dispFormTwo")
	public String dispFormTwo() {
		return "showFormTwo";
	}
	
	@RequestMapping("/showFormTwo")
	public String showFormTwo(Model model, HttpServletRequest req) {
		String name = req.getParameter("name");
		String city = req.getParameter("city");
		String country = req.getParameter("country");
		
		name = "( " + name + " )";
		city = "( " + city + " )";
		country = "( " + country + " )";
		
		model.addAttribute("name", name);
		model.addAttribute("city", city);
		model.addAttribute("country", country);
		
		return "processed-form-data";
	}
}
