package com.example.lkm.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.lkm.business.bean.EmployeeBean;
import com.example.lkm.exceptions.IdNotFoundException;
import com.example.lkm.service.EmployeeService;


@RestController
// extends @Controller
// object are automatically converted to JSON or XML
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	
	
	@RequestMapping(value="emp/controller/getDetails",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<EmployeeBean>> getEmployeeDetails() throws Exception{
		Collection <EmployeeBean> listEmployee = employeeService.getEmployeeDetails();
		return new ResponseEntity<Collection<EmployeeBean>>(listEmployee, HttpStatus.OK);
	}
	
	@RequestMapping(value="emp/controller/getDetailsById/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeBean> getEmployeeDetailByEmployeeId(@PathVariable("id") int myId) throws  Exception{
		EmployeeBean employee ;

		try{
			employee = employeeService.getEmployeeDetailByEmployeeId(myId);
		}catch(Exception e){
			throw new IdNotFoundException();
			//	return new ResponseEntity<EmployeeBean>(HttpStatus.NOT_FOUND);
		}
		
			return new ResponseEntity<EmployeeBean>(employee,HttpStatus.OK);
	}
	
	@RequestMapping(value="/emp/controller/addEmp",
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeBean employee) throws Exception{
		System.out.println("..........."+employee);
		int id= employeeService.addEmployee(employee);
		return new ResponseEntity<String>("Employee added successfully with id:"+id,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/emp/controller/updateEmp",
			method=RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<EmployeeBean> updateEmployee(@RequestBody EmployeeBean employee) throws Exception{
		EmployeeBean employee2;
		try{
			employee2= employeeService.updateEmployee(employee);
		}
		catch(Exception e){
			throw new IdNotFoundException();
		}
		return new ResponseEntity<EmployeeBean>(employee2,HttpStatus.OK);
	}
	@RequestMapping(value="/emp/controller/deleteEmp/{id}",
			method=RequestMethod.DELETE,
			//consumes=MediaType.TEXT_PLAIN_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeBean> deleteEmployee(@PathVariable("id") int myId) throws Exception {
		EmployeeBean employee;
		try{ employee= employeeService.deleteEmployee(myId);}
		catch(Exception e){
			throw new IdNotFoundException();
			//return new ResponseEntity<EmployeeBean>(employee,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<EmployeeBean>(employee,HttpStatus.OK);
	}
	
	@ExceptionHandler(value = IdNotFoundException.class)
	   public ResponseEntity<Object> exception(IdNotFoundException exception) {
	      return new ResponseEntity<>("error    :  "+exception.getMessage(), HttpStatus.NOT_FOUND);
	   }
}
