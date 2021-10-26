package com.sist.exam02;

public class MyDateTest {
	public static void main(String[] args) {
		try {
			//String data = "2022/03/11";
			String data = null;
			MyDate d = new MyDate(data);
			System.out.println(d.getYear()+"년"+d.getMonth()+"월"+d.getDate()+"일");
		}catch(IllegalArgumentException e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}
