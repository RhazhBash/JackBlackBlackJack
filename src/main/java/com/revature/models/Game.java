package com.revature.models;

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

	//Make this the primary key and serail
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "game_id")
	private int id;
	
	private int playerBet;

	
	private Hand playerHand;
	private Hand dealerHand;
	private boolean turn;
	
	
	private void gameLoop() {
		
	}

	private boolean checkPlayersChips() {
		boolean checkPlayerChips = false;
		
		return checkPlayerChips;
	}
	
	private void hit() {
		
	}
	
	private void stand() {
		
	}
	
	private void doubleDown() {
		
	}
	
	private void split() {
		
	}
	
	private boolean isSplitLegal() {
		boolean splitLegal = false;
		
		
		
		return splitLegal;
	}
	
	
	private boolean isPush() {
		boolean isPush = false;
		
		return isPush;
	}
	
	
	private boolean isPlayerWinner() {
		boolean isPlayerWinner = false;
		
		return isPlayerWinner;
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

	public Hand getPlayerHand() {
		return playerHand;
	}

	public void setPlayerHand(Hand playerHand) {
		this.playerHand = playerHand;
	}

	public Hand getDealerHand() {
		return dealerHand;
	}

	public void setDealerHand(Hand dealerHand) {
		this.dealerHand = dealerHand;
	}

	public boolean isTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dealerHand == null) ? 0 : dealerHand.hashCode());
		result = prime * result + id;
		result = prime * result + playerBet;
		result = prime * result + ((playerHand == null) ? 0 : playerHand.hashCode());
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
		if (dealerHand == null) {
			if (other.dealerHand != null)
				return false;
		} else if (!dealerHand.equals(other.dealerHand))
			return false;
		if (id != other.id)
			return false;
		if (playerBet != other.playerBet)
			return false;
		if (playerHand == null) {
			if (other.playerHand != null)
				return false;
		} else if (!playerHand.equals(other.playerHand))
			return false;
		if (turn != other.turn)
			return false;
		return true;
	}

	public Game() {
		super();
	}

	public Game(int id, int playerBet, Hand playerHand, Hand dealerHand, boolean turn) {
		super();
		this.id = id;
		this.playerBet = playerBet;
		this.playerHand = playerHand;
		this.dealerHand = dealerHand;
		this.turn = turn;
	}

	public Game(int playerBet, Hand playerHand, Hand dealerHand, boolean turn) {
		super();
		this.playerBet = playerBet;
		this.playerHand = playerHand;
		this.dealerHand = dealerHand;
		this.turn = turn;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", playerBet=" + playerBet + ", playerHand=" + playerHand + ", dealerHand="
				+ dealerHand + ", turn=" + turn + ", isPlayerWinner()=" + isPlayerWinner() + "]";
	}


	
	
	
	
	
}
