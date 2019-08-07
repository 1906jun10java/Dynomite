package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Posts;
import com.revature.service.PostService;

@RestController
@CrossOrigin
@RequestMapping(value="/posts")
public class PostsController {

	private PostService postService;
	
	@Autowired // setter injection
	public PostsController(PostService postService) {
		this.postService = postService;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value="")
	public List<Posts> getAllPosts() {
		return postService.getPostWithNoCommentID();
	}
	
	
}
