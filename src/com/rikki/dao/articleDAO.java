package com.rikki.dao;

import java.util.List;

import com.rikki.domain.article;
import com.rikki.util.Page;

public interface articleDAO {
	public boolean add(article atc);
	public List<article> queryUserAll(String username);
	
	public int queryUserAllBlogs(String username);
	public List<article> queryByPage(String username, Page page);
	
	public int queryAllBlogs();
	public List<article> queryAllByPage(Page page);

	public article queryById(int id);
}
