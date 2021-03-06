package com.xworks.jdbcdemo.DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.google.protobuf.Int32ValueOrBuilder;

public class MovieDTO {
	static Connection connection=null;
	static Statement statement=null;
	Scanner scanner = new Scanner(System.in);
	
	static {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","2580");
			statement = connection.createStatement();
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Class is Loaded");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void insertMovieData() {
		System.out.println("Inside insertMovieData()");
		System.out.println("Enter  id");
		int id = scanner.nextInt();

		System.out.println("Enter  Movie Name");
		String name = scanner.next();

		System.out.println("Enter Movie Rating");
		double rating = scanner.nextDouble();

		System.out.println("Enter Movie Launguage");
		String language = scanner.next();

		System.out.println("Enter Movie Budget");
		long budget = scanner.nextLong();
		
		String queryString = "insert into movie values("+id+name+rating+language+budget+")";
		try {
			statement.execute(queryString);
			if (statement.execute(queryString)==true) {
				System.out.println("Record inserted successfully");
			}
			else {
				System.out.println(" Record was not inserted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
