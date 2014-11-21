package com.rikki.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.rikki.domain.comment;
import com.rikki.service.commentService;

public class AddComment extends ActionSupport {
	private commentService cmService;
	private int id;
	private String content;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public commentService getCmService() {
		return cmService;
	}

	public void setCmService(commentService cmService) {
		this.cmService = cmService;
	}

	@Override
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		String username = (String) session.get("username");
		comment c = new comment();
		if(username==null ||"".equals(username)){
			c.setUsername("Visitor");
		}else{
			c.setUsername(username);
		}
		
		c.setaId(id);
		c.setContent(content);
		
		cmService.addComment(c);
		return SUCCESS;
	}
	
	

}
