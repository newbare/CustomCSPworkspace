package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.User;



public interface UserService {
	
	public long createUser(User User);
    public User updateUser(User User);
    public void deleteUser(long id);
    public List<User> getAllUsers();
    public User getUser(long id);	
	//public List<User> getAllUsers(String UserName);
    public User findByName(String name);
	public boolean isUserExist(User user);
	public void deleteAllUsers();
	
}
