package com.sist.exam04;
import java.util.Scanner;

public class StringTest06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); //문제1
		System.out.println("이메일을 입력하세요");
		String email = sc.next();
		String id = email.substring(0, email.indexOf("@"));
		System.out.println("아이디는"+id+"입니다.");
		
		System.out.println("영문의 문장을 입력하세요"); //문제2
		String data = sc.next();
		
		int cnt=0;
		int index;
		while(data.indexOf('o')!=-1) {	//charAt + for문 돌리기
			index = data.indexOf('o');
			data = data.substring(index);
			cnt++;
		}
		System.out.println(cnt+"개");
		
		System.out.println("아이디를 입력하세요");	//문제3
		String idd = sc.next();
		System.out.println("암호를 입력하세요");
		String pwd = sc.next();
		if(idd.equals("tiger") && pwd.equals("tiger1234")) {
			System.out.println("로그인에 성공하였습니다.");
		}else {
			System.out.println("로그인에 실패하였습니다.");
		}
			
	}

}
