package com.sist.game;

import java.util.Collections;

public class CardGame {
	public static void main(String[] args) {
		CardDeck deck = new CardDeck();	//�� ����
		deck.shuffle();			//ī�带 ���� �����ش�.
		
		Player p1 = new Player();	//���ӿ� ������ player�� �θ� �����Ѵ�.
		Player p2 = new Player();
		
		p1.getCard(deck.deal());	//ī�带 ���� ���徿�� �й�
		p2.getCard(deck.deal());
	
		p1.showCards();	//���� ���� ī�� ȭ�鿡 ǥ��
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
