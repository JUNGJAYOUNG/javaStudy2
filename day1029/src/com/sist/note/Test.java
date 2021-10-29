package com.sist.note;

public class Test {
	public static void main(String[] args) {
		String data = "메모.txt";
		
		//String []arr = data.split(".");
		//System.out.println(arr[0]);
		//System.out.println(arr[1]);
		//마침표(.)으로는 분리할 수 없어요!
	
		String result = data.substring(0,data.indexOf("."));
		System.out.println(result);
	}
	
}
