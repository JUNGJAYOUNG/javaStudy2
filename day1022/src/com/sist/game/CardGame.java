package com.sist.game;

import java.util.Collections;

public class CardGame {
	public static void main(String[] args) {
		CardDeck deck = new CardDeck();
		
		//ī�带 ���� �����ش�.
		deck.shuffle();
		
		//ī������� �� ����ڸ� �θ� �����Ѵ�.
		Player p1 = new Player();
		Player p2 = new Player();
		
		//ù��° ����� ī�带 �ϳ� �̾ƿɴϴ�.
		p1.getCard(deck.deal());
		
		//�ι�° ����� ī�带 0HWf62�ϳ� �̾ƿ´�.
		p2.getCard(deck.deal());
		
		//ù���� ����� �ڽ��� ��� ī�带 ����Ѵ�.
		p1.showCards();
		
		//�ι�° ����� �ڽ��� ��� ī�� ���
		p2.showCards();
		
		if(p1.isOnePair() != 0) {
			System.out.println("player1�� ������Դϴ�." +p1.isOnePair());	
		}else {
			System.out.println("player1�� ���� �ƴմϴ�.");
		}
		
		if(p2.isOnePair() != 0) {
			System.out.println("player2�� ������Դϴ�." +p2.isOnePair());	
		}else {
			System.out.println("player2�� ���� �ƴմϴ�.");
		}
	
		
	}
}
