package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.PostsINF;
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
	public List<PostsINF> getAllPosts() {
		return postService.getPostWithNoCommentID();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value="/byId", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<PostsINF> getPostsByCommentID(@RequestBody int id) {
		return postService.getPostByCommentID(id);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value="/byChannel", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<PostsINF> getPostsByChannelID(@RequestBody String channelName) {
		return postService.getPostByChannelID(channelName);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value="/insert", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String insertPost(@RequestBody PostsINF info) {
		return postService.insertPost(info);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value="/delete", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String deletePost(@RequestBody int id) {
		return postService.deletePost(id);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value="/update", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String updatePost(@RequestBody PostsINF info) {
		return postService.updatePost(info);
	}
	
	
	
	
	
	
	
	
	
	
	
}
