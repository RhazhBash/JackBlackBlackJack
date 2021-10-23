package com.revature.models;

import java.util.Arrays;

public class GameDTO {

	private String JWT;
	private int bet;
	private String deck_id;
	private Card[] playerHand;
	private Card[] dealerHand;
	
	
	
	public GameDTO(String JWT, int bet, String deck_id, Card[] playerHand, Card[] dealerHand) {
		super();
		this.JWT= JWT;
		this.bet = bet;
		this.deck_id = deck_id;
		this.playerHand = playerHand;
		this.dealerHand = dealerHand;
	}
	
	public GameDTO(String JWT, String deck_id, Card[] playerHand, Card[] dealerHand) {
		super();
		this.JWT = JWT;
		this.deck_id = deck_id;
		this.playerHand = playerHand;
		this.dealerHand = dealerHand;
	}
	
	public GameDTO(String JWT, String deck_id, Card[] Hand) {
		super();
		this.JWT = JWT;
		this.deck_id = deck_id;
		this.playerHand = Hand;
	}
	
	public GameDTO(String JWT, String deck_id) {
		super();
		this.JWT = JWT;
		this.deck_id = deck_id;
	}

	
	public GameDTO() {
		super();
	}

	@Override
	public String toString() {
		return "GameDTO [JWT=" + JWT + ", bet=" + bet + ", deck_id=" + deck_id + ", playerHand="
				+ Arrays.toString(playerHand) + ", dealerHand=" + Arrays.toString(dealerHand) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((JWT == null) ? 0 : JWT.hashCode());
		result = prime * result + bet;
		result = prime * result + Arrays.hashCode(dealerHand);
		result = prime * result + ((deck_id == null) ? 0 : deck_id.hashCode());
		result = prime * result + Arrays.hashCode(playerHand);
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
		GameDTO other = (GameDTO) obj;
		if (JWT == null) {
			if (other.JWT != null)
				return false;
		} else if (!JWT.equals(other.JWT))
			return false;
		if (bet != other.bet)
			return false;
		if (!Arrays.equals(dealerHand, other.dealerHand))
			return false;
		if (deck_id == null) {
			if (other.deck_id != null)
				return false;
		} else if (!deck_id.equals(other.deck_id))
			return false;
		if (!Arrays.equals(playerHand, other.playerHand))
			return false;
		return true;
	}

	public String getJWT() {
		return JWT;
	}

	public void setJWT(String jWT) {
		JWT = jWT;
	}

	public int getBet() {
		return bet;
	}

	public void setBet(int bet) {
		this.bet = bet;
	}

	public String getDeck_id() {
		return deck_id;
	}

	public void setDeck_id(String deck_id) {
		this.deck_id = deck_id;
	}

	public Card[] getPlayerHand() {
		return playerHand;
	}

	public void setPlayerHand(Card[] playerHand) {
		this.playerHand = playerHand;
	}

	public Card[] getDealerHand() {
		return dealerHand;
	}

	public void setDealerHand(Card[] dealerHand) {
		this.dealerHand = dealerHand;
	}

	
	
}