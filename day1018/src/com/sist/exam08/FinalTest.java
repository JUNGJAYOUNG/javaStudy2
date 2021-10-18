package com.sist.exam08;

class Person{
	public String name="홍길동";
	public static final String addr = "서울시 마포구 서교동";
	
	//바꾸지도 못하는 final은 굳이 객체마다 따로 메모리를 확보할 필요가 없다.
	//그래서 final멤버는 static으로 만드는 것이 좋다.
	
	//final은 static으로 만들어요! o
	//static은 final로 만들어요! x
}

public class FinalTest {
	public static void main(String[] args) {
		System.out.println(Person.addr);
		
		Person father = new Person();
		Person son = new Person();
		
		father.name = "홍길동";
		son.name = "홍두식";
		
		System.out.println(father.name +","+father.addr);
		System.out.println(son.name +","+son.addr);
		
		//father.addr = "제주도 서귀포시 애월읍";
		
	}
}
