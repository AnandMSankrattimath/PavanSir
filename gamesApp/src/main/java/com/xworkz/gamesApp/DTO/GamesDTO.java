package com.xworkz.gamesApp.DTO;

public class GamesDTO {
	private int id;
	private String gameName;
	private int noOfPlayers;
	private String gameType;
	
	public GamesDTO(){
		// default constructor
	}

	public GamesDTO(int id, String gameName, int noOfPlayers, String gameType) {
		super();
		this.id = id;
		this.gameName = gameName;
		this.noOfPlayers = noOfPlayers;
		this.gameType = gameType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public int getNoOfPlayers() {
		return noOfPlayers;
	}

	public void setNoOfPlayers(int noOfPlayers) {
		this.noOfPlayers = noOfPlayers;
	}

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}


}
