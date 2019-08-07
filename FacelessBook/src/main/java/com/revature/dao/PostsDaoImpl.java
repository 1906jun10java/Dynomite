package com.revature.dao;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.revature.beans.Channel;
import com.revature.beans.Posts;
import com.revature.dao.PostsDao;


@Repository(value="PostsDAO")
@Transactional
public class PostsDaoImpl implements PostsDao{
	
	private SessionFactory sessionFactory;
	
	@Autowired //constructor injection
	public PostsDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public boolean insertPost(Posts post, Channel channel) {
		Session s = sessionFactory.getCurrentSession();
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
		Session s = sessionFactory.getCurrentSession();
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
		Session s = sessionFactory.getCurrentSession();
		try {
			Posts p = s.get(Posts.class, post.getPostID());
			p.setContent("Inappropriate content. Blocked by Moderator");
			s.update(p);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Posts> getPostWithNoCommentID() {
		List<Posts> postList = new ArrayList<>();
		Session s = sessionFactory.getCurrentSession();
		postList = s.createQuery("from Posts WHERE commentID IS 0").getResultList();
		return postList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Posts> getPostByCommentID(Posts post){
		List<Posts> postList = new ArrayList<>();
		Session s = sessionFactory.getCurrentSession();
		postList = s.createQuery("from Posts WHERE commentID=" + post.getPostID()).getResultList();
		return postList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Posts> getPostByChannelID(Channel channel){
		List<Posts> postList = new ArrayList<>();
		Session s = sessionFactory.getCurrentSession();
		postList = s.createQuery("from Posts WHERE channelID=" + channel.getChannelID()).getResultList();
		return postList;
	}

	
	

}
