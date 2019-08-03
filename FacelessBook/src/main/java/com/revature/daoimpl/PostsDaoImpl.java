package com.revature.daoimpl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.revature.beans.Posts;
import com.revature.dao.PostsDao;

@Repository(value="PostsDAO")
@Transactional
public class PostsDaoImpl implements PostsDao{

	@Override
	public boolean insertPost(Posts p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePost(Posts p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePost(Posts p) {
		// TODO Auto-generated method stub
		return false;
	}

}
