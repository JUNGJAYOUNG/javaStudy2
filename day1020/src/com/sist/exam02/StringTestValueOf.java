package com.sist.exam02;

public class StringTestValueOf {

	public static void pro(String str) {
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int data = 2021;
		
		//정수형 데이터 data를 갖고 pro를 호출해야하는 상황
		pro(String.valueOf(data)); //data를 String형으로 만들어준다
		pro(data+"");
	}

}
