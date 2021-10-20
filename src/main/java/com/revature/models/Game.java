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
@Table(name = "gamesession")
public class Game {

	//Game fields
	@Id
	@Column(name = "game_id")
	private String id;
	
	private int gameState; //0-Ongoing, 1-Player wins, 2-Player loses by busting, 3-Dealer has a higher total than player, 4-Push
	private boolean isPlayersTurn; //1-Player, 0-Dealer
	private boolean gameIsPush;
	private boolean gameIsConcluded;
	private boolean playerHasWon;
	
	//Player fields
	private int playerBet;
	private int playerChips;
	private int playerTotal;
	public boolean playerCanDoubleDown;
	public boolean playerHasDoubledDown;
	public boolean playerHasBlackJack;
	private boolean isPlayerStanding;
	private boolean playerIsBust;
	private boolean playerWinning;
	private ArrayList<String> playerHand = new ArrayList<String>();
	
	
	//Dealer fields
	private int dealerTotal;
	private boolean dealerIsBust;
	private boolean dealerIsStanding;
	private ArrayList<String> dealerHand = new ArrayList<String>();
	
	

	
	
	//GAME LOGIC
	
	//If hasPlayerWon() add bet amount to chips and return positive/playerBet, else return 0
	public int payOut() {
		if (hasPlayerWon()) {
			playerChips += playerBet;
			return playerBet;
		}
		return 0;
	}
	
