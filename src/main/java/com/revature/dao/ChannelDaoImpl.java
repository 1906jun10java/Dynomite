package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

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
	public String createChannel(Channel channel) {
		Session s = sessionFactory.getCurrentSession();
		//System.out.println(channel.getChannelID() + channel.getChannelName());
		//System.out.println(s.get(Channel.class, channel.getChannelID()));
		try {
			if(s.get(Channel.class, channel.getChannelID()) == null) {
				s.save(channel);
				return "Channel " + channel.getChannelName() + " successfully created";
			}else {
				return "Channel already exists";
			}
		}catch(Exception e) {
			e.printStackTrace();
			return "An error occured";
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllChannels(){
		List<Channel> dataList = new ArrayList<>();
		List<String> channelList = new ArrayList<>();
		Session s = sessionFactory.getCurrentSession();
		//Gets all channels
		dataList = s.createQuery("from Channel").getResultList();
		for(int i =0; i < dataList.size(); i++) {
			channelList.add(dataList.get(i).getChannelName());
		}
		return channelList;
	}

}
