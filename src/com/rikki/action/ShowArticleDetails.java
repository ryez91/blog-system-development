package com.rikki.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.rikki.domain.article;
import com.rikki.domain.bloginfo;
import com.rikki.service.BlogInfoService;
import com.rikki.service.articleService;
import com.rikki.service.commentService;
import com.rikki.util.Page;
import com.rikki.util.PageResultCollection;

public class ShowArticleDetails extends ActionSupport {
	private articleService atcService;
	private int id;
	private commentService cmService;
	private int currentPage;
	
	private String username;
	
	private BlogInfoService blogInfoService;
	
	
	

	public BlogInfoService getBlogInfoService() {
		return blogInfoService;
	}

	public void setBlogInfoService(BlogInfoService blogInfoService) {
		this.blogInfoService = blogInfoService;
	}

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

	public commentService getCmService() {
		return cmService;
	}

	public void setCmService(commentService cmService) {
		this.cmService = cmService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public articleService getAtcService() {
		return atcService;
	}

	public void setAtcService(articleService atcService) {
		this.atcService = atcService;
	}

	@Override
	public String execute() throws Exception {
		article atc = atcService.showArticle(id);
		atc.setHasRead(atc.getHasRead()+1);
		atcService.addArticle(atc);
		//System.out.println(atc.getId());
		
		Page page = new Page();
		page.setCurrentPage(this.getCurrentPage());
		page.setEveryPage(5);
		
		PageResultCollection res = cmService.showCommentByPage(id, page);

		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.setAttribute("article", atc);
		request.setAttribute("page", res.getPage());
		request.setAttribute("allCM", res.getList());
		
		if(username !=null || !"".equals(username)){
			Map session = ActionContext.getContext().getSession();
			bloginfo bloginfo = blogInfoService.getBlogInfo(username);
			
			if(bloginfo !=null){
				session.put("blogtitle", bloginfo.getBlogtitle());
				session.put("idiograph", bloginfo.getIdiograph());
				
			}
		}
		
		return this.SUCCESS;
	}
	
	

}
