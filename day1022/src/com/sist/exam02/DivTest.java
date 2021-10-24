package com.sist.exam02;

public class DivTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int result = a/b;
			System.out.println("결과:"+ result);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("실행시에 나누기할 두수를 전달하세요");
		}
	}
}

