package com.sist.exam03;

import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		
		String []arr = {"일","월","화","수","목","금","토"};
		
		Date today = new Date();
		int year = today.getYear() + 1900;
		int month = today.getMonth() + 1;
		int date = today.getDate();
		int hours = today.getHours();
		int minutes = today.getMinutes();
		int seconds = today.getSeconds();
		int day = today.getDay();
		//지금의 자바 버전에서는 Date보다는 Calendar나 다른 클래스를 권장해서 줄이 쳐지는 거다
		//무시해도 좋다
		String yoil = arr[day];

		System.out.printf("현재는 %d년 %d월 %d일(%s요일) %d분 %d초입니다.",year,month,date,yoil,hours,minutes,seconds);
		//이건우는 무슨 요일에 태어났는지 알아보자
		//1995/7/29
		
		int birthYear = 1995;
		int birthMonth = 7;
		int birthDate = 29;
		
		Date leeDate = new Date(birthYear-1900,birthMonth-1, birthDate);
		int day2 = leeDate.getDay();
		System.out.printf("이건우가 태어난 날은 %s요일입니다.",arr[day2]);
		
		
		
	
	}
}
