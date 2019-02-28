package com.hibernate.demo.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.model.UserDetails;

public class HibernateDemoTest {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = null;
		
		
		try {
			session = factory.openSession();
			session.beginTransaction();
		
			Query query = session.createQuery("select userName from UserDetails");
			int start = 2;
			int limit = 3;
			while(start <= 10) {
				query.setMaxResults(limit);
				query.setFirstResult(start);
				
				List<String> userNames = (List<String>) query.list();
				
				for(String userName : userNames)
					System.out.println(userName);
				start += limit;
				System.out.println("========================================");
			}
			
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeResources(factory, session);
		}
	}

	private static void closeResources(SessionFactory factory, Session session) {
		try {
			if(session != null)
				session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		try {
			if(factory != null)
				factory.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}
