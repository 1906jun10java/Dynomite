package com.revature.dao;

import java.util.List;

import com.revature.beans.Channel;

public interface ChannelDao {

	public String createChannel(Channel channel);
	public List<String> getAllChannels();
}
