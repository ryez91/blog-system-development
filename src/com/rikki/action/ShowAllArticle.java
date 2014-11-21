package com.rikki.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.rikki.domain.article;
import com.rikki.service.articleService;
import com.rikki.util.Page;
import com.rikki.util.PageResultCollection;

public class ShowAllArticle extends ActionSupport {
	private articleService atcService;
	private int currentPage;
	
	
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
		
		Page page = new Page();
		page.setCurrentPage(this.getCurrentPage());
		page.setEveryPage(10);
		
		PageResultCollection res = atcService.queryArticlesByPage(page);
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
