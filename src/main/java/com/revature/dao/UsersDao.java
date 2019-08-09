package com.revature.dao;

import com.revature.beans.CreatedUserINF;
import com.revature.beans.Credentials;
import com.revature.beans.UsersINF;

public interface UsersDao {

	public UsersINF authenticateUser(Credentials credentials);
	public String createUser(CreatedUserINF input);
	public String banUser(String username);
	public String updateUser(CreatedUserINF input);
	
}
