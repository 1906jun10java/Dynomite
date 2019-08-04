package com.revature.daoimpl;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.hibernate.Transaction;

import com.revature.beans.Channel;
import com.revature.beans.Posts;
import com.revature.dao.PostsDao;
import com.revature.util.ConnectionUtil;

@Repository(value="PostsDAO")
@Transactional
public class PostsDaoImpl implements PostsDao{
	
	private SessionFactory sf = ConnectionUtil.getSessionFactory();


	@Override
	public boolean insertPost(Posts post, Channel channel) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		try{
			Channel c = s.get(Channel.class, channel.getChannelID());
			post.setChannel(c);
			s.save(post);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean deletePost(Posts post) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		try {
			s.delete(post);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean updatePost(Posts post) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		try {
			Posts p = s.get(Posts.class, post.getPostID());
			p.setContent("Inappripriate content. Blocked by Moderator");
			s.update(p);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public List<Posts> getPostWithNoCommentID() {
		List<Posts> postList = new ArrayList<>();
		try(Session s = sf.openSession()) {
			postList = s.createQuery("from POSTS WHERE COMMENT_ID IS null").getResultList();
		}
		return postList;
	}
	
	@Override
	public List<Posts> getPostByCommentID(Posts post){
		List<Posts> postList = new ArrayList<>();
		try(Session s = sf.openSession()) {
			postList = s.createQuery("from POSTS WHERE COMMENT_ID=" + post.getPostID()).getResultList();
		}
		return postList;
	}
	
	@Override
	public List<Posts> getPostByChannelID(Channel channel){
		List<Posts> postList = new ArrayList<>();
		try(Session s = sf.openSession()) {
			postList = s.createQuery("from POSTS WHERE CHANNEL_ID=" + channel.getChannelID()).getResultList();
		}
		return postList;
	}

	
	

}
