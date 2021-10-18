package com.sist.exam07;

class Person{
	public String name="홍길동";
	public final String addr = "서울시 마포구 서교동";
}

public class FinalTest {
	public static void main(String[] args) {
		Person hong = new Person();
		System.out.println(hong.name);
		hong.name = "홍두식";
		//hong.addr = "제주도 서귀포시 애달읍";
		//클래스의 final은 상수이기 떄문에 값 변경 x
		
		System.out.println(hong.name);
		System.out.println(hong.addr);
		
	}
}
