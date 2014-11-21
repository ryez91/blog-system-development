package com.rikki.dao;

import java.util.List;

import com.rikki.domain.user;

public interface userDAO {
	public void add(user u);
	public boolean delete(user u);
	public boolean update(user u);
	public List queryAll();
	public user queryByID(String username);

}
