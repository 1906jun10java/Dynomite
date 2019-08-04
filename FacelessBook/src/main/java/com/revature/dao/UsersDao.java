package com.revature.dao;

import com.revature.beans.Credentials;
import com.revature.beans.Users;

public interface UsersDao {

	public Users authenticateUser(Credentials credentials);
	public boolean createUser(Users user, Credentials credential);
	
}
