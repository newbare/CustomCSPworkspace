package com.websystique.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.websystique.spring.dao.EmployeeDao;
import com.websystique.spring.model.Employee;

//@Service("employeeService")
@Component("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private DateService dateService;
	
	@Autowired
	private EmployeeDao employeeDao;
	

	public void registerEmployee(Employee employee) {
		employee.setAssessmentDate(dateService.getNextAssessmentDate());
		employeeDao.saveInDatabase(employee);
	}
	
}
