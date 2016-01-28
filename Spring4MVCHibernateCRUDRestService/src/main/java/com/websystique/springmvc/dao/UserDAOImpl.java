/**
 * 
 */
package com.websystique.springmvc.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.User;
import com.websystique.springmvc.util.HibernateUtil;

/**
 * @author Ranga Reddy
 * @version 1.0
 */

@Repository
public class UserDAOImpl implements UserDAO {
    
	public UserDAOImpl() {
    	System.out.println("UserDAOImpl");
    }
	
	@Autowired
    private HibernateUtil hibernateUtil;

    public long createUser(User employee) {        
        return (Long) hibernateUtil.create(employee);
    }
    
    public User updateUser(User employee) {        
        return hibernateUtil.update(employee);
    }
    
    public void deleteUser(long id) {
    	User employee = new User();
        employee.setId(id);
        hibernateUtil.delete(employee);
    }
    
    public List<User> getAllUsers() {        
        return hibernateUtil.fetchAll(User.class);
    }
    
    public User getUser(long id) {
        return hibernateUtil.fetchById(id, User.class);
    }
   /* public List<User> findByName(String name) {
        return hibernateUtil.fetchByName(name, User.class);
    }*/
    public User findByName(String name) {
        return hibernateUtil.fetchByName(name, User.class);
    }
    public void deleteAllUsers() {        
        List<User> users=hibernateUtil.fetchAll(User.class);
        for(User user:users)
        {
        	hibernateUtil.delete(user);
        }
    }

	/*@SuppressWarnings("unchecked")
	public List<User> getAllEmployees(String employeeName) { 
		//String query = "SELECT e.* FROM Employees e WHERE e.name like '%"+ employeeName +"%'";
		//String query = "SELECT e.* FROM Employees e WHERE e.name like '"+ employeeName +"%'";
String query = "SELECT e.* FROM User e WHERE e.name like '%"+ employeeName +"%' OR e.email like '%"+ employeeName +"%'";
		System.out.println("query is:::"+query);
		List<Object[]> employeeObjects = hibernateUtil.fetchAll(query);
		List<User> employees = new ArrayList<User>();
		int i=0;
		for(Object[] employeeObject: employeeObjects) {
			System.out.println(employeeObject[i]);
			User employee = new User();
			long id = ((BigInteger) employeeObject[0]).longValue();			
			Integer age = (Integer) employeeObject[1];
			String name = (String) employeeObject[2];
			Float salary = (Float) employeeObject[3];
			String email = (String) employeeObject[4];
			employee.setId(id);
			employee.setName(name);
			employee.setAge(age);
			employee.setSalary(salary);
			employees.add(employee);
			i=i+1;
		}
		System.out.println(employees);
		return employees;
	}*/
}