package com.revature.DaoTests;

import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.stereotype.Repository;

import com.revature.beans.Users;

@Repository(value="UsersDAO")
@Transactional
public class UserDaoTests {
	
	private SessionFactory sessionFactory;

	@Test
	public void createUser() {
		Users test = new Users(1, "Richard", "DiCosmo", null, 1,
			1, "rjdicosmo@gmail.com");
		sessionFactory.getCurrentSession().persist(test);
		//Users actual = new Users(1, "Richard", "DiCosmo", null, 1, 1, "rjdicosmo@gmail.com");
		assertTrue(sessionFactory.getCurrentSession().contains(test));
	}
}
