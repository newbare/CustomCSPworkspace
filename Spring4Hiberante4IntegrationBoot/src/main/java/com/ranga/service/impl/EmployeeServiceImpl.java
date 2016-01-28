package com.ranga.service.impl;
import com.ranga.dao.EmployeeDAO;
import com.ranga.entity.Employee;
import com.ranga.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * author Ranga Reddy
 * version 1.0
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	public EmployeeServiceImpl() {
		System.out.println("EmployeeServiceImpl()");
	}
	
    @Autowired
    private EmployeeDAO employeeDAO;

    public long createEmployee(Employee employee) {
        return employeeDAO.createEmployee(employee);
    }
    
    public Employee updateEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }
    
    public void deleteEmployee(long id) {
        employeeDAO.deleteEmployee(id);
    }
    
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }
    
    public Employee getEmployee(long id) {
        return employeeDAO.getEmployee(id);
    }    
    
    public List<Employee> getAllEmployees(String employeeName) {
    	return employeeDAO.getAllEmployees(employeeName);
    }
}
