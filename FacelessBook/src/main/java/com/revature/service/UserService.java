package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.CreatedUserINF;
import com.revature.beans.Credentials;
import com.revature.beans.UsersINF;
import com.revature.dao.UsersDao;

@Service
public class UserService {

	private UsersDao usersDao;

	@Autowired
	public UserService(UsersDao usersDao) {
		this.usersDao = usersDao;
	}
	@Transactional
	public UsersINF authenticateUser(Credentials credentials) {
		return this.usersDao.authenticateUser(credentials);
	}
	@Transactional
	public boolean createUser(CreatedUserINF input){
		return this.usersDao.createUser(input);
	}
	@Transactional
	public boolean banUser(String username){
		return this.usersDao.banUser(username);
	}
	

}
