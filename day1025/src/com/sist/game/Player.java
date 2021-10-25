package com.sist.game;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class Player {
	//ī���� ���ڸ� map key��
	String []number = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
	
	//map ����
	HashMap<String, Integer> map = new HashMap<String, Integer>();	

	public TreeSet<Integer> pairList = new TreeSet<Integer>();
	//���� �̷�� ī������ ��� ���� ���� ����Ʈ�� ����
	
	//Player�� ī���� ����Ʈ�� ���� �־�� �Ѵ�.
	private ArrayList<Card> list = new ArrayList<Card>();
	
	public Player() {
		int value=2;
		
		for(int i=0;i<list.size();i++) {
			
		}
	}

	//Player�� ī�带 �� �ڽ��� ����Ʈ�� �߰�
	public void getCard(Card card) {
		list.add(card);
	}
	
	public int pairProcess() {
		
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
					pairList.add(n);
				}
			}
		}
		System.out.println(pairList);
		
		
		Iterator<Integer> iter = pairList.iterator();
		
		//pairList�� 3���϶� ū�� �ΰ��� �̾ƿ���
		if(pairList.size()==3) {
			System.out.println("������Դϴ�.");
			iter.next();
			n = iter.next()+iter.next();
		}else if(pairList.size() ==2) {
			System.out.println("������Դϴ�.");
			n = iter.next()+iter.next();
		}else if(pairList.size()==1) {
			System.out.println("������Դϴ�.");
			n=iter.next();
		}
		return n;
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
