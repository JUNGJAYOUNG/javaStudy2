package com.sist.game;
import java.util.ArrayList;
import java.util.HashMap;

public class Player {

	//Player�� ī���� ����Ʈ�� ���� �־�� �Ѵ�.
	private ArrayList<Card> list = new ArrayList<Card>();
	
	//Player�� ī�带 �� �ڽ��� ����Ʈ�� �߰�
	public void getCard(Card card) {
		list.add(card);
	}
	//Player�� ī�带 ��� ���
	public void showCards() {
		System.out.println(list);
	}
		
	public int isOnePair() {
		String []number = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int value = 2;
		for(int i=0;i<number.length;i++) {	//ī���� ���� �迭��ŭ �ݺ�����
			map.put(number[i], value++);	//map�� key�� ī���� ���ڷ�, value�� 2���� 1�� ������ ������ �Ѵ�.
		}
		
		int n = 0;
		for(int i=0;i<list.size();i++) {
			for(int j=i+1;j<list.size();j++) {
				//i��° ī���� ���ڿ� j��° ī���� ���ڰ� �������� �Ǻ�
				if(list.get(i).getNumber().equals(list.get(j).getNumber())) {
					n= map.get(list.get(i).getNumber());
					return n;
				}
			}
		}
		return n;
	}
}
