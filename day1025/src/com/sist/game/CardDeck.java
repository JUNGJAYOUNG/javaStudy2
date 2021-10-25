package com.sist.game;

import java.util.ArrayList;
import java.util.Collections;

//ī������� ���� 52���� ī�带 �׾Ƶΰ� ����ڰ� ī�带 �ϳ��� ���� �� �ִ� �޼ҵ带 ���� Ŭ����
public class CardDeck {
	//Card�� ���� �� �ִ� ArrayList ����
	private ArrayList<Card> deck = new ArrayList<Card>();

	//52���� ī�带 �����Ͽ� deck�� ��´�.
	public CardDeck() {
		String []suit = {"Clubs","Diamonds","Hearts","Speeds"};
		String []number = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		
		for(int i=0;i<suit.length;i++) {	//ī���縸ŭ �ݺ��� ����
			for(int j=0;j<number.length;j++) {	//ī����ڸ�ŭ �ݺ��� ����
				deck.add(new Card(suit[i],number[j]));
			}
		}
	}
		//ī�� ���� �޼ҵ�
		public void shuffle() {
			Collections.shuffle(deck);
		}
		//deck�� ó������(index 0) ī�带 �����Ͽ��� ��ȯ�ϴ� �޼ҵ�
		public Card deal() {
			return deck.remove(0);
		}
		//*ArrayList�� remove�޼ҵ�� �ε����� ��ġ�� �����͸� �����ϰ� ������ �����͸� ��ȯ�ϴ� �޼ҵ��̴�.
		
}
