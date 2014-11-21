package com.rikki.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.rikki.domain.user;
import com.rikki.service.BlogInfoService;
import com.rikki.service.UserService;

public class Login extends ActionSupport {
	private String username;
	private String password;
	
	private BlogInfoService bloginfoService;
	

	private UserService userService;
	
	
	
	public BlogInfoService getBloginfoService() {
		return bloginfoService;
	}

	public void setBloginfoService(BlogInfoService bloginfoService) {
		this.bloginfoService = bloginfoService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String execute() throws Exception {
		user u = new user();
		u.setUsername(username);
		u.setPassword(password);
		
		
		HttpServletRequest request = ServletActionContext.getRequest();
		if(userService.loginUser(u)){
			if(bloginfoService.getBlogInfo(username)==null){
				request.setAttribute("url", "getBlogInfo.action");
			}else{
				request.setAttribute("url", "showAllArticles.action");
			}
			
			request.setAttribute("info", "Welcome!");
			//put username in session
			//(1)HttpSession session = request.getSession();
			//(2)session.setAttribute("username", username);
			Map session = ActionContext.getContext().getSession();
			session.put("username", username);
			
			return SUCCESS;
			
			
			
		}
		else{
			request.setAttribute("url", "login.jsp");
			request.setAttribute("info", "Access denied.");
			return ERROR;
		}
	}
	

}
