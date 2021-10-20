package com.sist.exam02;

import javax.sql.rowset.serial.SQLOutputImpl;

public class StringBufferInsert {
	public static void main(String[] args) {
		StringBuffer data = new StringBuffer("hello java");
		
		int year = 2021;
		String msg = "hi";
		boolean flag = true;
		
		data.insert(5,year);
		System.out.println(data);
		
		data.insert(0, msg);
		System.out.println(data);
		
		StringBuffer data2 = new StringBuffer("hi");
		data2.append(flag);
		System.out.println(data2);
	}
	
}
