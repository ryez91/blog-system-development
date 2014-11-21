package com.rikki.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rikki.dao.commentDAO;
import com.rikki.domain.comment;
import com.rikki.util.Page;

public class commentDAOImpl extends HibernateDaoSupport implements commentDAO {

	@Override
	public void addComment(comment c) {
		this.getHibernateTemplate().save(c);

	}

	@Override
	public int queryCommentCount(int aId) {
		List find = this.getHibernateTemplate().find("select count(*) from comment comment where comment.aId = ?", aId);
		
		return ((Long)find.get(0)).intValue();
	}

	@Override
	public List<comment> queryByPage(final int aId, final Page page) {
		
		return this.getHibernateTemplate().executeFind(new HibernateCallback(){

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("select comment from comment comment where comment.aId = ?");
				query.setParameter(0, aId);
				query.setMaxResults(page.getEveryPage());
				query.setFirstResult(page.getBeginIndex());
				return query.list();
			}
			
		});
	}

}
