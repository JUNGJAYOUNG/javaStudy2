package com.sist.exam02;

public class StringBufferReplace {
	public static void main(String[] args) {
		StringBuffer data = new StringBuffer("hello korea");
		
		data.replace(0, 5, "hi");
		System.out.println(data);
		
		String oldS = "hello";
		String newS = "hi";
	
		int start = data.indexOf(oldS);
		int end = start+ oldS.length();
		
		data.replace(start,end,newS);

		}
}
