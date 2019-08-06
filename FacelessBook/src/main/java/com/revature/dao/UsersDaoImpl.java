package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Credentials;
import com.revature.beans.Users;

@Repository(value="UsersDAO")
@Transactional
public class UsersDaoImpl implements UsersDao{

	private SessionFactory sessionFactory;
	
	@Autowired //constructor injection
	public UsersDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Users authenticateUser(Credentials credentials) {
		Users u = null;
		//String sql = "SELECT * FROM USERS WHERE USERNAME IN (SELECT USERNAME FROM CREDENTIALS WHERE USERNAME="+credentials.getUsername()+" AND PASS="+ credentials.getPass();
		Session s = sessionFactory.getCurrentSession();
		Credentials creds = s.get(Credentials.class, credentials.getUsername());
		System.out.println(creds);
		if(creds.getPass().equals(credentials.getPass())) {
			String hql = "FROM Users WHERE USERNAME='" + credentials.getUsername() + "'";
			List<Users> results = s.createQuery(hql).getResultList();
			u = (Users) results.get(0);
		}
		else {
			System.out.println("COULD NOT FIND MATCHING USER");
		}
		return u;
	}

	@Override
	public boolean createUser(Users user, Credentials credential) {
		Session s = sessionFactory.getCurrentSession();
		try {
			s.save(credential);
			user.setCredentials(credential);
			s.save(user);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean banUser(Users user) {
		Session s = sessionFactory.getCurrentSession();
		try {
			Users updatedUser = s.get(Users.class, user.getUserID());
			updatedUser.setAccess(0);
			s.update(updatedUser);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	

}
