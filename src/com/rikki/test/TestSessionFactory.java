package com.rikki.test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.rikki.domain.user;

public class TestSessionFactory {
	@Test
	public void test(){
		Configuration config = new Configuration();
		config.configure();
		
		SessionFactory sf = config.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		user u = new user();
		u.setEmail("hi@google.com");
		u.setUsername("hellokitty");
		u.setPassword("helloworld");
		u.setQuestion("Your hometown");
		u.setAnswer("Japan");
		
		s.save(u);
		tx.commit();
		s.close();
		
	}

}
