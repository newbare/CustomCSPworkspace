/**
 * 
 */
package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.User;

/**
 * @author Ranga Reddy
 * @version 1.0
 */
public interface UserDAO {
	public long createUser(User User);
    public User updateUser(User User);
    public void deleteUser(long id);
    public List<User> getAllUsers();
    public User getUser(long id);
    //public List<User> findByName(String name);
    public User findByName(String name);
	//public List<User> getAllUsers(String UserName);
    public void deleteAllUsers();
}
