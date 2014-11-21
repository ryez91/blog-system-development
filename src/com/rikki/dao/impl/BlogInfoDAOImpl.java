package com.rikki.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rikki.dao.BlogInfoDAO;
import com.rikki.domain.bloginfo;

public class BlogInfoDAOImpl extends HibernateDaoSupport implements BlogInfoDAO {

	@Override
	public void save(bloginfo info) {
		
		this.getHibernateTemplate().saveOrUpdate(info);

	}

	@Override
	public bloginfo get(String username) {
		List list = this.getHibernateTemplate().find("select bloginfo from bloginfo bloginfo where bloginfo.username=?", username);
	    if(list.size()==0){
	    	return null;
	    }else{
	    	return (bloginfo)list.get(0);
	    }
	}

}
