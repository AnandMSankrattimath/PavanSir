package com.xworkz.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
/*
 * ORM = object Realation Model/mapping
 * Should map the class and table
 * should also map the class members to the respective table columns.
 * note: map only if both names are diff. if both names are same 
 * JPA -- Java Persistant Api(older version)
 * JPA -- Jakarta Persistant Api(newer version)
 * hibernate provides implementation of JPA.
 * JPA is a specification of ORM.
 * entity -- 
 * 
 * */
@Data // lombok property by default it has setter,getter(),toString(),hashCode(),equals() which helps developer to do no write those methods.
//after updating the java version we have "record" instead of lombok external software.


@Entity // to tell that which class is entity.

@Table(name = "restaurant") // to map the entity class to table.

public class RestaurantEntity {
	
	@Id // to tell the which is primary key.
	@Column(name = "id") // column to class member mapping(if both names are diff)
	private int restaurantId;
	@Column(name = "name") // column to class member mapping(if both names are diff)
	private String restaurantName; // not mapping coz both names i.e table column name & class member name both are same.
	private long contactNo;
	private String type;
	private double rating;
}
