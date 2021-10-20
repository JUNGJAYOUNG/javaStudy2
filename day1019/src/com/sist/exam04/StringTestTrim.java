package com.sist.exam04;

public class StringTestTrim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = "   java   ";
		int n = data.length();
		System.out.println(n);	//10
		String data2 = data.trim();
		int n2 = data2.length();
		System.out.println(n2);	//4
		System.out.println("|"+data+"|");
		System.out.println("|"+data2+"|");
	
		data=data.trim();	//공백을 제거하고 새로운 메모리를 가리킴	
		System.out.println("|"+data+"|");
	}

}
