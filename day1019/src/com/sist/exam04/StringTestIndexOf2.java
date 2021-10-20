package com.sist.exam04;
import java.util.Scanner;

public class StringTestIndexOf2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("이메일을 입력하세요.");
		String data = sc.next();
		
		if(data.indexOf("@")==-1) {
			System.out.println("올바른 이메일이 아닙니다.");
		}else {
			System.out.println("올바른 이메일입니다.");
		}
	}
}
