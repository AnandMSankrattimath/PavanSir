package com.xworkz.filehandling;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class FileOperation {
	
	public static void main(String[] args) {
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		String query = "insert into file(appName) values (?)";
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","2580");
			preparedStatement =connection.prepareStatement(query);
			preparedStatement.setString(1, query);
			
			FileReader reader = new FileReader("C:\\Users\\ANAND\\Desktop\\FileHandling\\file");
			preparedStatement.setCharacterStream(1, reader);
			
			preparedStatement.execute();
			 
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if (preparedStatement!=null) {
					preparedStatement.close();
				}
				if (connection !=null) {
					connection.close();
					
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}

}
