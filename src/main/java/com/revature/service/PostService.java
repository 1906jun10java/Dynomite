package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.PostsINF;
import com.revature.dao.PostsDao;

@Service
public class PostService {

	private PostsDao postsDao;

	@Autowired
	public PostService(PostsDao postsDao) {
		this.postsDao = postsDao;
	}
	
	public String insertPost(PostsINF info) {
		return this.postsDao.insertPost(info);
	}
	
	public String deletePost(int id) {
		return this.postsDao.deletePost(id);
	}
	
	public String updatePost(PostsINF info) {
		return this.postsDao.updatePost(info);
	}
	
	public List<PostsINF> getPostWithNoCommentID(){
		return this.postsDao.getPostWithNoCommentID();
	}
	
	public List<PostsINF> getPostByCommentID(int id){
		return this.postsDao.getPostByCommentID(id);
	}
	
	public List<PostsINF> getPostByChannelID(String channelName){
		return this.postsDao.getPostByChannelID(channelName);
	}
	

}
