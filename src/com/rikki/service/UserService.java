package com.rikki.service;

import com.rikki.domain.user;

public interface UserService {
	public boolean registerUser(user u);
	public boolean loginUser(user u);

}
