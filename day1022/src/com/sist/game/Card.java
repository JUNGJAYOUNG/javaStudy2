package com.sist.game;

public class Card {	//하나의 카드는 무늬와 숫자를 가지고 있어야 한다.
	private String suit;	//무늬
	private String number;	//숫자
	
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
