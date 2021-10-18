package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GameSession")
public class Game {

	//Game fields
	@Id
	@Column(name = "game_id")
	private String id;
	
	private int gameState; //0-Ongoing, 1-Player wins, 2-Player loses by busting, 3-Dealer has a higher total than player, 4-Push
	private boolean isPlayersTurn; //1-Player, 0-Dealer
	private boolean gameIsPush;
	
	
	//Player fields
	private int playerBet;
	private int playerChips;
	private int playerTotal;
	private boolean playerIsStanding;
	private boolean playerIsBust;
	private boolean playerWinning;
	private ArrayList<String> playerHand = new ArrayList<String>();
	
	
	//Dealer fields
	private int dealerTotal;
	private boolean dealerIsBust;
	private boolean dealerIsStanding;
	private ArrayList<String> dealerHand = new ArrayList<String>();
	
	
	

	
	
	//GAME LOGIC
	
	//returns the value of a hand adjusted for aces
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

	private void gameLoop() {
		//This method will run the game
		//Reference Jacob's doc to see the flow of the game
		//You'll need some default values for the game object like bet=0 and playerChips=their total
	}

	private boolean checkPlayersChips() {
		boolean checkPlayerChips = false;
		
		return checkPlayerChips;
	}
	
	//Double players bet if their first two cards match, then hit and force stand if they don't bust
	private void doubleDown(String newCard) {
		if (playerHand.get(0).equals(playerHand.get(1))) {
			playerBet = 2*playerBet;
			hitPlayer(newCard);
			if (!isPlayerBust()) {
				playerIsStanding = true;
			}
		}
	}
	
	//If the player and dealer both stand without busting check if their hands are equal
	private boolean isGamePush() { 
		if (playerIsStanding && dealerIsStanding) {
			gameIsPush = (playerTotal == dealerTotal);
		}
		return gameIsPush;
		
	}
	
	private boolean isPlayerWinning() {
		playerWinning = false;
		if ( (playerTotal > dealerTotal) && 
			(!isPlayerBust() )) {
			playerWinning = true;
		}
		return playerWinning;
	}
	
	//Check if player has higher score and isn't over 21
	private boolean isPlayerWinner() { 
		return ((playerTotal > dealerTotal) && playerTotal < 22);
	}
	
	//0-Ongoing, 1-Player wins, 2-Player loses by busting, 3-Dealer has a higher total than player, 4-Push
	
	private int gameState() {
		
		if (isPlayerBust()) {
			return 2;
		}
		
		if (isGamePush() ){
			return 4;
		}
		
		if ((dealerTotal > playerTotal) && playerIsStanding) {
			return 3;
		}
		
		if (isPlayerWinning() && isDealerStanding()) {
			return  1;
		}
		
		return 0;
		
	}
	
	
	//PLAYER LOGIC
	
	//Add a card to players hand, adjust player total
	private void hitPlayer(String newCard) {
		playerHand.add(newCard);
		playerTotal = getHandValue(playerHand);
	}
	
	//End players turn
	private boolean isPlayerStanding(boolean input) {
		playerIsStanding = input;
		return playerIsStanding;
	}
	
	//Set betting amount
	private void bet(int bet) {
		this.playerBet = bet;
	}
	
	private boolean isPlayerBust() {
		playerIsBust = (playerTotal > 21);
		return playerIsBust;
	}

	private boolean isPlayer21() {
		return (playerTotal == 21);
	}
	
	
	
	
	
	
	//DEALER LOGIC
	private void hitDealer(String newCard) {
		dealerHand.add(newCard);
		dealerTotal = getHandValue(dealerHand);
	}
	
	private boolean dealerIsBust() {
		dealerIsBust = (dealerTotal > 21);
		return dealerIsBust;
	}
	
	private boolean isDealer21() {
		return (dealerTotal == 21);
	}
	
	private boolean dealerStand() {
		dealerIsStanding = true;
		return dealerIsStanding;
	}
	
	private boolean isDealerStanding() {
		dealerIsStanding = false;
		if (dealerTotal > 16) {
			dealerIsStanding = true;
		}
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

	public boolean isPlayerIsStanding() {
		return playerIsStanding;
	}

	public void setPlayerIsStanding(boolean playerIsStanding) {
		this.playerIsStanding = playerIsStanding;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dealerHand == null) ? 0 : dealerHand.hashCode());
		result = prime * result + (dealerIsBust ? 1231 : 1237);
		result = prime * result + (dealerIsStanding ? 1231 : 1237);
		result = prime * result + dealerTotal;
		result = prime * result + (gameIsPush ? 1231 : 1237);
		result = prime * result + gameState;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isPlayersTurn ? 1231 : 1237);
		result = prime * result + playerBet;
		result = prime * result + playerChips;
		result = prime * result + ((playerHand == null) ? 0 : playerHand.hashCode());
		result = prime * result + (playerIsBust ? 1231 : 1237);
		result = prime * result + (playerIsStanding ? 1231 : 1237);
		result = prime * result + playerTotal;
		result = prime * result + (playerWinning ? 1231 : 1237);
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
		if (dealerHand == null) {
			if (other.dealerHand != null)
				return false;
		} else if (!dealerHand.equals(other.dealerHand))
			return false;
		if (dealerIsBust != other.dealerIsBust)
			return false;
		if (dealerIsStanding != other.dealerIsStanding)
			return false;
		if (dealerTotal != other.dealerTotal)
			return false;
		if (gameIsPush != other.gameIsPush)
			return false;
		if (gameState != other.gameState)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isPlayersTurn != other.isPlayersTurn)
			return false;
		if (playerBet != other.playerBet)
			return false;
		if (playerChips != other.playerChips)
			return false;
		if (playerHand == null) {
			if (other.playerHand != null)
				return false;
		} else if (!playerHand.equals(other.playerHand))
			return false;
		if (playerIsBust != other.playerIsBust)
			return false;
		if (playerIsStanding != other.playerIsStanding)
			return false;
		if (playerTotal != other.playerTotal)
			return false;
		if (playerWinning != other.playerWinning)
			return false;
		return true;
	}

	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", gameState=" + gameState + ", isPlayersTurn=" + isPlayersTurn + ", gameIsPush="
				+ gameIsPush + ", playerBet=" + playerBet + ", playerChips=" + playerChips + ", playerTotal="
				+ playerTotal + ", playerIsStanding=" + playerIsStanding + ", playerIsBust=" + playerIsBust
				+ ", playerWinning=" + playerWinning + ", playerHand=" + playerHand + ", dealerTotal=" + dealerTotal
				+ ", dealerIsBust=" + dealerIsBust + ", dealerIsStanding=" + dealerIsStanding + ", dealerHand="
				+ dealerHand + "]";
	}

	
	
	
	
}
