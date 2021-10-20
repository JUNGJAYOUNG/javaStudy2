package com.sist.exam04;

public class StringTestSubstring {
	public static void main(String[] args) {
		String data = "abcdefghijklmn";
		String data2 = data.substring(3,8);	//defgh
		String data3 = data.substring(8);	//ijklmn (8번째부터 끝까지)
		System.out.println(data2);
		System.out.println(data3);
		
		String url = "https://https://docs.oracle.com/javase/8/docs/api/index.html";
		int i = url.lastIndexOf("/")+1;
		String result = url.substring(i);
		System.out.println(result);
	}
}
