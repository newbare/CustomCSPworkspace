/**
 * 
 */
package com.vishwa.dao.impl;

import com.vishwa.dao.EmployeeDAO;
import com.vishwa.entity.Employee;
import com.vishwa.util.HibernateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ranga Reddy
 * @version 1.0
 */

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    
	public EmployeeDAOImpl() {
    	System.out.println("EmployeeDAOImpl");
    }
	
	@Autowired
    private HibernateUtil hibernateUtil;

    public long createEmployee(Employee employee) {        
        return (Long) hibernateUtil.create(employee);
    }
    
    public Employee updateEmployee(Employee employee) {        
        return hibernateUtil.update(employee);
    }
    
    public void deleteEmployee(long id) {
        Employee employee = new Employee();
        employee.setId(id);
        hibernateUtil.delete(employee);
    }
    
    public List<Employee> getAllEmployees() {        
        return hibernateUtil.fetchAll(Employee.class);
    }
    
    public Employee getEmployee(long id) {
        return hibernateUtil.fetchById(id, Employee.class);
    }

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees(String employeeName) { 
		//String query = "SELECT e.* FROM Employees e WHERE e.name like '%"+ employeeName +"%'";
		//String query = "SELECT e.* FROM Employees e WHERE e.name like '"+ employeeName +"%'";
String query = "SELECT e.* FROM Employees e WHERE e.name like '%"+ employeeName +"%' OR e.email like '%"+ employeeName +"%'";
		System.out.println("query is:::"+query);
		//List<Object[]> employeeObjects = hibernateUtil.fetchAll(query);
		List<Object[]> employeeObjects = hibernateUtil.fetchAll(query);
		List<Employee> employees = new ArrayList<Employee>();
		/*int i=0;
		//for(Object[] employeeObject: employeeObjects) {
			for(Object[] employeeObject: employeeObjects) {
			//System.out.println(employeeObject[i]);
			Employee employee = new Employee();
			long id = ((BigInteger) employeeObject[0]).longValue();			
			Integer age = (Integer) employeeObject[1];
			String name = (String) employeeObject[2];
			Float salary = (Float) employeeObject[3];
			String email = (String) employeeObject[4];
			employee.setId(id);
			employee.setName(name);
			employee.setEmail(email);
			employee.setAge(age);
			employee.setSalary(salary);
			employees.add(employee);
			i=i+1;
		}*/
		List<Employee> employeeObj=hibernateUtil.fetchAllBy(employeeName);
		for(Employee emp : employeeObj)
		{
			Employee employee = new Employee();
			employee.setId(emp.getId());
			employee.setName(emp.getName());
			employee.setEmail(emp.getEmail());
			employee.setAge(emp.getAge());
			employee.setSalary(emp.getSalary());
			employees.add(employee);
		}
		System.out.println(employees);
		return employees;
	}
}