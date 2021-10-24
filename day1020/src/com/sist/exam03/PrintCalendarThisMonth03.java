package com.sist.exam03;

import java.util.Scanner;

import javax.sound.midi.Soundbank;

import java.util.Date;
//Calendar나 GregorianCalendar로 작성해보
public class PrintCalendarThisMonth03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("년도를 입력하세요");
		int year = sc.nextInt();
		
		System.out.println("월을 입력하세요");
		int month = sc.nextInt();
		
		//이달의 1일의 요일을 알기위해 이달의 1일의 Date객체를 생성한다.
		Date startDate = new Date(year+1900,month+1,1);
		int day = startDate.getDay();
		System.out.println(day);
		System.out.printf("%d년 %d월\n",year,month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		//그날의 1일의 요일만큼 빈칸을 출력
		for(int i=1;i<=day;i++) {
			System.out.print("\t");
		}
		
		int []lastDate = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		
		for(int i=1;i<=lastDate[month];i++) {
			System.out.print(i+"\t");
			if((i+day-1)%7==0) {
				System.out.println();
			}
		}
	}

}
