package com.example.lkm.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.lkm.business.bean.EmployeeBean;
import com.example.lkm.entity.EmployeeEntity;

@Repository
public class EmployeeDAOWrapper {
	
	static private Logger logger =  LoggerFactory.getLogger("EmployeeDAOWrapper");
	static
	{
		logger.info("********************************************");
		logger.info("DAO Wrapper");
		logger.info("*********************************************");
	}
	
	@Autowired
	private EmployeeDAO dao;
	private EmployeeEntity employeeEntityBean = new EmployeeEntity();
	public List<EmployeeBean>findAll(){
		List<EmployeeBean> list = new ArrayList<EmployeeBean>(); 
		
		Iterable<EmployeeEntity> listEn= dao.findAll();
		if(listEn==null) {
			logger.info("no records found");
		}
		else {
			logger.info("success. Records found");
		}
		listEn.forEach(x->{
			EmployeeBean employee = new EmployeeBean();
			BeanUtils.copyProperties(x, employee);
			list.add(employee);
		});
		return list;
	}
	
	
	public EmployeeBean findOne(Integer id){ 
		    EmployeeEntity x= dao.getOne(id);
		    logger.info("printing Employee Entity......"+x);
		    EmployeeBean employee =null;
		    if(x!=null){
		    	logger.info("----fectched record----");
		    	employee = new EmployeeBean();		
				BeanUtils.copyProperties(x, employee);
		    }
		    else if(x==null){
		    	logger.error("----No record found-----");
		    }
		return employee;
	}
	
	public Integer saveEmployee(EmployeeBean employee){
		employeeEntityBean = new EmployeeEntity();
		BeanUtils.copyProperties(employee, employeeEntityBean);
		EmployeeEntity en=  dao.save(employeeEntityBean);
		return en.getEmployeeId();	
	}
	
	public EmployeeBean updateEmployee(EmployeeBean employee){
		
		BeanUtils.copyProperties(employee, employeeEntityBean);
		EmployeeEntity en=  dao.save(employeeEntityBean);
		
		EmployeeBean employee2 = new EmployeeBean();
		
		BeanUtils.copyProperties(en,employee2);
		return employee2;	
	}
	
	public void delete(int id){
		dao.delete(id);
	}
	
}
