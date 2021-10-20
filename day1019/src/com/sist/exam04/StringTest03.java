package com.sist.exam04;

public class StringTest03 {
	public static void main(String[] args) {
		String data = new String("hello");	//A
		data = data + "korea";				//B
		
		System.out.println(data);
	
	}
}/*A와 B가 참조하는 객체는 다르다
String의 내용을 변경하면 새로운 메모리를 잡는다.
메모리 효율성이 떨어진다.*/
