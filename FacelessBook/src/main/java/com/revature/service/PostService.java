package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Channel;
import com.revature.beans.Posts;
import com.revature.dao.PostsDao;

@Service
public class PostService {

	private PostsDao postsDao;

	@Autowired
	public PostService(PostsDao postsDao) {
		this.postsDao = postsDao;
	}
	
	public boolean insertPost(Posts p, Channel channel) {
		return this.postsDao.insertPost(p, channel);
	}
	
	public boolean deletePost(Posts p) {
		return this.postsDao.deletePost(p);
	}
	
	public boolean updatePost(Posts p) {
		return this.postsDao.updatePost(p);
	}
	
	public List<Posts> getPostWithNoCommentID(){
		return this.postsDao.getPostWithNoCommentID();
	}
	
	public List<Posts> getPostByCommentID(Posts post){
		return this.postsDao.getPostByCommentID(post);
	}
	
	public List<Posts> getPostByChannelID(Channel channel){
		return this.postsDao.getPostByChannelID(channel);
	}
	

}
