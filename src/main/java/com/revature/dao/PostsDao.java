package com.revature.dao;

import java.util.List;

import com.revature.beans.PostsINF;

public interface PostsDao {
	
	public String insertPost(PostsINF input);
	public String deletePost(int id);
	public String updatePost(PostsINF input);
	public List<PostsINF> getPostWithNoCommentID();
	public List<PostsINF> getPostByCommentID(int id);
	public List<PostsINF> getPostByChannelID(String channelName);

}
