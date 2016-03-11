package com.websystique.spring.dao;

import org.springframework.stereotype.Component;

import com.websystique.spring.model.Employee;

//@Repository("employeeDao")
@Component("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao{

	public void saveInDatabase(Employee employee) {

		/*
		 * Logic to save in DB goes here
		 */
		System.out.println("Employee "+employee.getName()+" is registered for assessment on "+ employee.getAssessmentDate());
		
	}

}
