package com.xworkz.runner;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.xworkz.dao.ClothesDAOImpl;
import com.xworkz.entity.Clothes;

public class Runner {

	public static void main(String[] args) {
		Clothes clothes = new Clothes();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date date;
		try {
			date = simpleDateFormat.parse("2018-09-09");
			clothes.setDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clothes.setId(4);
		clothes.setBrand("Levis");
		clothes.setPrice(225.00);
		ClothesDAOImpl daoImpl = new ClothesDAOImpl();
		// daoImpl.insertClothes(clothes);
		// System.out.println("Saved Successfully....");

		// daoImpl.getClothesById(4);
		/*
		 * try { date = simpleDateFormat.parse("2021-01-01");
		 * daoImpl.updateDateById(date, 4);
		 * System.out.println("Updated Successfully..."); } catch (ParseException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); } }
		 */
		daoImpl.deleteClothesById(4);
		System.out.println("Deleted successfully..");

	}
}