package com.dxc.employeeAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dxc.employeeAPI.entity.Employee;
import com.dxc.employeeAPI.repository.EmployeeRepository;

@Component
public class EmployeeServices {
	@Autowired
	EmployeeRepository er;
	
	public List<Employee> getAllEmployees() {
		return (List<Employee>) er.findAll();
	}
	
	public Employee getEmployee(int id) {
		Employee e = er.findById(id);
		return e;
	}
	
	public Employee addEmployee(Employee e) {
		return er.save(e);
	}
}
