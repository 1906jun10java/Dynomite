package com.revature.DaoTests;

import static org.junit.Assert.assertEquals;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.Users;

public class UserDaoTests {
	
	private SessionFactory sessionFactory;

	@Test
	public void createUser() {
		Users test = new Users(1, "Richard", "DiCosmo", null, 1,
			1, "rjdicosmo@gmail.com");
		//sessionFactory.openSession().
		Users actual = new Users(1, "Richard", "DiCosmo", null, 1,
				1, "rjdicosmo@gmail.com");
		assertEquals(test, actual);
	}
}
