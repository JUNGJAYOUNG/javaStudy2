package com.sist.exam03;

public class ThrowTest {
	public static void main(String[] args) {
		int a = 4/0;
		
		//������ ���� �߻���Ű��
		throw new ArithmeticException();
	}
}
