package com.sist.homework;

public class MyDateTest {
	public static void main(String[] args) {
		try {
			MyDate d = new MyDate("2012/12/22");
			System.out.println(d.getYear()+"년"+d.getMonth()+"월"+d.getDate()+"일");
		}catch(IllegalArgumentException e) {
			System.out.println("날짜를 전달하세요.");
		}
	}
}
