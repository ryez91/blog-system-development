package com.rikki.action;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.rikki.domain.article;
import com.rikki.service.articleService;

public class AddArticle extends ActionSupport {
	private String title;
	private String content;
	private articleService atcService;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public articleService getAtcService() {
		return atcService;
	}
	public void setAtcService(articleService atcService) {
		this.atcService = atcService;
	}
	@Override
	public String execute() throws Exception {
		
		Map session = ActionContext.getContext().getSession();
		String username = (String)session.get("username");
		HttpServletRequest request = ServletActionContext.getRequest();
		
		article atc = new article();
		atc.setUsername(username);
		atc.setTitle(title);
		atc.setContent(content);
		atc.setDate(new Date());
		atc.setHasRead(0);
		atcService.addArticle(atc);
		
		request.setAttribute("url", "showAllArticles.action");
		request.setAttribute("info", "Your new blog has been posted!");
		return this.SUCCESS;
	}
	
	
	
	
	
	

}
