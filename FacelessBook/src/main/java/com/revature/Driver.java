package com.revature;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.revature.beans.Posts;
import com.revature.beans.Users;
import com.revature.util.ConnectionUtil;

public class Driver {
	
	public static void main(String[] args) {
		SessionFactory sf = ConnectionUtil.getSessionFactory();
		
		
		/*
		 * Session s = sf.openSession(); Transaction tx = s.beginTransaction();
		 * 
		 * Users test = new Users(1, "Richard", "DiCosmo", null, 1, 1,
		 * "rjdicosmo@gmail.com"); s.persist(test); tx.commit(); s.close();
		 */
		
	}
	
	

}
