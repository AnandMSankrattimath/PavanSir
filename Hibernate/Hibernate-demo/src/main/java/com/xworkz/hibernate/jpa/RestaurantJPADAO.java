package com.xworkz.hibernate.jpa;

import com.xworkz.hibernate.entity.RestaurantEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RestaurantJPADAO {

	public void saveRestaurentJPA(RestaurantEntity entity) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("jpa");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		entitymanager.persist(entity);
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
	}

}
