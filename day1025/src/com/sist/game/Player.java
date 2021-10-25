package com.sist.game;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class Player {
	//카드의 숫자를 map key로
	String []number = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
	
	//map 생성
	HashMap<String, Integer> map = new HashMap<String, Integer>();	

	public TreeSet<Integer> pairList = new TreeSet<Integer>();
	//쌍을 이루는 카드목록을 담아 놓기 위한 리스트를 생성
	
	//Player도 카드의 리스트를 갖고 있어야 한다.
	private ArrayList<Card> list = new ArrayList<Card>();
	
	public Player() {
		int value=2;
		
		for(int i=0;i<list.size();i++) {
			
		}
	}

	//Player가 카드를 얻어서 자신의 리스트에 추가
	public void getCard(Card card) {
		list.add(card);
	}
	
	public int pairProcess() {
		
		int value = 2;
		
		for(int i=0;i<number.length;i++) {	//카드의 숫자 배열만큼 반복실행
			map.put(number[i], value++);	//map에 key는 카드의 숫자로, value는 2부터 1씩 증가한 값으로 한다.
		}
		
		int n = 0;
		for(int i=0;i<list.size();i++) {
			for(int j=i+1;j<list.size();j++) {
				//i번째 카드의 숫자와 j번째 카드의 숫자가 동일한지 판별
				if(list.get(i).getNumber().equals(list.get(j).getNumber())) {
					n= map.get(list.get(i).getNumber());
					pairList.add(n);
				}
			}
		}
		System.out.println(pairList);
		
		
		Iterator<Integer> iter = pairList.iterator();
		
		//pairList가 3개일때 큰값 두개만 뽑아오기
		if(pairList.size()==3) {
			System.out.println("투페어입니다.");
			iter.next();
			n = iter.next()+iter.next();
		}else if(pairList.size() ==2) {
			System.out.println("투페어입니다.");
			n = iter.next()+iter.next();
		}else if(pairList.size()==1) {
			System.out.println("원페어입니다.");
			n=iter.next();
		}
		return n;
	}
		
	//Player의 카드를 모두 출력
	public void showCards() {
		System.out.println(list);
	}
		
	public int isOnePair() {
		String []number = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int value = 2;
		for(int i=0;i<number.length;i++) {	//카드의 숫자 배열만큼 반복실행
			map.put(number[i], value++);	//map에 key는 카드의 숫자로, value는 2부터 1씩 증가한 값으로 한다.
		}
		
		int n = 0;
		for(int i=0;i<list.size();i++) {
			for(int j=i+1;j<list.size();j++) {
				//i번째 카드의 숫자와 j번째 카드의 숫자가 동일한지 판별
				if(list.get(i).getNumber().equals(list.get(j).getNumber())) {
					n= map.get(list.get(i).getNumber());
					return n;
				}
			}
		}
		return n;
	}
}
