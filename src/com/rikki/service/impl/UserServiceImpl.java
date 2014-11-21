package com.rikki.service.impl;

import com.rikki.dao.userDAO;
import com.rikki.domain.user;
import com.rikki.service.UserService;

public class UserServiceImpl implements UserService {
	private userDAO userDao;

	@Override
	public boolean registerUser(user u) {
		if(userDao.queryByID(u.getUsername())!=null){
			System.out.println("this username has registered before");
			return false;
		}else{
			userDao.add(u);
			return true;	
		}
	}

	public userDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(userDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean loginUser(user u) {
		if(userDao.queryByID(u.getUsername())==null){
			return false;
		}
		else{
			user queryuser = userDao.queryByID(u.getUsername());
			if(queryuser.getPassword().equals(u.getPassword())){
				//System.out.println("Match!");
				return true;
			}
			else{
				return false;
			}
			
		}
		
	}
	
	

}
