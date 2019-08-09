package com.revature.dao;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.beans.Channel;
import com.revature.beans.Posts;
import com.revature.beans.PostsINF;
import com.revature.beans.Users;


@Repository(value="PostsDAO")
@Transactional
public class PostsDaoImpl implements PostsDao{
	
	private SessionFactory sessionFactory;
	
	@Autowired //constructor injection
	public PostsDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@SuppressWarnings("unchecked")
	@Override
	public String insertPost(PostsINF input) {
		Session s = sessionFactory.getCurrentSession();
		try{
			//Gets the channel
			List<Channel> channelList = new ArrayList<>();
			channelList = s.createQuery("from Channel WHERE channelName = '" + input.getChannelName() + "'").getResultList();
			Channel c = channelList.get(0);
			//Gets the user who posted
			List<Users> userList = new ArrayList<>();
			userList = s.createQuery("from Users WHERE USERNAME = '" + input.getUsername() + "'").getResultList();
			Users u = userList.get(0);
			Posts p = new Posts(input.getContent(), u, c, input.getLikes(), input.getCommentID());
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
			Date date = new Date();  
			p.setTimeStamp(formatter.format(date).toString());
			s.save(p);
			return "Post made successfuly";
		}catch(Exception e) {
			e.printStackTrace();
			return "Failed to save post";
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public String deletePost(int id) {
		Session s = sessionFactory.getCurrentSession();
		try{
			List<Posts> postList = new ArrayList<>();
			postList = s.createQuery("from Posts WHERE postID= '" + id + "'").getResultList();
			Posts p = postList.get(0);
			s.delete(p);
			return "Post removed successfuly";
		}catch(Exception e) {
			e.printStackTrace();
			return "Failed to remove post";
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public String updatePost(PostsINF input) {
		Session s = sessionFactory.getCurrentSession();
		try{
			//Gets the channel
			List<Channel> channelList = new ArrayList<>();
			channelList = s.createQuery("from Channel WHERE channelName= '" + input.getChannelName() + "'").getResultList();
			Channel c = channelList.get(0);
			//Gets the user who posted
			List<Users> userList = new ArrayList<>();
			userList = s.createQuery("from Users WHERE username= '" + input.getUsername() + "'").getResultList();
			Users u = userList.get(0);
			Posts p = new Posts(input.getContent(), u, c, input.getLikes(), input.getCommentID());
			s.update(p);
			return "Post updated successfuly";
		}catch(Exception e) {
			e.printStackTrace();
			return "Failed to updated post";
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PostsINF> getPostWithNoCommentID() {
		List<Posts> postList = new ArrayList<>();
		List<PostsINF> sendList = new ArrayList<>();
		Session s = sessionFactory.getCurrentSession();
		postList = s.createQuery("from Posts WHERE commentID IS 0 ORDER BY timeStamp").getResultList();
		for(int i = 0; i < postList.size(); i++) {
			//Converts the result set to an info list for sending via JSON
			sendList.add(i, new PostsINF(postList.get(i).getPostID(), postList.get(i).getUsers().getCredentials().getUsername(), postList.get(i).getContent(), postList.get(i).getChannel().getChannelName(), postList.get(i).getCommentID(), postList.get(i).getLikes(), postList.get(i).getTimeStamp()));
		}
		return sendList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PostsINF> getPostByCommentID(int id){
		List<Posts> postList = new ArrayList<>();
		List<PostsINF> sendList = new ArrayList<>();
		Session s = sessionFactory.getCurrentSession();
		postList = s.createQuery("from Posts WHERE commentID='" + id + "' ORDER BY timeStamp").getResultList();
		for(int i = 0; i < postList.size(); i++) {
			//Converts the result set to an info list for sending via JSON
			sendList.add(i, new PostsINF(postList.get(i).getPostID(), postList.get(i).getUsers().getCredentials().getUsername(), postList.get(i).getContent(), postList.get(i).getChannel().getChannelName(), postList.get(i).getCommentID(), postList.get(i).getLikes(), postList.get(i).getTimeStamp()));
		}
		return sendList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PostsINF> getPostByChannelID(String channelName){
		List<Posts> postList = new ArrayList<>();
		List<PostsINF> sendList = new ArrayList<>();
		Session s = sessionFactory.getCurrentSession();
		//Gets the channel
		List<Channel> channelList = new ArrayList<>();
		channelList = s.createQuery("from Channel WHERE channelName= '" + channelName + "'").getResultList();
		Channel c = channelList.get(0);
		postList = s.createQuery("from Posts WHERE CHANNEL_ID = '" + c.getChannelID() + "' AND COMMENT_ID IS 0 ORDER BY timeStamp").getResultList();
		for(int i = 0; i < postList.size(); i++) {
			//Converts the result set to an info list for sending via JSON
			sendList.add(i, new PostsINF(postList.get(i).getPostID(), postList.get(i).getUsers().getCredentials().getUsername(), postList.get(i).getContent(), postList.get(i).getChannel().getChannelName(), postList.get(i).getCommentID(), postList.get(i).getLikes(), postList.get(i).getTimeStamp()));
		}
		return sendList;
	}

	
	

}
