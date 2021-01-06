package com.example.lkm.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class EmployeeEntity  implements Serializable{	
	 
	private static final long serialVersionUID = 1L;

	@Column(name="employeename")
	private String employeeName;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employeeid")
	private Integer employeeId;
	
	private String lastName;
	
	@Column(name="salary")
	private double salary;
	@Column(name="departmentcode")
	private Integer departmentCode;


	
	
	public Integer getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(Integer departmentCode) {
		this.departmentCode = departmentCode;
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

	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [employeeName=" + employeeName + ", employeeId=" + employeeId + ", lastName=" + lastName
				+ ", salary=" + salary + ", departmentCode=" + departmentCode + "]";
	}

	
	
	
}
