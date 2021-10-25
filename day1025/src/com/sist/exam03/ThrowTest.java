package com.sist.exam03;

public class ThrowTest {
	public static void main(String[] args) {
		int a = 4/0;
		
		//강제로 예외 발생시키기
		throw new ArithmeticException();
	}
}
