package com.rikki.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.rikki.domain.bloginfo;
import com.rikki.service.BlogInfoService;

public class EditBlogInfo extends ActionSupport {
	
	private String blogtitle;
	private String idiograph;	
	private BlogInfoService blogInfoService;
	
	
	public BlogInfoService getBlogInfoService() {
		return blogInfoService;
	}


	public void setBlogInfoService(BlogInfoService blogInfoService) {
		this.blogInfoService = blogInfoService;
	}



	public String getBlogtitle() {
		return blogtitle;
	}



	public void setBlogtitle(String blogtitle) {
		this.blogtitle = blogtitle;
	}



	public String getIdiograph() {
		return idiograph;
	}



	public void setIdiograph(String idiograph) {
		this.idiograph = idiograph;
	}



	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		bloginfo info = new bloginfo();
		//get username from session scope
		//info.setUsername("hellokitty");
		/*
		HttpSession session = request.getSession();
		info.setUsername((String)session.getAttribute("username"));
		*/
		//2 from 
		Map session = ActionContext.getContext().getSession();
		info.setUsername((String)session.get("username"));
		info.setBlogtitle(blogtitle);
		info.setIdiograph(idiograph);
		
		blogInfoService.setBlogInfo(info);
		
		return this.SUCCESS;
	}
	
	

}
