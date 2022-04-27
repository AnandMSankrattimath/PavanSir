package com.xworkz.gamesApp.DAO;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static com.xworkz.gamesApp.constants.DBConstants.*;
import java.util.Properties;

import com.xworkz.gamesApp.DTO.GamesDTO;

public class GamesDAO {
	static Properties properties;
	public static Properties loadPropertiesFile() throws Exception{
		properties = new Properties();
		FileInputStream inputStream = new FileInputStream("jdbc.properties");
		properties.load(inputStream);
		inputStream.close();
		
		return properties;
		
	}

	static public boolean saveGame(GamesDTO gamesDTO) {
		String insertQuery = "insert into games values(?,?,?,?)";
	System.out.println(" Create JDBC using file ( Properties file)");
	
		if (gamesDTO == null) {
			return false;
		}
		else {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			
			try {
				properties = loadPropertiesFile();
				String urlString=properties.getProperty("url");
				String userName=properties.getProperty("username");
				String password = properties.getProperty("password");				
				
				
				
				
				
				
				
				
				connection = DriverManager.getConnection(urlString, userName, password);
				
				preparedStatement = connection.prepareStatement(insertQuery); // info about prepared
				
				preparedStatement.setInt(1, gamesDTO.getId());
				preparedStatement.setString(2, gamesDTO.getGameName());
				preparedStatement.setInt(3, gamesDTO.getNoOfPlayers());
				preparedStatement.setString(4, gamesDTO.getGameType());
				
				preparedStatement.execute();
				
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if (preparedStatement!=null)
						preparedStatement.close();
					if( connection!=null)
						connection.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
		}
		return false;
	}
}
