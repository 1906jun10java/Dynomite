package com.revature.dao;

import com.revature.beans.Channel;
import com.revature.beans.Posts;

public interface PostsDao {
	
	public boolean insertPost(Posts p, Channel channel);
	public boolean deletePost(Posts p);
	public boolean updatePost(Posts p);
	
	

}
