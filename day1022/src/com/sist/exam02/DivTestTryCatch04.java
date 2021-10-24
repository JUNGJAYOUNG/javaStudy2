package com.sist.exam02;

public class DivTestTryCatch04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int result = a/b;
			System.out.println("결과:"+ result);
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌수는 없어요!");
		}catch(Exception e) {
			System.out.println("두번째수가 0이 아닌 두개의 숫자를 전달해주세요");
		
	}
	}}

