package com.sist.exam02;

public class MyDateTest {
	public static void main(String[] args) {
		try {
			//String data = "2022/03/11";
			String data = null;
			MyDate d = new MyDate(data);
			System.out.println(d.getYear()+"��"+d.getMonth()+"��"+d.getDate()+"��");
		}catch(IllegalArgumentException e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
	}
}
