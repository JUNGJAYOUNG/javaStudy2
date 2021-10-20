package com.sist.exam04;
import java.util.Scanner;

public class StringTestPassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("비밀번호를 입력하세요.");
		String password = sc.next();
		System.out.println("비밀번호를 다시한번 입력하세요(확인)");
		String password2 = sc.next();
		
		int length=password.length();
		int length2=password2.length();
		
		if(length>=8 && length<=12 && password.equals(password2)) {
			System.out.println("올바른 암호입니다.");
		}else {
			System.out.println("올바르지 않은 암호입니다.");
		}
			

	}

}