	//returns the value of a hand adjusted for aces
	private int getHandValue(ArrayList<String> hand) {
		if (hand.isEmpty()) {
			return 0;
		}
		
		int sum = 0;
		int aceCount = 0;
		
		for(String card : hand) {
			if (card.equals("KING")) {
				sum += 10;
			}
			else if (card.equals("QUEEN")) {
				sum += 10;
			}
			else if (card.equals("JACK")) {
				sum += 10;
			}
			else if (card.equals("ACE")) {
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
	
	//Game has concluded, player hasn't busted, game isn't push, player has higher score or dealer busted
	public boolean hasPlayerWon() {
		playerHasWon = 
				((isGameConcluded()) &&
				(!isPlayerBust())    &&
				(!isGamePush())	     &&
				(isPlayerWinning())  );
		
//		System.out.println("IsGameConcluded: " + isGameConcluded() + 
//						   " !isPlayerBust: " + !isPlayerBust() +
//						   " !isGamePush: " + !isGamePush() +
//						   " isPlayerWinning: " + isPlayerWinning());
		return playerHasWon;
	}
	
	public boolean isGameConcluded() {
		return (isDealerBust() ||
				isPlayerBust() ||
				isPlayerStanding() );
	}
	
	//Double players bet if their first two cards match, and they have the chips to cover it
	public boolean playerCanDoubleDown() {
		playerCanDoubleDown = (playerHand.size() > 1 &&
							   playerHand.get(0).equals(playerHand.get(1)) &&
							   (playerChips >= playerBet) &&
							   !playerHasDoubledDown);
		return playerCanDoubleDown;
	}
	
	//Double bet, hit, and force stand 
	public void doubleDown(String newCard) {
		if (playerCanDoubleDown()) {
			playerBet = 2*playerBet;
			hitPlayer(newCard);
			isPlayerStanding = true;
			playerHasDoubledDown = true;
		}
		
	}
	
	//If the player and dealer both stand without busting check if their hands are equal
	public boolean isGamePush() { 
		if (isPlayerStanding && dealerIsStanding) {
			gameIsPush = (playerTotal == dealerTotal);
		}
		return gameIsPush;
		
	}
	
	//checks if player has higher score and isn't bust, or if dealer has busted and player hasn't
	public boolean isPlayerWinning() {
		playerWinning = false;
		if ( (playerTotal > dealerTotal) && 
			(!isPlayerBust() )) {
			playerWinning = true;
		}
		if (isDealerBust() && 
			!isPlayerBust()) {
			playerWinning = true;
		}
		return playerWinning;
	}
	
	//0-Ongoing, 1-Player wins, 2-Player loses by busting, 3-Dealer has a higher total than player, 4-Push
	
	private int gameState() {
		
		if (isPlayerBust()) {
			return 2;
		}
		
		if (isGamePush() ){
			return 4;
		}
		
		if ((dealerTotal > playerTotal) && isPlayerStanding && (!isDealerBust())) {
			return 3;
		}
		
		if (isPlayerWinning() && isDealerStanding()) {
			return  1;
		}
		
		return 0;
		
	}
	
	
	//PLAYER LOGIC
	
	//Add a card to players hand, adjust player total
	public void hitPlayer(String newCard) {
		playerHand.add(newCard);
		playerTotal = getHandValue(playerHand);
		isPlayerBust();
	}
	
	//End players turn
	public void stand() {
		isPlayerStanding = true;
	}

	//Set betting amount
	private void bet(int bet) {
		this.playerBet = bet;
	}
	
	private boolean isPlayerBust() {
		playerIsBust = (playerTotal > 21);
		return playerIsBust;
	}

	public boolean playerHasBlackJack() {
		playerHasBlackJack = (playerTotal == 21);
		return playerHasBlackJack;
	}
	
	
	
	
	
	//DEALER LOGIC

	public void hitDealer(String newCard) {
		dealerHand.add(newCard);
		dealerTotal = getHandValue(dealerHand);
		isDealerStanding();
		isDealerBust();
		
	}
	
	private boolean isDealerBust() {
		dealerIsBust = (dealerTotal > 21);
		return dealerIsBust;
	}
	
	private boolean isDealer21() {
		return (dealerTotal == 21);
	}
	
	private boolean isDealerStanding() {
		dealerIsStanding = (dealerTotal > 16);
		System.out.println("dealer total: " + dealerTotal);
		return dealerIsStanding;
	}

	private void gameEnd() { 
		//Don't worry about this one for now Peter
		//Eventually this is gonna have all the logic for ending the game and starting a new one
	}



	
	
	
	
	
	
	
	
	
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getGameState() {
		return gameState;
	}

	public void setGameState(int gameState) {
		this.gameState = gameState;
	}

	public boolean isPlayersTurn() {
		return isPlayersTurn;
	}

	public void setPlayersTurn(boolean isPlayersTurn) {
		this.isPlayersTurn = isPlayersTurn;
	}

	public boolean isGameIsPush() {
		return gameIsPush;
	}

	public void setGameIsPush(boolean gameIsPush) {
		this.gameIsPush = gameIsPush;
	}

	public boolean isGameIsConcluded() {
		return gameIsConcluded;
	}

	public void setGameIsConcluded(boolean gameIsConcluded) {
		this.gameIsConcluded = gameIsConcluded;
	}

	public boolean isPlayerHasWon() {
		return playerHasWon;
	}

	public void setPlayerHasWon(boolean playerHasWon) {
		this.playerHasWon = playerHasWon;
	}

	public int getPlayerBet() {
		return playerBet;
	}

	public void setPlayerBet(int playerBet) {
		this.playerBet = playerBet;
	}

	public int getPlayerChips() {
		return playerChips;
	}

	public void setPlayerChips(int playerChips) {
		this.playerChips = playerChips;
	}

	public int getPlayerTotal() {
		return playerTotal;
	}

	public void setPlayerTotal(int playerTotal) {
		this.playerTotal = playerTotal;
	}

	public boolean isPlayerCanDoubleDown() {
		return playerCanDoubleDown;
	}

	public void setPlayerCanDoubleDown(boolean playerCanDoubleDown) {
		this.playerCanDoubleDown = playerCanDoubleDown;
	}

	public boolean isPlayerHasDoubledDown() {
		return playerHasDoubledDown;
	}

	public void setPlayerHasDoubledDown(boolean playerHasDoubledDown) {
		this.playerHasDoubledDown = playerHasDoubledDown;
	}

	public boolean isPlayerHasBlackJack() {
		return playerHasBlackJack;
	}

	public void setPlayerHasBlackJack(boolean playerHasBlackJack) {
		this.playerHasBlackJack = playerHasBlackJack;
	}

	public boolean isPlayerStanding() {
		return isPlayerStanding;
	}

	public void setPlayerStanding(boolean isPlayerStanding) {
		this.isPlayerStanding = isPlayerStanding;
	}

	public boolean isPlayerIsBust() {
		return playerIsBust;
	}

	public void setPlayerIsBust(boolean playerIsBust) {
		this.playerIsBust = playerIsBust;
	}

	public ArrayList<String> getPlayerHand() {
		return playerHand;
	}

	public void setPlayerHand(ArrayList<String> playerHand) {
		this.playerHand = playerHand;
	}

	public int getDealerTotal() {
		return dealerTotal;
	}

	public void setDealerTotal(int dealerTotal) {
		this.dealerTotal = dealerTotal;
	}

	public boolean isDealerIsBust() {
		return dealerIsBust;
	}

	public void setDealerIsBust(boolean dealerIsBust) {
		this.dealerIsBust = dealerIsBust;
	}

	public boolean isDealerIsStanding() {
		return dealerIsStanding;
	}

	public void setDealerIsStanding(boolean dealerIsStanding) {
		this.dealerIsStanding = dealerIsStanding;
	}

	public ArrayList<String> getDealerHand() {
		return dealerHand;
	}

	public void setDealerHand(ArrayList<String> dealerHand) {
		this.dealerHand = dealerHand;
	}

	public void setPlayerWinning(boolean playerWinning) {
		this.playerWinning = playerWinning;
	}


	
	
	
	
}
