package com.example.lkm.business.bean;

public class EmployeeBean {
	private String employeeName;
	private Integer employeeId;
	private double salary;
	private Integer departmentCode;
	private String lastName;

	public Integer getDepartmentCode() {
		return departmentCode;
	}



	public void setDepartmentCode(Integer departmentCode) {
		this.departmentCode = departmentCode;
	}



	public EmployeeBean() {
		super();
	}

	

	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public Integer getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	
	@Override
	public String toString() {
		return "EmployeeBean [employeeName=" + employeeName + ", employeeId=" + employeeId + ", salary=" + salary
				+ ", departmentCode=" + departmentCode + ", lastName=" + lastName + "]";
	}
	
	
}
