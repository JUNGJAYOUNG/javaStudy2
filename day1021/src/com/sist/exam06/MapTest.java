package com.sist.exam06;

import java.util.ArrayList;
import java.util.HashMap;

public class MapTest {
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("서울");
		list.add("010-1234-1111");
		
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("이름", "홍길동");
		map.put("주소", "서울");
		map.put("전화", "010-1234-1111");
		
		System.out.println(list.get(1));
		System.out.println(map.get("주소"));
	}
}
