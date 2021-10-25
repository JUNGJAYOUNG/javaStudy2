package com.sist.game;

import java.util.Collections;

public class CardGame {
	public static void main(String[] args) {
		CardDeck deck = new CardDeck();	//덱 생성
		deck.shuffle();			//카드를 골고루 섞어준다.
		
		Player p1 = new Player();	//게임에 참가할 player를 두명 생성한다.
		Player p2 = new Player();
		
		p1.getCard(deck.deal());	//카드를 각자 한장씩만 분배
		p2.getCard(deck.deal());
	
		p1.showCards();	//각자 가진 카드 화면에 표시
		p2.showCards();
		
		if(p1.isOnePair() != 0) {
			System.out.println("player1은 원페어입니다." +p1.isOnePair());	
		}else {
			System.out.println("player1은 원페어가 아닙니다.");
		}
		
		if(p2.isOnePair() != 0) {
			System.out.println("player2은 원페어입니다." +p2.isOnePair());	
		}else {
			System.out.println("player2은 원페어가 아닙니다.");
		}
	
		
	}
}
