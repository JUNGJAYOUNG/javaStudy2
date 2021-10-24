package com.sist.exam02;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList();
		
		list.add("사과");
		list.add("수박");
		list.add("딸기");
		System.out.println(list);
		list.add("포도");
		list.add("사과");
		System.out.println(list); //ArrayList 중복 허용o
	}

}
