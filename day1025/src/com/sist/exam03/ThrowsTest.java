package com.sist.exam03;

public class ThrowsTest {
	public static void div(int a, int b) throws ArithmeticException {
		int r = a/b;
		System.out.println("나누기결과: "+r);
	}
	
	public static void main(String[] args) {
		try {
			div(4,2);
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌수 x");
		}
	}
}
