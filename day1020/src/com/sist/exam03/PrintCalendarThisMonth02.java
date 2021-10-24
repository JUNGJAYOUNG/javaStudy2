package com.sist.exam03;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.GrayFilter;
//Calendar나 GregorianCalendar로 작성해보기
public class PrintCalendarThisMonth02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GregorianCalendar today = new GregorianCalendar();
		
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH);
		
		//이달의 1일의 요일을 알기위해 이달의 1일의 Date객체를 생성한다.
		GregorianCalendar startDate = new GregorianCalendar(year,month,1);
		int day = startDate.get(Calendar.DAY_OF_WEEK);	//일요일부터 1
		System.out.println(day);
		System.out.printf("%d년 %d월\n",year,month+1);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		//그날의 1일의 요일만큼 빈칸을 출력
		for(int i=1;i<day;i++) {
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
