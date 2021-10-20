package com.revature.services;
import java.util.ArrayList;

import com.revature.daos.GameDAO;
import com.revature.daos.userDAO;
import com.revature.models.Card;
//Delete this comment
import com.revature.models.Game;
import com.revature.models.GameDTO;


public class GameService {
	
	GameDAO GDAO = new GameDAO();
	userDAO UDAO = new userDAO();
	
	public Game startGame(GameDTO gameDTO) {
		//Take a game object passed from the handler and send it to the DAO to be stored
		//This method returns the ID of the game for the front end to track
		Game game = new Game();
		
		String id=gameDTO.getDeck_id();
		int bet=gameDTO.getBet();
	
		ArrayList<String> playerHand = new ArrayList<String>();
		ArrayList<String> dealerHand = new ArrayList<String>();
		
		
		
		for (int i=0; i<gameDTO.getPlayerHand().length; i++) {
			Card card = gameDTO.getPlayerHand()[i];
			playerHand.add(card.getValue());
		}
		
		for (int i=0; i<gameDTO.getDealerHand().length; i++) {
			Card card = gameDTO.getDealerHand()[i];
			dealerHand.add(card.getValue());
		}
		
		int playerTotal=game.getHandValue(playerHand);
		int dealerTotal=game.getHandValue(dealerHand);
		
		Game newGame = new Game(id, 0, true, false, false, bet, playerTotal, true, false, false, false, false, playerHand, dealerTotal, false, false, dealerHand);
		
		
		GDAO.newGame(newGame);
		return newGame;
	}
	
	public boolean bet(int bet) {
		//Subtract a player's bet from their chip total
		//Dependent on userDAO
	}
	
	public void payout(int bet, boolean blackjack) {
		//Take a bet, multiply it by the house payout, and add it to a user's chip count
	}
	
	public void stand() {
		
	}
	
	public void resetGame() {
		
	}
	
	public void endGame(String id) {
		//Delete a game from the table
		//Anything else we need to do at the end of the game can go in here
		GDAO.deleteGame(id);
	}
	
}
