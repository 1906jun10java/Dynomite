package com.revature;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.revature.beans.Posts;
import com.revature.util.ConnectionUtil;

public class Driver {
	
	public static void main(String[] args) {
		SessionFactory sf = ConnectionUtil.getSessionFactory();
		
		
		  Session s = sf.openSession(); 
		  Transaction tx = s.beginTransaction();
		  
		 /*Posts p = new Posts("I like Mexican food", 1, 1, 1); 
		  s.save(p); 
		  tx.commit();
		  s.close();
		 */
		
		
	}
	
	

}
