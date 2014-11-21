package com.rikki.service.impl;

import java.util.List;

import com.rikki.dao.articleDAO;
import com.rikki.dao.commentDAO;
import com.rikki.domain.article;
import com.rikki.service.articleService;
import com.rikki.util.Page;
import com.rikki.util.PageResultCollection;
import com.rikki.util.PageUtil;

public class articleServiceImpl implements articleService {
	private articleDAO articleDao;
	private commentDAO commentDao;
	
	
	

	public commentDAO getCommentDao() {
		return commentDao;
	}



	public void setCommentDao(commentDAO commentDao) {
		this.commentDao = commentDao;
	}



	public articleDAO getArticleDao() {
		return articleDao;
	}



	public void setArticleDao(articleDAO articleDao) {
		this.articleDao = articleDao;
	}



	@Override
	public boolean addArticle(article atc) {
		return articleDao.add(atc);
	}



	@Override
	public List<article> queryAllArticles(String username) {
		System.out.println(articleDao.queryUserAll(username).size());
		return articleDao.queryUserAll(username);
	}



	@Override
	public PageResultCollection queryArticlesByPage(String username, Page page) {
		page = PageUtil.createPage(page, articleDao.queryUserAllBlogs(username));
		List<article> all = articleDao.queryByPage(username, page);
		PageResultCollection res = new PageResultCollection();
		res.setList(all);
		res.setPage(page);
		/*
		for(article atc: res){
			System.out.println(atc.getId());
			System.out.println(atc.getTitle());
			System.out.println(atc.getContent());
			System.out.println(atc.getUsername());
			System.out.println("--------------------");
		}
		*/
		return res;
		
	}



	@Override
	public PageResultCollection queryArticlesByPage(Page page) {
		page = PageUtil.createPage(page, articleDao.queryAllBlogs());
		List<article> all = articleDao.queryAllByPage(page);
		PageResultCollection res = new PageResultCollection();
		res.setList(all);
		res.setPage(page);
		return res;
	}



	@Override
	public article showArticle(int id) {
		
		return articleDao.queryById(id);
	}



	@Override
	public int getCommentCount(int aId) {
		return commentDao.queryCommentCount(aId);
	}

}
