package com.rikki.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rikki.domain.article;
import com.rikki.domain.comment;
import com.rikki.domain.user;
import com.rikki.service.UserService;
import com.rikki.service.articleService;
import com.rikki.service.commentService;

public class ServiceTest {
	
	@Test
	public void testRegister(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/Spring/applicationContext.xml");
		UserService userS = (UserService)ctx.getBean("userService");
		
		user u = new user();
		u.setUsername("hellokitty");
		u.setEmail("eva@sina.com");
		u.setPassword("77777");
		u.setQuestion("favorite food");
		u.setAnswer("chicken wings");
		
		userS.registerUser(u);
	}
	@Test
	public void showAllBlogs(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/Spring/applicationContext.xml");
		articleService atcS =(articleService)ctx.getBean("articleService"); 
		List<article> list = atcS.queryAllArticles("hellokitty");
		
		
	}
	@Test
	public void showBlogDetials(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/Spring/applicationContext.xml");
		articleService atcS =(articleService)ctx.getBean("articleService"); 
		article atc = atcS.showArticle(1);
		System.out.println("id: " + atc.getId() +", title: " + atc.getTitle() + ", content: "+atc.getContent());
		
	}
	
	
	@Test
	public void addCommentService(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/Spring/applicationContext.xml");
		commentService commentS =(commentService)ctx.getBean("commentService"); 
		comment c = new comment();
		c.setId(2);
		c.setaId(5);
		c.setContent("Cool!");
		c.setUsername("nuptmush");
		commentS.addComment(c);
	}

}
