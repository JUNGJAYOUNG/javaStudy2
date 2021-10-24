package com.sist.exam05;

import java.util.ArrayList;

public class NestedList {
	public static void main(String[] args) {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> row1 = new ArrayList<String>();
		row1.add("홍길동");
		row1.add("서울");
		row1.add("010-1234-1111");
	
		ArrayList<String> row2 = new ArrayList<String>();
		row2.add("유관순");
		row2.add("인천");
		row2.add("010-1234-2222");
		
		ArrayList<String> row3 = new ArrayList<String>();
		row3.add("김유신");
		row3.add("제주");
		row3.add("010-1234-3333");
		
		list.add(row1);
		list.add(row2);
		list.add(row3);
		
		//list의 모든 내용을 출력한다.
		for(ArrayList<String> row :list) {
			System.out.println(row);
		}
		
		System.out.println("이름\t주소\t전화");
		for(ArrayList<String> row:list) {
			for(String data:row) {
				System.out.print(data+"\t");
			}
			System.out.println();
		}
	}
}
