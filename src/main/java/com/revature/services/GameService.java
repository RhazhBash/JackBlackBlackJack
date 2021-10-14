package com.revature.services;

import com.revature.models.Game;
import com.revature.models.Hand;

public class GameService {
	//Start/create new game
	//Get the status of a game
	//Add cards to hand (draw)
	//Calculate hand value
	//Increase player bet
	//Check who's turn it is
	//Split
	
	public int startGame(Game game) {
		//Take a game object passed from the handler and send it to the DAO to be stored
		//This method returns the ID of the game for the front end to track
	}
	
	public int getStatus(int id) {
		//Returns the game state of a given game ID
	}
	
	public Hand draw(String card) {
		//Add a card to a player's hand and return their new hand
	}
	
	public int handValue(int id) {
		//Take a player's hand and adjust the value to account for aces
		//Check the turn boolean to see who's hand to check
		//Start by assuming all aces are 11, then change them one at a time until the total is under 21
		//If it never gets under 21 they bust
	}
	
	public int bet(int id, int bet) {
		//Increase the player's bet, then return the new bet
	}
	
	public int checkTurn(int id) {
		//Get the turn boolean and pass it to the front end
	}
	
	public void split(int id) {
		//I really wanna make this a stretch goal
	}
	
	public void endGame(int id) {
		//Delete a game from the table
		//Anything else we need to do at the end of the game can go in here
	}
	
}
