package com.xworkz.filehandling.writefile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
	public static void main(String[] args) {
		
		
		String data = "This is first line";
		try {
			System.out.println("file created successfully");
			FileWriter fileWriter = new FileWriter("C:\\Users\\ANAND\\Desktop\\FileHandling\\file1.txt");
			fileWriter.write(data);
			fileWriter.close();
			System.out.println("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
