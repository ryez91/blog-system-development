package com.rikki.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.rikki.domain.article;
import com.rikki.service.BlogInfoService;
import com.rikki.service.articleService;
import com.rikki.service.commentService;
import com.rikki.util.Page;
import com.rikki.util.PageResultCollection;

public class ShowAllArticleByUser extends ActionSupport {
	private articleService atcService;
	private int currentPage;
	private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public articleService getAtcService() {
		return atcService;
	}

	public void setAtcService(articleService atcService) {
		this.atcService = atcService;
	}

	@Override
	public String execute() throws Exception {
		
		if(username==null||"".equals(username)){
			Map session = ActionContext.getContext().getSession();
			username = (String)session.get("username");
		}
		//List<article> all = atcService.queryAllArticles(username);
		Page page = new Page();
		page.setCurrentPage(this.getCurrentPage());
		page.setEveryPage(5);
		PageResultCollection res = atcService.queryArticlesByPage(username, page);
		page = res.getPage();
		List<article> all = res.getList();
		List commentCounts = new ArrayList();
		for(article a : all){
			commentCounts.add(atcService.getCommentCount(a.getId()));
		}
		
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("all", all);
		request.setAttribute("page", page);
		request.setAttribute("commentCount", commentCounts);
		return this.SUCCESS;
	}
	
	

}
