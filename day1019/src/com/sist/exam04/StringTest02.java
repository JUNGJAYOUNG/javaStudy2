package com.sist.exam04;

public class StringTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char []data = {'h','e','l','l','o','k','o','r','e','a'};
		String result = new String(data);
		System.out.println(result);
		String result2 = new String(data,5,5);
		System.out.println(result2);
	
		String a = new String("ȫ�浿");
		String b = new String(a);
		System.out.println(a);
		System.out.println(b);
	}

}
