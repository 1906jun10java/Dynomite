package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public Users authenticateUser(Credentials credentials) {
		return this.usersDao.authenticateUser(credentials);
	}
	@Transactional
	public boolean createUser(Users user, Credentials credential){
		return this.usersDao.createUser(user, credential);
	}
	

}
