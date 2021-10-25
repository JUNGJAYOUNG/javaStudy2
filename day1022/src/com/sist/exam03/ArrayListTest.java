package com.sist.exam03;
//excersize 7번
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<Double> list= new ArrayList<Double>();
		
		list.add(1.1);//list.add(new Double(3.4))
		list.add(2.2);//auto boxing
		list.add(3.3);
		list.add(4.4);
		
		for(int i=0;i<list.size();i++) {			//1번 for문
			System.out.print(list.get(i)+"\t");
		}
		
		System.out.println();
		
		for(double arr:list) {				//2번 for-each 문
			System.out.print(arr+"\t");
		}
		
		System.out.println();
		
		Iterator<Double> iter = list.iterator();	//3번 iterator사용
		while(iter.hasNext()) {						//배열 요소 있으면 true, 없으면 false 반환
			System.out.print(iter.next()+"\t");
		}
	}
}
