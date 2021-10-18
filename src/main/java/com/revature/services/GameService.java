package com.revature.services;
import com.revature.daos.GameDAO;
//Delete this comment
import com.revature.models.Game;


public class GameService {
	
	GameDAO GDAO = new GameDAO();
	
	public String startGame(Game game) {
		//Take a game object passed from the handler and send it to the DAO to be stored
		//This method returns the ID of the game for the front end to track
		GDAO.newGame(game);
		return game.getId();
	}
	
	public boolean bet(int bet) {
		//Subtract a player's bet from their chip total
		//Dependent on userDAO
	}
	
	public void payout(int bet, boolean blackjack) {
		//Take a bet, multiply it by the house payout, and add it to a user's chip count
	}
	
	public void resetGame() {
		
	}
	
	public void endGame(String id) {
		//Delete a game from the table
		//Anything else we need to do at the end of the game can go in here
		GDAO.deleteGame(id);
	}
	
}
