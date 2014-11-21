package com.rikki.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rikki.domain.article;
import com.rikki.domain.user;
import com.rikki.service.UserService;
import com.rikki.service.articleService;

public class TestAddArticleService {
	@Test
	public void test(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/Spring/applicationContext.xml");
		articleService atcService = (articleService)ctx.getBean("articleService");
		
		article atc = new article();
		atc.setUsername("hellokitty");
		atc.setTitle("Hello");
		atc.setContent("This is my first blog!");
		atc.setDate(new Date());
		atcService.addArticle(atc);
		
		
		
	}

}
