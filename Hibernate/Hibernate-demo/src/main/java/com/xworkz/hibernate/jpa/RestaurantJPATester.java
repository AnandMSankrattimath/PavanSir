package com.xworkz.hibernate.jpa;

import com.xworkz.hibernate.entity.RestaurantEntity;

public class RestaurantJPATester {
public static void main(String[] args) {
	RestaurantEntity restaurantEntity = new RestaurantEntity();
	
	restaurantEntity.setRestaurantId(3);
	restaurantEntity.setRestaurantName("Nani's Biryani");
	restaurantEntity.setContactNo(974063);
	restaurantEntity.setRating(4.5);
	restaurantEntity.setType("non-veg");
	
	RestaurantJPADAO restaurantJPADAO = new RestaurantJPADAO();
	restaurantJPADAO.saveRestaurentJPA(restaurantEntity);
	System.out.println("Saved successfully");
}
}
