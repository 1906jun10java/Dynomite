package com.revature.dao;

import java.util.List;

import com.revature.beans.Credentials;
import com.revature.beans.Users;

public interface UsersDao {

	public List<Users> authenticateUser(Credentials credentials);
	public boolean createUser(Users user);
	
}
