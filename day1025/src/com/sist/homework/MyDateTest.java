package com.sist.homework;

public class MyDateTest {
	public static void main(String[] args) {
		try {
			MyDate d = new MyDate("2012/12/22");
			System.out.println(d.getYear()+"��"+d.getMonth()+"��"+d.getDate()+"��");
		}catch(IllegalArgumentException e) {
			System.out.println("��¥�� �����ϼ���.");
		}
	}
}
