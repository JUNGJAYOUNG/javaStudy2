package com.sist.exam04;

public class StringBufferTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer data = new StringBuffer("hello");
		data.append("korea");
		
		System.out.println(data);
		
		//A의 data와 B의 data는 같은 메모리를 참조한다.
		//StringBuffer 의 내용을 바꾸더라도 새로운 메모리를 만들지 않고
		//기존의 객체 내용이 변경된다.
		//따라서, 변하는 문자열 처리에는 StringBuffef나 StringBuilder를 사용할것.
		
	}

}
