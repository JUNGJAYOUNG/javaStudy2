package com.sist.exam03;

import java.util.ArrayList;

public class ArrayListTest {

	 public static void main(String[] args)
	 {
	  ArrayList list = new ArrayList(); //ArrayList 사용
	  
	  list.add(100);
	  list.add("hello");
	  list.add(5.7);
	  list.add(1,500); //1배열의 1번자리에 500을 넣겠다. hello자리가 밀려나고, 1번자리에 500 후에 hello
	  
	  System.out.println(list); //toString호출 (이것이 기본)
	  list.set(1,777); //1번자리를 777로 변경(500->777로)
	  System.out.println(list);
	  
	  list.remove(2); //2번째를 삭제 hello
	  System.out.println(list);
	  System.out.println(list.get(0)); //가장첫번째것을 알려달라. 100
	
	  list.clear(); //전체삭제
	  System.out.println(list); // [ ]
	 }
}


