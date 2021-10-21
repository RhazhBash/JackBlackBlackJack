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
		boolean blackjack=false;
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
		
		if (playerTotal==21)
			blackjack=true;
		Game newGame = new Game(id, 0, true, true, false, false, bet, playerTotal, true, false, blackjack, false, false, false, false, playerHand, dealerTotal, false, false, dealerHand);
		
		
		GDAO.newGame(newGame);
		return newGame;
	}
	
	public Game hit(GameDTO GDTO) {
		
		Game game = GDAO.getGame(GDTO.getDeck_id());
		
		ArrayList<String> playerHand = new ArrayList<String>();
		
		for (int i=0; i<GDTO.getPlayerHand().length; i++) {
			Card card = GDTO.getPlayerHand()[i];
			playerHand.add(card.getValue());
		}
		
		int playerTotal = game.getHandValue(playerHand);
		
		game.setPlayerTotal(playerTotal);
		game.setPlayerHand(playerHand);
		
		if (playerTotal>21)
			game.setPlayerBust(true);
		
		GDAO.newGame(game);
		
		return game;
	}
	
	public Game dealerHit(GameDTO GDTO) {
		Game game = GDAO.getGame(GDTO.getDeck_id());
		
		ArrayList<String> dealerHand = new ArrayList<String>();
		
		for (int i=0; i<GDTO.getPlayerHand().length; i++) {
			Card card = GDTO.getPlayerHand()[i];
			dealerHand.add(card.getValue());
		}
		
		int dealerTotal = game.getHandValue(dealerHand);
		
		game.setDealerTotal(dealerTotal);
		game.setDealerHand(dealerHand);
		
		if (16<dealerTotal&&dealerTotal<22)
			game.setDealerStanding(true);
		else if (dealerTotal>21)
			game.setDealerBust(true);
		
		GDAO.newGame(game);
		
		return game;
	}
	
	public Game stand(GameDTO GDTO) {
		
		Game game = GDAO.getGame(GDTO.getDeck_id());
		
		game.setPlayerStanding(true);
		game.setPlayersTurn(false);
		
		GDAO.newGame(game);
		
		return game;
		
	}
	
	public Game doubleDown(GameDTO GDTO) {
		
		Game game = GDAO.getGame(GDTO.getDeck_id());
		
		int bet = game.getPlayerBet();
		bet = bet*2;
		game.setPlayerBet(bet);
		game.setPlayerHasDoubledDown(true);
		
		GDAO.newGame(game);
		
		return game;
		
	}
	
	public void endGame(String id) {
		//Delete a game from the table
		//Anything else we need to do at the end of the game can go in here
		GDAO.deleteGame(id);
	}
	
}