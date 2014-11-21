package com.rikki.service;

import com.rikki.domain.bloginfo;

public interface BlogInfoService {
	public void setBlogInfo(bloginfo info);
	public bloginfo getBlogInfo(String username);
	

}
