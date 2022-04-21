package com.xworkz.filehandling.readfile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	public static void main(String[] args) {
		char [] data = new char[100];
		try {
			FileReader reader = new FileReader("C:\\Users\\ANAND\\Desktop\\FileHandling\\file1.txt");
			reader.read(data);
			System.out.println(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
