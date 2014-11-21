package com.rikki.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.rikki.domain.user;
import com.rikki.service.UserService;

public class Register extends ActionSupport{
	
	private String username;
	private String password;
	private String repassword;
	private String question;
	private String answer;
	private String email;
	
	private UserService userService;
	
	
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
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
		u.setEmail(email);
		u.setPassword(password);
		u.setQuestion(question);
		u.setAnswer(answer);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		if(userService.registerUser(u)){
			request.setAttribute("url", "login.jsp");
			request.setAttribute("info", "Welcome, new blogger");
			return SUCCESS;
		}
		else{
			request.setAttribute("url", "register.jsp");
			request.setAttribute("info", "Opps, please try again");
			return ERROR;
		}
		/*
		System.out.println(this.username);
		System.out.println(this.password);
		System.out.println(this.repassword);
		System.out.println(this.question);
		System.out.println(this.answer);
		System.out.println(this.email);
		*/
		
		
	}
}
