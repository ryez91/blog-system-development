package com.rikki.service;

import java.util.List;

import com.rikki.domain.article;
import com.rikki.util.Page;
import com.rikki.util.PageResultCollection;

public interface articleService {
	public boolean addArticle(article atc);
	public List<article> queryAllArticles(String username);
	public PageResultCollection queryArticlesByPage(String username, Page page);
	
	public PageResultCollection queryArticlesByPage(Page page);
	
	public article showArticle(int id);
	
	public int getCommentCount(int aId);

}
