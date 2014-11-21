package com.rikki.action;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ShowPhoto extends ActionSupport {

	@Override
	public String execute() throws Exception {
		Map session = ServletActionContext.getContext().getSession();
		String username = (String) session.get("username");
		
		String photoPath = 
				ServletActionContext.getServletContext().getRealPath("/user/photo/" + username);

		File fphotoPath = new File(photoPath);
		String[] photoList = fphotoPath.list();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("photoList", photoList);
		// TODO Auto-generated method stub
		return super.execute();
	}

}
