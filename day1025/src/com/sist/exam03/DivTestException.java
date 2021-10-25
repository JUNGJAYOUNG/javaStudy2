package com.sist.exam03;

public class DivTestException {
	public static void main(String[] args) {
		try {
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int div = a/b;
			System.out.println("결과:"+div);
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없어요!");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("나누기할 두 수를 전달하세요!");
		}catch(NumberFormatException e) {
			System.out.println("숫자를 전달해야 합니다!");
		}
	}
}
