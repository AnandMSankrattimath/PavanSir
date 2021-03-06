package com.xworkz.filehandling.operation;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.xworkz.filehandling.constants.DBConstants.*;





public class OperationOnFile {
private int id;

private String name;

public void read() {
	File file = new File("C:\\Users\\ANAND\\Desktop\\FileHandling\\Operation.txt");
	
	try {
		file.createNewFile();
		System.out.println("File created successfully");
		
		Scanner scanner = new Scanner(file);
		
		
		while (scanner.hasNextLine()) {
			name="";
			String lineString = scanner.nextLine();
			while (scanner.hasNextInt()) {
				id=scanner.nextInt();
			}
			if (!scanner.hasNextInt()) {
				name=""+scanner.next();
			}
			
			
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public void saveOperation() {
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	try {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","2580");
		preparedStatement=connection.prepareStatement("insert into file values(?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.executeUpdate();
		System.out.println("data saved");
	}catch (Exception e) {
		// TODO: handle exception
	}
}
}
