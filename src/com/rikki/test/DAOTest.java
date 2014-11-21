package com.rikki.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rikki.dao.BlogInfoDAO;
import com.rikki.dao.articleDAO;
import com.rikki.dao.commentDAO;
import com.rikki.dao.userDAO;
import com.rikki.domain.article;
import com.rikki.domain.bloginfo;
import com.rikki.domain.comment;
import com.rikki.domain.user;

public class DAOTest {
	@Test
	
	public void testSave(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/Spring/applicationContext.xml");
		userDAO dao = (userDAO)ctx.getBean("userDao");
		
		/*
		user u = new user();
		u.setUsername("Carey");
		u.setEmail("mc@yahoo.com");
		u.setPassword("232323");
		u.setQuestion("favorite food");
		u.setAnswer("steak");
		
		dao.add(u);
		*/
		
		
	}
	@Test
	public void testQueryById(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/Spring/applicationContext.xml");
		userDAO dao = (userDAO)ctx.getBean("userDao");
		dao.queryByID("john");
	}
	
	@Test
	public void testEditBlogInfoDAO(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/Spring/applicationContext.xml");
		BlogInfoDAO biDao = (BlogInfoDAO)ctx.getBean("BlogInfoDAO");
		bloginfo bi = new bloginfo();
		bi.setUsername("hellokitty");
		bi.setBlogtitle("PrivateCorner");
		bi.setIdiograph("This is my blog.");
		biDao.save(bi);
	}
	
	@Test
	public void testqueryAllArticle(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/Spring/applicationContext.xml");
		articleDAO aDao = (articleDAO)ctx.getBean("articleDAO");
		List<article> list = aDao.queryUserAll("nuptmush");
		list = (ArrayList<article>) list;
		System.out.println(list.size());
	}
	
	@Test
	public void testBlogCount(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/Spring/applicationContext.xml");
		articleDAO aDao = (articleDAO)ctx.getBean("articleDAO");
		System.out.println(aDao.queryUserAllBlogs("hellokitty"));
	}
	
	@Test
	public void testshowArticleDetails(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/Spring/applicationContext.xml");
		articleDAO aDao = (articleDAO)ctx.getBean("articleDAO");
		article atc = aDao.queryById(1);
		System.out.println("id: " + atc.getId() + ", title: "+ atc.getTitle() );
		
	}
	@Test
	public void testCommentDAO(){
		
			ApplicationContext ctx = new ClassPathXmlApplicationContext("/Spring/applicationContext.xml");
			commentDAO cDao = (commentDAO)ctx.getBean("commentDAO");
			comment c = new comment();
			c.setId(1);
			c.setaId(3);
			c.setContent("Good");
			c.setUsername("John123");
			cDao.addComment(c);
		
	}

}
