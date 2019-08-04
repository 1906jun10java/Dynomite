package com.revature.dao;

import java.util.List;

import com.revature.beans.Channel;
import com.revature.beans.Posts;

public interface PostsDao {
	
	public boolean insertPost(Posts p, Channel channel);
	public boolean deletePost(Posts p);
	public boolean updatePost(Posts p);
	public List<Posts> getPostWithNoCommentID();
	public List<Posts> getPostByCommentID(Posts post);
	public List<Posts> getPostByChannelID(Channel channel);

}
