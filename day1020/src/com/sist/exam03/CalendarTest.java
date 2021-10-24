package com.sist.exam03;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarTest {
	public static void main(String[] args) {
		//Calendar today = new Calendar();
		//Calendar today = Calendar.getInstance();

		GregorianCalendar today = new GregorianCalendar();
	
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH);
		int date = today.get(Calendar.DAY_OF_MONTH);
		
		System.out.printf("오늘은 %d년 %d월 %d일입니다.",year,month+1,date);
	}
}
