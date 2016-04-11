package com.vishwa.api.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vishwa.entity.Employee;
import com.vishwa.entity.Response;
import com.vishwa.service.EmployeeService;
import com.vishwa.utility.BasicAuthChecking;
import com.vishwa.utility.CommonProperties;

@RestController
public class RESTController {
	
	@Autowired
	private EmployeeService employeeService;
	
	Logger logger=Logger.getLogger(RESTController.class);
	
	//http://localhost:9999/Spring4Hiberante4IntegrationBoot/employees
	@RequestMapping(value = "/employees", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	// Basic vishwa:vishwa
	public Object getAllEmployees(@RequestHeader("authorization") String authString)
	{
		//logger.info("[getAllEmployees]::::::::: called"+(1/0));
		logger.info("[Authorization message============"+CommonProperties.AUTHORIZATION_HEADER);
		if(authString!=null){
			try {
				if(!BasicAuthChecking.isUserAuthenticated(authString)){
	            return new ResponseEntity<>("{\"error\":\"User not authenticated\"}",
	            		HttpStatus.UNAUTHORIZED);
					}
				}
			catch(Exception e)
			{
				return new ResponseEntity<>("{\"error\":\"Authorization header can not be blank\"}",
						 HttpStatus.BAD_REQUEST);
			}
		}
		List<Employee> employeesList=employeeService.getAllEmployees();
		if(employeesList!=null && employeesList.size()>0)
		return new ResponseEntity<Object>(employeesList,HttpStatus.OK);
		else
		return new ResponseEntity<Object>("No employees found",HttpStatus.NO_CONTENT);
	}
	//http://localhost:9999/Spring4Hiberante4IntegrationBoot/employees/{empId}
	@RequestMapping(value="/employees/{empId}", method=RequestMethod.GET)
	public Object getEmployeeById(@PathVariable("empId") String empId)
	{
		logger.info("[getEmployeeById]:::::::: called and EMPID::"+empId);
		Employee employee=employeeService.getEmployee(Long.parseLong(empId));
		if(employee!=null)
		return new ResponseEntity<Object>(employee,HttpStatus.OK);
		else
		return new ResponseEntity<Object>(new Response("Employee with empId "+empId+" not found"),HttpStatus.NOT_FOUND);
					
	}
	//http://localhost:9999/Spring4Hiberante4IntegrationBoot/employees/create
	@RequestMapping(value="/employees/create",method=RequestMethod.POST)
	public Object addEmployee(@RequestBody Employee employee)
	{
	logger.info("[addEmployee]::::::::::: called");
	long empId=employeeService.createEmployee(employee);
	if(empId>0)
	return new ResponseEntity<Object>(new Response("Employee with empId "+empId+" created"),HttpStatus.CREATED);
	else
	return new ResponseEntity<Object>(new Response("Employee with empId "+empId+" not created"),HttpStatus.BAD_REQUEST);	
	}
	//http://localhost:9999/Spring4Hiberante4IntegrationBoot/employees/update
	@RequestMapping(value="/employees/update",method=RequestMethod.PUT)
	public Object updateEmployee(@RequestHeader("authorization") String authString,
			@RequestBody Employee employee){
	
		logger.info("[updateEmployee]: called");
		 if(!BasicAuthChecking.isUserAuthenticated(authString)){
	            return "{\"error\":\"User not authenticated\"}";
	        }
		Employee employeeUpdated=employeeService.updateEmployee(employee);
		if(employeeUpdated!=null)
		return new ResponseEntity<>(employeeUpdated,HttpStatus.OK);
		else
		return new ResponseEntity<>(new Response("Employee not updated"),HttpStatus.BAD_REQUEST);	
	}
	//http://localhost:9999/Spring4Hiberante4IntegrationBoot/employees/delete
	@RequestMapping(value="/employees/{empId}", method=RequestMethod.DELETE)
	public Object deleteEmployee(@PathVariable("empId") String empId)
	{
		logger.info("[deleteEmployee]::::::::::: called");
		employeeService.deleteEmployee(Long.parseLong(empId));
		return new ResponseEntity<>(new Response("employee with empId "+empId+" is deleted"),
				HttpStatus.OK);
	}
	////http://localhost:9999/Spring4Hiberante4IntegrationBoot/employees/searchByNameOrEmail/{searchCriteria}
	@RequestMapping(value="/employees/searchByNameOrEmail/{searchCriteria}", method=RequestMethod.GET)
	public Object getEmployeeByName(@PathVariable("searchCriteria") String searchCriteria)
	{
		logger.info("[getEmployeeByName]:::::::: called");
		ResponseEntity<Object> responseEntity=null;
		List<Employee> employee=employeeService.getAllEmployees(searchCriteria.trim());
		if(employee!=null && employee.size()>0)
		{
			responseEntity=new ResponseEntity<Object>(employee,HttpStatus.BAD_REQUEST);
		}
		else
		{
			responseEntity=new ResponseEntity<Object>(new Response("No employee found for search criteria"),
			HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
}
