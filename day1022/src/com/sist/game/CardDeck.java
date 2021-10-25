package com.sist.game;

import java.util.ArrayList;
import java.util.Collections;

//카드게임을 위한 52장의 카드를 쌓아두고 경기자가 카드를 하나씩 뽑을 수 있는 메소드를 갖는 클래스
public class CardDeck {
	//Card를 담을 수 있는 ArrayList 생성
	private ArrayList<Card> deck = new ArrayList<Card>();

	//52개의 카드를 생성하여 deck에 담는다.
	public CardDeck() {
		String []suit = {"Clubs","Diamonds","Hearts","Speeds"};
		String []number = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		
		for(int i=0;i<suit.length;i++) {	//카드모양만큼 반복문 돌기
			for(int j=0;j<number.length;j++) {	//카드숫자만큼 반복문 돌기
				deck.add(new Card(suit[i],number[j]));
			}
		}
	}
		//카드 섞는 메소드
		public void shuffle() {
			Collections.shuffle(deck);
		}
		//deck의 처음에서(index 0) 카드를 제거하여서 반환하는 메소드
		public Card deal() {
			return deck.remove(0);
		}
		//*ArrayList의 remove메소드는 인덱스에 위치한 데이터를 제거하고 제거한 데이터를 반환하는 메소드이다.
		
}
