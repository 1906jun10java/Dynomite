package com.revature.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.Channel;
import com.revature.dao.ChannelDao;
import com.revature.util.ConnectionUtil;

public class ChannelDaoImpl implements ChannelDao{
	
	private SessionFactory sf = ConnectionUtil.getSessionFactory();

	@Override
	public boolean createChannel(Channel channel) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		try {
			if(s.load(Channel.class, channel.getChannelID()) == null) {
				s.save(channel);
				return true;
			}else {
				System.out.println("Channel already exists");
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
