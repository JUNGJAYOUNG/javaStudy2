package com.sist.exam02;

public class StringTestValueOf {

	public static void pro(String str) {
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int data = 2021;
		
		//������ ������ data�� ���� pro�� ȣ���ؾ��ϴ� ��Ȳ
		pro(String.valueOf(data)); //data�� String������ ������ش�
		pro(data+"");
	}

}
