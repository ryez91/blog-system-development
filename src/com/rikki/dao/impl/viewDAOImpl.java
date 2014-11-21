package com.rikki.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rikki.dao.viewDAO;
import com.rikki.util.ViewAdvanced;

public class viewDAOImpl extends HibernateDaoSupport implements viewDAO{

	@Override
	public List queryById(final int aId, final String ip, final Date date) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback(){

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("select viewadvance from ViewAdvanced viewadvance where viewadvance.aId = ? and viewadvance.ip = ? and viewadvance.date = ?");
				query.setParameter(0, aId);
				query.setParameter(1, ip);
				query.setParameter(2, date);
				return query.list();
			}
			
		});
	}

	@Override
	public void addRecord(ViewAdvanced v) {
		this.getHibernateTemplate().save(v);
		
	}

}
