package com.rikki.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rikki.dao.userDAO;
import com.rikki.domain.user;

public class userDAOImpl extends HibernateDaoSupport implements userDAO {

	@Override
	public void add(user u) {
		this.getHibernateTemplate().save(u);

	}

	@Override
	public boolean delete(user u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(user u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public user queryByID(String username) {
		List list = this.getHibernateTemplate().find("select user from user user where user.username = '" + username + "'");
		if(list.size()!=0){
			user t = (user)list.get(0);
			/*
			System.out.println("username: "+t.getUsername());
			System.out.println("email:" + t.getEmail());
			System.out.println("password: "+ t.getPassword());
			*/
			return (user)list.get(0);
		}else{
			System.out.println("this user doesn't exist!");
			return null;
		}
	}

}
