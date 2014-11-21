package com.rikki.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.rikki.domain.bloginfo;
import com.rikki.service.BlogInfoService;

public class GetBlogInfo extends ActionSupport{
	private BlogInfoService blogInfoService;

	public BlogInfoService getBlogInfoService() {
		return blogInfoService;
	}

	public void setBlogInfoService(BlogInfoService blogInfoService) {
		this.blogInfoService = blogInfoService;
	}

	@Override
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		bloginfo info = blogInfoService.getBlogInfo((String)session.get("username"));
		
		if(info!=null){
			session.put("blogtitle", info.getBlogtitle());
			session.put("idiograph", info.getIdiograph());
		}
		
		return this.SUCCESS;
	}
	
	
	
	

}
