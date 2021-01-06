package com.example.lkm.service;

import java.util.Collection;

import com.example.lkm.business.bean.EmployeeBean;
import com.example.lkm.exceptions.IdNotFoundException;

public interface EmployeeService {

	int addEmployee(EmployeeBean employee) throws Exception;

	Collection<EmployeeBean> getEmployeeDetails() throws Exception;

	EmployeeBean getEmployeeDetailByEmployeeId(int employeeId) throws IdNotFoundException;

	EmployeeBean deleteEmployee(int employeeId) throws Exception;

	EmployeeBean updateEmployee(EmployeeBean employee) throws Exception;


}