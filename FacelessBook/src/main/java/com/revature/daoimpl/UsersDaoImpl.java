package com.revature.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
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
	public List<Users> authenticateUser(Credentials credentials) {
		Session s = sessionFactory.getCurrentSession();
		return s.createQuery("from USERS where USERNAME = " + credentials.getUsername()).getResultList();
		
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
