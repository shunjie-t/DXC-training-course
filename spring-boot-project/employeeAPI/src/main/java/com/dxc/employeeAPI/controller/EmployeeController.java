package com.dxc.employeeAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.employeeAPI.entity.Employee;
import com.dxc.employeeAPI.services.EmployeeServices;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeServices es;
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee e) {
		return es.addEmployee(e);
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return es.getAllEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployee(int id) {
		return es.getEmployee(id);
	}
}
