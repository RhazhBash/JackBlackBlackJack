package com.revature.models;

import java.util.Arrays;

public class Hand {

	private String[] cards;
	private int totalValue;
	private int currentValue;
	
	
	//Reads over cards[] to calculate current value
	private int getCurrentValue() {
		int sum = 0;
		for(String card : cards) {
			if (card.equals("KING")) {
				sum += 10;
			} else if (card.equals("QUEEN")) {
				sum += 10;
			} else if (card.equals("ACE")) {
				sum += 11;
			} else if (card.equals("ace")) {
				sum += 1;
			} else
			sum += Integer.parseInt(card);
		}
		return sum;
	}
	
	private void setCurrentValue() {
		this.currentValue = getCurrentValue();
	}
	
	//If hand has any aces, sets them low until current value is below 21
	private void setAcesLow() {
		if (aceCount() > 0) {
			for (String card : cards) {
				if (card.equals("ACE")) {
					if (isBust()) {
					card = "ace";
					}
				}
			}
		}
	}
	
	private boolean isBust() {
		return (getCurrentValue() > 21);
	}
	private boolean isOverSixteen() {
		return (getCurrentValue() > 16);
	}

	private int aceCount() {
		int aceCount = 0;
		for (String isAce : cards) {
			if (isAce.equals("ACE"))
			aceCount++;
		}
		return aceCount;
	}
	
	
	public Hand() {
		super();
		cards = null;
		totalValue = 0;
		currentValue = 0;
		// TODO Auto-generated constructor stub
	}

	public Hand(String[] cards, int totalValue, int currentValue) {
		super();
		this.cards = cards;
		this.totalValue = totalValue;
		this.currentValue = currentValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(cards);
		result = prime * result + currentValue;
		result = prime * result + totalValue;
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
		Hand other = (Hand) obj;
		if (!Arrays.equals(cards, other.cards))
			return false;
		if (currentValue != other.currentValue)
			return false;
		if (totalValue != other.totalValue)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Hand [cards=" + Arrays.toString(cards) + ", totalValue=" + totalValue + ", currentValue=" + currentValue
				+ "]";
	}
	
	
	
	
	
}
