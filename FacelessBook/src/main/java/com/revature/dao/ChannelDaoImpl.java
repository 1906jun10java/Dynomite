package com.revature.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.beans.Channel;
import com.revature.dao.ChannelDao;

@Repository(value="ChannelDAO")
@Transactional
public class ChannelDaoImpl implements ChannelDao{
	
private SessionFactory sessionFactory;
	
	@Autowired //constructor injection
	public ChannelDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean createChannel(Channel channel) {
		Session s = sessionFactory.getCurrentSession();
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
