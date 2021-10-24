package com.sist.exam02;
import java.util.*;

public class LinkedHashSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashSet set = new LinkedHashSet();
		set.add("사과");
		set.add("수박");
		set.add("딸기");
		System.out.println(set);
		set.add("바나나");	//LinkedHashSet은 순서 유지하기 때문에 추가한 그대로 출력됨
		set.add("사과");		//set은 중복을 허용하지 않기 때문에 추가 안된다.
		System.out.println(set);
	}

}
