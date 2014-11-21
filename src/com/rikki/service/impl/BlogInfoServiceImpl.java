package com.rikki.service.impl;

import com.rikki.dao.BlogInfoDAO;
import com.rikki.domain.bloginfo;
import com.rikki.service.BlogInfoService;

public class BlogInfoServiceImpl implements BlogInfoService {
	private BlogInfoDAO blogInfoDao;
	
	public BlogInfoDAO getBlogInfoDao() {
		return blogInfoDao;
	}

	public void setBlogInfoDao(BlogInfoDAO blogInfoDao) {
		this.blogInfoDao = blogInfoDao;
	}

	@Override
	public void setBlogInfo(bloginfo info) {
		blogInfoDao.save(info);
		

	}

	@Override
	public bloginfo getBlogInfo(String username) {
		return blogInfoDao.get(username);
	}

}
