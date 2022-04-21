package com.xworkz.filehandling.filecreate;

import java.io.File;
import java.io.IOException;

public class FileCreation {
	public static void main(String[] args) {
		File file = new File("C:\\Users\\ANAND\\Desktop\\FileHandling\\file1.txt");
		try {
			if(file.createNewFile()) {
				System.out.println("File created successfully");
			}
			else {
				System.err.println(" File not created");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
