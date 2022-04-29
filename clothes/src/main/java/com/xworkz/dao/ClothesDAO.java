package com.xworkz.dao;

import java.util.Date;

import com.xworkz.entity.Clothes;

public interface ClothesDAO {
	
	public void insertClothes(Clothes cloth);
	
	public Clothes getClothesById(Integer id);
	
	public void updateDateById(Date date, Integer id);
	
	public void deleteClothesById(Integer id);

}
