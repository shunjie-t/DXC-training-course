package com.dxc.employeeAPI.repository;

import org.springframework.data.repository.CrudRepository;

import com.dxc.employeeAPI.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	public Employee findById(int id);
}
