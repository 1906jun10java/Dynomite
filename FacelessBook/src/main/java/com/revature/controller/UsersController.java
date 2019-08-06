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

import com.revature.beans.Credentials;
import com.revature.beans.Users;
import com.revature.service.UserService;


@RestController
@CrossOrigin
@RequestMapping(value="/users")
public class UsersController {
	
	private UserService userService;
	
	@Autowired // setter injection
	public UsersController(UserService userService) {
		this.userService = userService;
	}
	
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value="/login", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Users getCredentials(@RequestBody Credentials credentials) {
		return userService.authenticateUser(credentials);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value="/signup", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public boolean createUser(@RequestBody Users user, Credentials credentials) {
		return userService.createUser(user, credentials);
	}


} 
