package com.dxc.SetterInjection;

public class Employee {
	private int empId;
	private String empName;
	private String empRole;
	private String empDept;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpRole() {
		return empRole;
	}
	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	public void empStart() {
		System.out.println("Process started");
	}
	public void empStop() {
		System.out.println("Process stopped");
	}
}
