package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.CreatedUserINF;
import com.revature.beans.Credentials;
import com.revature.beans.Users;
import com.revature.beans.UsersINF;

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
	public UsersINF authenticateUser(Credentials credentials) {
		Users u = null;
		//String sql = "SELECT * FROM USERS WHERE USERNAME IN (SELECT USERNAME FROM CREDENTIALS WHERE USERNAME="+credentials.getUsername()+" AND PASS="+ credentials.getPass();
		Session s = sessionFactory.getCurrentSession();
		Credentials creds = s.get(Credentials.class, credentials.getUsername());
		System.out.println(creds);
		if(creds.getPass().equals(credentials.getPass())) {
			String hql = "FROM Users WHERE USERNAME='" + credentials.getUsername() + "'";
			List<Users> results = s.createQuery(hql).getResultList();
			u = (Users) results.get(0);
			UsersINF ui = new UsersINF(u.getFirstName(), u.getLastName(), u.getCredentials().getUsername(), u.getModeratorStatus(), u.getAccess(), u.getEmail(), u.getImageURL());
			return ui;
		}
		else {
			System.out.println("COULD NOT FIND MATCHING USER");
			UsersINF ui = null;
			return ui;
		}
	}

	@Override
	public boolean createUser(CreatedUserINF input) {
		Session s = sessionFactory.getCurrentSession();
		try {
			Credentials credential = new Credentials(input.getUsername(), input.getPass());
			Users user = new Users(input.getFirstName(), input.getLastName(), null, input.getModStatus(), input.getAccessPermission(), input.getEmail(), input.getImageURL());
			s.save(credential);
			user.setCredentials(credential);
			s.save(user);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean banUser(String username) {
		Users u = null;
		Session s = sessionFactory.getCurrentSession();
		Credentials creds = s.get(Credentials.class, username);
		if(creds.getUsername().equals(username)) {
			String hql = "FROM Users WHERE USERNAME='" + username + "'";
			List<Users> results = s.createQuery(hql).getResultList();
			u = (Users) results.get(0);
			u.setAccess(0);
			s.update(u);
			return true;
		}
		else {
			System.out.println("COULD NOT FIND MATCHING USER");
			return false;
		}
	}
	
	

}
