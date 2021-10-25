package com.sist.game;

import java.util.Collections;

public class CardGame02 {
	public static void main(String[] args) {
		CardDeck deck = new CardDeck();
		
		//ī�带 ���� �����ش�.
		deck.shuffle();
		
		//ī������� �� ����ڸ� �θ� �����Ѵ�.
		Player p1 = new Player();
		Player p2 = new Player();
		
		//�� ���� ����ڰ� ī�带 7�徿 �̾ƿ����� �Ѵ�.
		for(int i=1;i<=7;i++) {
			p1.getCard(deck.deal());
			p2.getCard(deck.deal());	
		}
		
		//ù���� ����� �ڽ��� ��� ī�带 ����Ѵ�.
		p1.showCards();
		
		//�ι�° ����� �ڽ��� ��� ī�� ���
		p2.showCards();
		
		int n1 = p1.pairProcess();
		int n2 = p2.pairProcess();
		
		if(n1 == n2) {
			System.out.println("�����ϴ�.");
		}else if(n1 >n2) {
			System.out.println("�÷��̾�1�� �̰���ϴ�.");
		}else {
			System.out.println("�÷��̾�2�� �̰���ϴ�.");
		}
	}
}
