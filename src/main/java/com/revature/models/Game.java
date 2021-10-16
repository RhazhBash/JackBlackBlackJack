package com.revature.models;

import java.util.Arrays;

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

	
	private String[] playerHand;
	private int playerTotal;
	private String[] dealerHand;
	private int dealerTotal;
	private boolean turn; //0-Player, 1-Dealer
	
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
	
	private void hit() {
		//Pass in a new hand, check the value, and check if their adjusted hand value is under 21
		//Send the player to a loss/bust screen if above 21
		//Automatically stand if it equals 21
	}
	
	private void stand() {
		//End the player's turn and start the dealer's turn
	}
	
	private void bet() {
		//This method wasn't on the doc but it's necessary
		//Take an int passed from the front end and set the playerBet field equal to that, and store it in the db game table
	}
	
	private int getHandValue(String[] hand) {
		int adjustedHandValue=0;
		//Take in the string array that represents a hand
		//Convert each string to a numerical value and add them
		//Count the number of aces
		//If no aces return the value of the hand
		//If the hand has aces, do this
		//Subtract 10 from the total, then check if the value is under 22
		//Repeat up to the number of aces in the hand or until a value under 22 is reached
		//Return the adjusted hand total
		return adjustedHandValue;
	}
	private void doubleDown() {
		//Players can double down after getting their first two cards
		//If they do then double their bet, make them hit once, and if they don't bust force them to stand
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
		if (value>21)
			return true;
		else
			return false;
	}
	
	private boolean is21(int value) {
		if (value==21)
			return true;
		else
			return false;
	}
	private boolean isPush() { //If the player and dealer both stand without busting check if their hands are equal
		boolean isPush = false;
		
		return isPush;
	}
	
	
	private boolean isPlayerWinner() { //This method and the one above could probably be combined
		boolean isPlayerWinner = false;
		
		return isPlayerWinner;
	}
	
	private void gameEnd() { 
		//Don't worry about this one for now Peter
		//Eventually this is gonna have all the logic for ending the game and starting a new one
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(dealerHand);
		result = prime * result + dealerTotal;
		result = prime * result + gameState;
		result = prime * result + id;
		result = prime * result + playerBet;
		result = prime * result + playerChips;
		result = prime * result + Arrays.hashCode(playerHand);
		result = prime * result + playerTotal;
		result = prime * result + (turn ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (!Arrays.equals(dealerHand, other.dealerHand))
			return false;
		if (dealerTotal != other.dealerTotal)
			return false;
		if (gameState != other.gameState)
			return false;
		if (id != other.id)
			return false;
		if (playerBet != other.playerBet)
			return false;
		if (playerChips != other.playerChips)
			return false;
		if (!Arrays.equals(playerHand, other.playerHand))
			return false;
		if (playerTotal != other.playerTotal)
			return false;
		if (turn != other.turn)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String[] getPlayerHand() {
		return playerHand;
	}

	public void setPlayerHand(String[] playerHand) {
		this.playerHand = playerHand;
	}

	public int getPlayerTotal() {
		return playerTotal;
	}

	public void setPlayerTotal(int playerTotal) {
		this.playerTotal = playerTotal;
	}

	public String[] getDealerHand() {
		return dealerHand;
	}

	public void setDealerHand(String[] dealerHand) {
		this.dealerHand = dealerHand;
	}

	public int getDealerTotal() {
		return dealerTotal;
	}

	public void setDealerTotal(int dealerTotal) {
		this.dealerTotal = dealerTotal;
	}

	public boolean isTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	public int getGameState() {
		return gameState;
	}

	public void setGameState(int gameState) {
		this.gameState = gameState;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", playerBet=" + playerBet + ", playerChips=" + playerChips + ", playerHand="
				+ Arrays.toString(playerHand) + ", playerTotal=" + playerTotal + ", dealerHand="
				+ Arrays.toString(dealerHand) + ", dealerTotal=" + dealerTotal + ", turn=" + turn + ", gameState="
				+ gameState + "]";
	}

	public Game(int id, int playerBet, int playerChips, String[] playerHand, int playerTotal, String[] dealerHand,
			int dealerTotal, boolean turn, int gameState) {
		super();
		this.id = id;
		this.playerBet = playerBet;
		this.playerChips = playerChips;
		this.playerHand = playerHand;
		this.playerTotal = playerTotal;
		this.dealerHand = dealerHand;
		this.dealerTotal = dealerTotal;
		this.turn = turn;
		this.gameState = gameState;
	}

	public Game(int playerBet, int playerChips, String[] playerHand, int playerTotal, String[] dealerHand,
			int dealerTotal, boolean turn, int gameState) {
		super();
		this.playerBet = playerBet;
		this.playerChips = playerChips;
		this.playerHand = playerHand;
		this.playerTotal = playerTotal;
		this.dealerHand = dealerHand;
		this.dealerTotal = dealerTotal;
		this.turn = turn;
		this.gameState = gameState;
	}

	public Game() {
		super();
	}

	

	

	
	
	
	
	
}
