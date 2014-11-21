package com.rikki.dao;

import com.rikki.domain.bloginfo;

public interface BlogInfoDAO {
	public void save(bloginfo info);
	public bloginfo get(String username);

}
