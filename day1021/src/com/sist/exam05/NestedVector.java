package com.sist.exam05;

import java.util.ArrayList;
import java.util.Vector;

public class NestedVector {
	public static void main(String[] args) {
		Vector<Vector<String>> list = new Vector<Vector<String>>();
		
		Vector<String> row1 = new Vector<String>();
		row1.add("홍길동");
		row1.add("서울");
		row1.add("010-1234-1111");
	
		Vector<String> row2 = new Vector<String>();
		row2.add("유관순");
		row2.add("인천");
		row2.add("010-1234-2222");
		
		Vector<String> row3 = new Vector<String>();
		row3.add("김유신");
		row3.add("제주");
		row3.add("010-1234-3333");
		
		list.add(row1);
		list.add(row2);
		list.add(row3);
		
		//list의 모든 내용을 출력한다.
		for(Vector<String> row :list) {
			System.out.println(row);
		}
		
		System.out.println("이름\t주소\t전화");
		for(Vector<String> row:list) {
			for(String data:row) {
				System.out.print(data+"\t");
			}
			System.out.println();
		}
	}
}
