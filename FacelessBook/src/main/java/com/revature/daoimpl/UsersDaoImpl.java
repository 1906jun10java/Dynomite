package com.revature.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.revature.beans.Credentials;
import com.revature.beans.Users;
import com.revature.dao.UsersDao;

@Repository(value="UsersDAO")
@Transactional
public class UsersDaoImpl implements UsersDao{

	private SessionFactory sessionFactory;
	
	@Override
	public boolean authenticateUser(Credentials credentials) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createUser(Users user) {
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
