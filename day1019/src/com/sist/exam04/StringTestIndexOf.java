package com.sist.exam04;

public class StringTestIndexOf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = new String("returns the index within this string of the first");
		int index = data.indexOf("the");
		System.out.println(index);
		
		int index2 = data.indexOf("the",9);	//9번째 이후에서 찾기
		System.out.println(index2);
		
		int index3 = data.indexOf("hello");
		System.out.println(index3);//없으면 -1 반환

		int index4 = data.indexOf('e');
		System.out.println(index4);
	
		int index5 = data.indexOf("e");
		System.out.println(index5);
		
		
		
	}
}
