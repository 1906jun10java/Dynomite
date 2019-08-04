package com.revature.daoimpl;

import java.sql.ResultSet;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.beans.Credentials;
import com.revature.beans.Users;
import com.revature.dao.UsersDao;

@Repository(value="UsersDAO")
@Transactional
public class UsersDaoImpl implements UsersDao{

	private SessionFactory sessionFactory;
	
	@Override
	public Users authenticateUser(Credentials credentials) {
		String sql = "SELECT * FROM USERS WHERE USERNAME IN (SELECT USERNAME FROM CREDENTIALS WHERE USERNAME="+credentials.getUsername()+" AND PASS="+ credentials.getPass();
		Query<Users> query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		List<Users> lu = query.getResultList();
		Users u = lu.get(0);
		return u;
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
