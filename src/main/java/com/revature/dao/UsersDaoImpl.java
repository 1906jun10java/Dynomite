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
	public String createUser(CreatedUserINF input) {
		Session s = sessionFactory.getCurrentSession();
		try {
			if(input.getPass() == "password" || input.getPass() == "Password") {
				return "Password too generic, please try again with a new password.";
			}
			Credentials credential = new Credentials(input.getUsername(), input.getPass());
			Users user = new Users(input.getFirstName(), input.getLastName(), null, input.getModeratorStatus(), input.getAccess(), input.getEmail(), input.getImageURL());
			s.save(credential);
			user.setCredentials(credential);
			s.save(user);
			return "User successfully created.";
		}catch(Exception e) {
			e.printStackTrace();
			return "An error occured, please try again.";
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public String banUser(String username) {
		//System.out.println(username);
		Users u = null;
		Session s = sessionFactory.getCurrentSession();
		Credentials creds = s.get(Credentials.class, username);
		//System.out.println(creds.getUsername());
		if(creds.getUsername().equals(username)) {
			String hql = "FROM Users WHERE USERNAME='" + username + "'";
			List<Users> results = s.createQuery(hql).getResultList();
			u = (Users) results.get(0);
			u.setAccess(0);
			s.update(u);
			return "User banned successfully.";
		}
		else {
			//System.out.println("COULD NOT FIND MATCHING USER");
			return "Could not find a matching user.";
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String updateUser(UsersINF input) {
		Session s = sessionFactory.getCurrentSession();
		try {
			String hql = "FROM Users WHERE USERNAME='" + input.getUsername() + "'";
			List<Users> results = s.createQuery(hql).getResultList();
			Users u = (Users) results.get(0);
			u.setFirstName(input.getFirstName());
			u.setLastName(input.getLastName());
			u.setEmail(input.getEmail());
			s.update(u);
			return "User information updated successfully.";
		}catch(Exception e) {
			e.printStackTrace();
			return "An error occured, please try again.";
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String updateUserPass(Credentials credential) {
		Session s = sessionFactory.getCurrentSession();
		try {
			String hql = "FROM Users WHERE USERNAME='" + credential.getUsername() + "'";
			List<Users> results = s.createQuery(hql).getResultList();
			Users u = (Users) results.get(0);
			u.setCredentials(credential);
			s.update(u);
			return "Password updated successfully.";
		}catch(Exception e) {
			e.printStackTrace();
			return "An error occured, please try again.";
		}
	}

}
