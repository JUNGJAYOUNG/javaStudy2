package com.sist.exam03;

import java.util.Date;
//Calendar나 GregorianCalendar로 작성해보
public class PrintCalendarThisMonth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date today = new Date();
		int year = today.getYear();
		int month = today.getMonth();
		
		//이달의 1일의 요일을 알기위해 이달의 1일의 Date객체를 생성한다.
		Date startDate = new Date(year,month,1);
		int day = startDate.getDay();
		System.out.printf("%d년 %d월\n",year+1900,month+1);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		//그날의 1일의 요일만큼 빈칸을 출력
		for(int i=1;i<=day;i++) {
			System.out.print("\t");
		}
		
		int []lastDate = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		
		for(int i=1;i<=lastDate[month];i++) {
			System.out.print(i+"\t");
			if((i+day)%7==0) {
				System.out.println();
			}
		}
	}

}
