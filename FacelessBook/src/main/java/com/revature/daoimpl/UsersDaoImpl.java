package com.revature.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.beans.Credentials;
import com.revature.beans.Users;
import com.revature.dao.UsersDao;
import com.revature.util.ConnectionUtil;

@Repository(value="UsersDAO")
public class UsersDaoImpl implements UsersDao{

	private SessionFactory sf = ConnectionUtil.getSessionFactory();
	
	@Override
	public Users authenticateUser(Credentials credentials) {
		Users u = null;
		//String sql = "SELECT * FROM USERS WHERE USERNAME IN (SELECT USERNAME FROM CREDENTIALS WHERE USERNAME="+credentials.getUsername()+" AND PASS="+ credentials.getPass();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		Credentials creds = s.load(Credentials.class, credentials.getUsername());
		System.out.println(creds);
		if(creds.getPass().equals(credentials.getPass())) {
			String hql = "FROM Users WHERE USERNAME='" + credentials.getUsername() + "'";
			Query query = s.createQuery(hql);
			List results = query.list();
			u = (Users) results.get(0);
		}
		else {
			System.out.println("COULD NOT FIND MATCHING USER");
		}
		s.close();
		return u;
	}

	@Override
	public boolean createUser(Users user, Credentials credential) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
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
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
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
