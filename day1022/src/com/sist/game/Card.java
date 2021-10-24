package com.sist.game;

public class Card {
	private String suit;	//카드모양
	private String number;	//카드숫자
	
	public Card(String suit, String number) {
		super();
		this.suit = suit;
		this.number = number;
	}
	
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "[" + suit + ","+ number + "]";
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}	
	
	
}
