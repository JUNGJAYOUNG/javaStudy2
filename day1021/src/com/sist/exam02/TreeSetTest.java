package com.sist.exam02;
import java.util.*;

public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet set = new TreeSet();
		
		set.add("사과");
		set.add("수박");
		set.add("딸기");
		System.out.println(set);
		set.add("바나나");	
		set.add("사과");		
		set.add("귤");		
		set.add("감");		
		System.out.println(set);	//TreeSet 데이터 정렬해줌(중복x)
		System.out.println(set.size());
		
		set.remove("딸기");
		System.out.println(set);
		System.out.println(set.size());
	}
}
