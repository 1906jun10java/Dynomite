package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Channel;
import com.revature.service.ChannelService;

@RestController
@CrossOrigin
@RequestMapping(value="/channels")
public class ChannelsController {

private ChannelService channelService;
	
	@Autowired // setter injection
	public ChannelsController(ChannelService channelService) {
		this.channelService = channelService;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value="/create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String createChannel(@RequestBody Channel channel) {
		return channelService.createChannel(channel);
	}
}
