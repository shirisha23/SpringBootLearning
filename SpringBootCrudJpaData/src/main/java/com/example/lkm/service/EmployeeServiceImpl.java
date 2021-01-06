package com.example.lkm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lkm.business.bean.EmployeeBean;
import com.example.lkm.dao.EmployeeDAOWrapper;
import com.example.lkm.exceptions.IdNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAOWrapper employeeDAOWrapper;
	
	public int addEmployee(EmployeeBean employee) throws Exception {
		int result=employeeDAOWrapper.saveEmployee(employee);
		return result;
	}
	
	

	public List<EmployeeBean> getEmployeeDetails()throws Exception{
			return employeeDAOWrapper.findAll();
	}
	
	public EmployeeBean getEmployeeDetailByEmployeeId(int employeeId)throws IdNotFoundException{
		return employeeDAOWrapper.findOne(employeeId);
	}
	public EmployeeBean deleteEmployee(int employeeId)throws Exception{
		
		EmployeeBean employee = employeeDAOWrapper.findOne(employeeId);
		if(employee!=null){
			employeeDAOWrapper.delete(employee.getEmployeeId());
		}
		return employee;
	}
	
	public EmployeeBean updateEmployee(EmployeeBean employee)throws Exception{
		EmployeeBean employee2= employeeDAOWrapper.findOne(employee.getEmployeeId());
		if(employee2!=null){
			employeeDAOWrapper.updateEmployee(employee);
		}
		return employee;
	}
	

}
