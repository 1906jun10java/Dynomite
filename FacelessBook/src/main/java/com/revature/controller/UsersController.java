package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Credentials;
import com.revature.beans.Users;
import com.revature.service.UserService;


@RestController
@RequestMapping(value="/users")
public class UsersController {
	
	private UserService userService;
	
	@Autowired // setter injection
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/{username}/{pass}", method=RequestMethod.POST)
	public ResponseEntity<Users> getUserByUsername(@PathVariable String username, @PathVariable String pass) {
		Credentials creds = new Credentials(username, pass);
		Users f = userService.authenticateUser(creds);
		if (f == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(f, HttpStatus.OK);
		}
	}

} 
