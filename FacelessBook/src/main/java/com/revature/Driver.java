package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.Credentials;
import com.revature.beans.Users;
import com.revature.daoimpl.UsersDaoImpl;
import com.revature.util.ConnectionUtil;

public class Driver {
	
	static private UsersDaoImpl udi = new UsersDaoImpl();
	
	public static void main(String[] args) {
		//SessionFactory sf = ConnectionUtil.getSessionFactory();

		//Session s = sf.openSession(); 
		//Transaction tx = s.beginTransaction();
		//Credentials creds = s.get(Credentials.class, "Goombazio");
		//s.save(new Users("Richard", "DiCosmo", creds, 1, 1, "rjdicosmo@gmail.com"));
		
		Credentials creds = new Credentials("Goombazio", "pass");
		Users loggedIn = udi.authenticateUser(creds);
		System.out.println(loggedIn);
		

		
		//tx.commit(); 
		//s.close();
	}
}
