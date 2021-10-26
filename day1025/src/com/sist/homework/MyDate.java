package com.sist.homework;
//프로그래밍 4번
import java.util.StringTokenizer;

public class MyDate {
	private int year;
	private int month;
	private int date;
	
	public MyDate() {
		throw new IllegalArgumentException();
	}
	
	public MyDate(String str) throws IllegalArgumentException{
		if(str==null) {
			throw new IllegalArgumentException();
		}
		
		StringTokenizer st = new StringTokenizer(str,"/");
		year = Integer.parseInt(st.nextToken());
		month = Integer.parseInt(st.nextToken());
		date = Integer.parseInt(st.nextToken());
	}
	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDate() {
		return date;
	}
}
