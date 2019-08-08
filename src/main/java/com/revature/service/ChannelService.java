package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Channel;
import com.revature.dao.ChannelDao;




@Service
public class ChannelService {

	private ChannelDao channelDao;

	@Autowired
	public ChannelService(ChannelDao channelDao) {
		this.channelDao = channelDao;
	}
	
	public String createChannel(Channel channel) {
		return this.channelDao.createChannel(channel);
	}

}
