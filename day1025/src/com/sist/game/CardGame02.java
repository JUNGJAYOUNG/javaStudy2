package com.sist.game;

import java.util.Collections;

public class CardGame02 {
	public static void main(String[] args) {
		CardDeck deck = new CardDeck();
		
		//카드를 골고루 섞어준다.
		deck.shuffle();
		
		//카드게임을 할 경기자를 두명 생성한다.
		Player p1 = new Player();
		Player p2 = new Player();
		
		//두 명의 경기자가 카드를 7장씩 뽑아오도록 한다.
		for(int i=1;i<=7;i++) {
			p1.getCard(deck.deal());
			p2.getCard(deck.deal());	
		}
		
		//첫번재 사람이 자신의 모든 카드를 출력한다.
		p1.showCards();
		
		//두번째 사람도 자신의 모든 카드 출력
		p2.showCards();
		
		int n1 = p1.pairProcess();
		int n2 = p2.pairProcess();
		
		if(n1 == n2) {
			System.out.println("비겼습니다.");
		}else if(n1 >n2) {
			System.out.println("플레이어1이 이겼습니다.");
		}else {
			System.out.println("플레이어2가 이겼습니다.");
		}
	}
}
