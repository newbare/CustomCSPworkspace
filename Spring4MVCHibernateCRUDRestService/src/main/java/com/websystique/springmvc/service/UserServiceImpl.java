package com.websystique.springmvc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.UserDAO;
import com.websystique.springmvc.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	private static final AtomicLong counter = new AtomicLong();
	@Autowired
	private UserDAO userDao;
	
	private static List<User> users;
	
	static{
		users= populateDummyUsers();
	}

	public List<User> getAllUsers() {
		   return userDao.getAllUsers();
	}
	
	public User getUser(long id) {
        return userDao.getUser(id);
    } 
	
	public User findByName(String name) {
		for(User user : users){
			if(user.getName().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}
	
	public long createUser(User user) {
		return userDao.createUser(user);
	}

	public User updateUser(User user) {
		  return userDao.updateUser(user);
	}

	public void deleteUser(long id) {
		 userDao.deleteUser(id);
	}

	public boolean isUserExist(User user) {
		System.out.println("isUserExist() of ServiceImpl called");
		return userDao.findByName(user.getName())!=null;
	}

	private static List<User> populateDummyUsers(){
		List<User> users = new ArrayList<User>();
		users.add(new User(counter.incrementAndGet(),"Sam",30, 70000));
		users.add(new User(counter.incrementAndGet(),"Tom",40, 50000));
		users.add(new User(counter.incrementAndGet(),"Jerome",45, 30000));
		users.add(new User(counter.incrementAndGet(),"Silvia",50, 40000));
		return users;
	}

	public void deleteAllUsers() {
		userDao.deleteAllUsers();
	}

}
