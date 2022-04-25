package com.xworkz.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

import com.xworkz.hibernate.entity.RestaurantEntity;
/*configuration (c)-- 
 * configuration.configure() -- it will start finding the hibernate.cfg.xml and checks for the syntax error.-- for all xml exception it will throw sacsParseException.
 * Dialect -- 
 * sessionFacotry(I)--extends the EntityManagerFactory(I) which is in JPA.
 * connectionPool--
 * Session(I)--extends EntityManager(I)
 * 
 * C-- W
 * R--
 * U--
 * D--
 * In DB whenever data is not their it wont trow any error.
 * 
 * 
 * */


public class RestaurantDAO {
	
	public void saveRestaurant(RestaurantEntity entity) {
		
		Configuration configuration = new Configuration(); // 
		configuration.configure();
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();//which makes physical connection & session makes to perform the CRUD.
		
		// In hibernate autoCommit is false.
		Transaction transaction = session.beginTransaction();
		
		session.persist(entity);
		
		transaction.commit();//it will save the data in the table.
	}

}
