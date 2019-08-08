package com.revature.dao;

import com.revature.beans.CreatedUserINF;
import com.revature.beans.Credentials;
import com.revature.beans.UsersINF;

public interface UsersDao {

	public UsersINF authenticateUser(Credentials credentials);
	public boolean createUser(CreatedUserINF input);
	public boolean banUser(String username);
	
}
