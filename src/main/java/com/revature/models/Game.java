package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GameSession")
public class Game {

	//Make this the primary key and serial
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "game_id")
	private int id;
	
	private int playerBet;
	private int playerChips;

	
	private ArrayList<String> playerHand = new ArrayList<String>();
	private int playerTotal;
	private ArrayList<String> dealerHand = new ArrayList<String>();
	private int dealerTotal;
	private boolean isPlayersTurn; //0-Player, 1-Dealer
	
	private int gameState; //0-Ongoing, 1-Player wins, 2-Player loses by busting, 3-Dealer has a higher total than player, 4-Push
	
	
	private void gameLoop() {
		//This method will run the game
		//Reference Jacob's doc to see the flow of the game
		//You'll need some default values for the game object like bet=0 and playerChips=their total
	}

	private boolean checkPlayersChips() {
		boolean checkPlayerChips = false;
		
		return checkPlayerChips;
	}
	
	//Add a card to players hand, adjust player total
	private void hitPlayer(String newCard) {
		//Pass in a new hand, check the value, and check if their adjusted hand value is under 21
		//Send the player to a loss/bust screen if above 21
		//Automatically stand if it equals 21
		playerHand.add(newCard);
		playerTotal = getHandValue(playerHand);
		
		
	}
	
	private void hitDealer(String newCard) {
		dealerHand.add(newCard);
	}
	
	private void stand() {
		isPlayersTurn = false;
	}
	
	private void bet(int bet) {
		//This method wasn't on the doc but it's necessary
		//Take an int passed from the front end and set the playerBet field equal to that, and store it in the db game table
		this.playerBet = bet;
	}
	
	private int getHandValue(ArrayList<String> hand) {
		int sum = 0;
		int aceCount = 0;
		
		for(String card : hand) {
			if (card.equals("KING")) {
				sum += 10;
			}
			if (card.equals("QUEEN")) {
				sum += 10;
			}
			if (card.equals("JACK")) {
				sum += 10;
			}
			if (card.equals("ACE")) {
				aceCount++;
				sum += 11;
			}
			else {
				sum += Integer.parseInt(card);
			}
		}
		
		//Decrease sum by 10 up to aceCount times while sum is greater than 21
		for (int i = aceCount; i > 0; i--) {
			if (sum > 21) {
				sum -=10;
			}
		}
		
		
		return sum;
	}
	
	
	private void doubleDown(String newCard) {
		//Players can double down after getting their first two cards
		//If they do then double their bet, make them hit once, and if they don't bust force them to stand
		if (playerHand.get(0).equals(playerHand.get(1))) {
			playerBet = 2*playerBet;
			hitPlayer(newCard);
			if (!isBust(playerTotal)) {
				stand();
			}
		}
	}
	
	private void split() {
		//This method is a stretch goal. Ignore it for now.
	}
/*	
	private boolean isSplitLegal() {
		boolean splitLegal = false;
		
		
		
		return splitLegal;
	}
	*/
	
	private boolean isBust(int value) {
		return (value > 21);
	}
	
	private boolean is21(int value) {
		return (value == 21);
	}
	
	
	
	//If the player and dealer both stand without busting check if their hands are equal
	private boolean isPush() { 
		return (playerTotal == dealerTotal);
	}
	
	
	private boolean isPlayerWinner() { //This method and the one above could probably be combined
		return ((playerTotal > dealerTotal) && playerTotal < 21);
	}
	
	//0-Ongoing, 1-Player wins, 2-Player loses by busting, 3-Dealer has a higher total than player, 4-Push
	
	private int endState() {
		
		if (playerTotal > 21) {
			return 2;
		}
		
		if (playerTotal == dealerTotal) {
			return 4;
		}
		
		if (dealerTotal > playerTotal) {
			return 3;
		}
		
		if (playerTotal > dealerTotal) {
			return  1;
		}
		
		return 0;
		
	}
	
	private void gameEnd() { 
		//Don't worry about this one for now Peter
		//Eventually this is gonna have all the logic for ending the game and starting a new one
	}

	
	
	
	
	
}
