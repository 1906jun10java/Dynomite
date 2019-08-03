package com.revature.daoimpl;


import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Posts;
import com.revature.dao.PostsDao;

public class PostsDaoImpl implements PostsDao{
	
	
	
	@Transactional
	@Override
	public String insertPost(Posts p) {
		return null;
	}

}
