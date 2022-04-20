package com.xworkz.gamesApp;

import java.util.Scanner;

import com.xworkz.gamesApp.DAO.GamesDAO;
import com.xworkz.gamesApp.DTO.GamesDTO;

public class Tester {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the game id");
		int id = scanner.nextInt();
		
		System.out.println("Enter the game Name");
		String nameString=scanner.next();
		
		System.out.println("Enter the number of players");
		int noOfPlayers = scanner.nextInt();
		
		System.out.println("Enter the game type");
		String type= scanner.next();
		
		GamesDTO dto = new GamesDTO(id,nameString,noOfPlayers,type);
		
		boolean status = GamesDAO.saveGame(dto);
		if (status) {
			System.out.println(" Save Successfully");
		}
		else {
			System.err.println("Save unsuccessfull....!");
		}
		

	}

}
