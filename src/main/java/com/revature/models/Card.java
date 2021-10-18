package com.revature.models;

public class Card {

    private String image, value, suit, code, deck_id;
    private int val;
   
	public void readVal(String card) {

		if (card.equals("KING")) {
			this.val = 10;
		}
		else if (card.equals("QUEEN")) {
			this.val = 10;
		}
		else if (card.equals("JACK")) {
			this.val =  10;
		}
		else if (card.equals("ACE")) {
			this.val = 11;
		} else {
			this.val = Integer.parseInt(card);
		}

	}
    
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDeck_id() {
		return deck_id;
	}
	public void setDeck_id(String deck_id) {
		this.deck_id = deck_id;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((deck_id == null) ? 0 : deck_id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		result = prime * result + val;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Card other = (Card) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (deck_id == null) {
			if (other.deck_id != null)
				return false;
		} else if (!deck_id.equals(other.deck_id))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (suit == null) {
			if (other.suit != null)
				return false;
		} else if (!suit.equals(other.suit))
			return false;
		if (val != other.val)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Card [code: " + code + " value=" + val + ", suit=" + suit + " Deck id: " + deck_id + "]";
	}

	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Card(String image, String value, String suit, String code) {
		super();
		this.image = image;
		this.value = value;
		this.suit = suit;
		this.code = code;
		this.deck_id = deck_id;
		//this.readVal(value);
	}
    
    
	
	
}
