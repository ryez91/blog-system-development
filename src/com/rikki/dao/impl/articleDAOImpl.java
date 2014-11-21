package com.rikki.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rikki.dao.articleDAO;
import com.rikki.domain.article;
import com.rikki.util.Page;

public class articleDAOImpl extends HibernateDaoSupport implements articleDAO {

	@Override
	public boolean add(article atc) {
		this.getHibernateTemplate().saveOrUpdate(atc);
		return false;
	}

	@Override
	public List<article> queryUserAll(String username) {
		List res = this.getHibernateTemplate().find("select article from article article where article.username = ?", username);
		List<article> list = res;
		System.out.println(list.size());
		return list;
	}

	@Override
	public int queryUserAllBlogs(String username) {
		List res = this.getHibernateTemplate().find("select count(*) from article article where article.username = ?", username);
		return ((Long)res.get(0)).intValue();
	}

	@Override
	public List<article> queryByPage(final String username, final Page page) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session)
			     throws HibernateException, SQLException{
				
				Query query = session.createQuery("select article from article article where article.username = ? order by article.date desc");
				query.setParameter(0, username);
				query.setMaxResults(page.getEveryPage());
				query.setFirstResult(page.getBeginIndex());
				
				return query.list();
				
			}
		});

	}

	@Override
	public int queryAllBlogs() {
		List list = this.getHibernateTemplate().find("select count(*) from article article"); 
		return ((Long)list.get(0)).intValue();
	}

	@Override
	public List<article> queryAllByPage(final Page page) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session)
			     throws HibernateException, SQLException{
				
				Query query = session.createQuery("select article from article article order by article.date desc");
				
				query.setMaxResults(page.getEveryPage());
				query.setFirstResult(page.getBeginIndex());
				
				return query.list();
				
			}
		});
	}

	@Override
	public article queryById(int id) {
		List list = this.getHibernateTemplate().find("select article from article article where article.id = ?", id);
		return (article) list.get(0);
		
	}

}
