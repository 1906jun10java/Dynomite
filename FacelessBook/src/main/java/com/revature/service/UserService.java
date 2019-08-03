package com.revature.service;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Credentials;
import com.revature.beans.Users;
import com.revature.dao.UsersDao;

@Service
public class UserService {

	private UsersDao usersDao;

	@Autowired
	public UserService(UsersDao usersDao) {
		this.usersDao = usersDao;
	}
	
	public Users authenticateUserService(Credentials credentials) {
	
		return null;
	}
	
	public boolean createUser(Users user){
		return this.usersDao.createUser(user);
	}
	

}
