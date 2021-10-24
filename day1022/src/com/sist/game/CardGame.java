package com.sist.game;

import java.util.Collections;

public class CardGame {
	public static void main(String[] args) {
		CardDeck deck = new CardDeck();
		
		//카드를 골고루 섞어준다.
		deck.shuffle();
		
		//카드게임을 할 경기자를 두명 생성한다.
		Player p1 = new Player();
		Player p2 = new Player();
		
		//첫번째 사람이 카드를 하나 뽑아옵니다.
		p1.getCard(deck.deal());
		
		//두번째 사람도 카드를 0HWf62하나 뽑아온다.
		p2.getCard(deck.deal());
		
		//첫번재 사람이 자신의 모든 카드를 출력한다.
		p1.showCards();
		
		//두번째 사람도 자신의 모든 카드 출력
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
