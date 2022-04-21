package com.xworkz.hibernate.runner;

import com.xworkz.hibernate.dao.RestaurantDAO;
import com.xworkz.hibernate.entity.RestaurantEntity;

public class Runner {
	public static void main(String[] args) {
		RestaurantEntity restaurantEntity = new RestaurantEntity();
		// by default it will take preparedStatements rather than the statement.
		restaurantEntity.setRestaurantId(1);
		restaurantEntity.setRestaurantName("Udupi grand");
		restaurantEntity.setContactNo(9740935);
		restaurantEntity.setRating(7.2);
		restaurantEntity.setType("veg");
		
		RestaurantDAO restaurantDAO = new RestaurantDAO();
		restaurantDAO.saveRestaurant(restaurantEntity);
		System.out.println("Saved successfully");
	}

}
