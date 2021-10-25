package com.sist.exam03;
//excersize 7��
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<Double> list= new ArrayList<Double>();
		
		list.add(1.1);//list.add(new Double(3.4))
		list.add(2.2);//auto boxing
		list.add(3.3);
		list.add(4.4);
		
		for(int i=0;i<list.size();i++) {			//1�� for��
			System.out.print(list.get(i)+"\t");
		}
		
		System.out.println();
		
		for(double arr:list) {				//2�� for-each ��
			System.out.print(arr+"\t");
		}
		
		System.out.println();
		
		Iterator<Double> iter = list.iterator();	//3�� iterator���
		while(iter.hasNext()) {						//�迭 ��� ������ true, ������ false ��ȯ
			System.out.print(iter.next()+"\t");
		}
	}
}
