package com.sist.exam04;

public class StringTestLastIndexOf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = new String("https://docs.oracle.com/javase/8/docs/api/");
		
		//���� url�κ��� �ǳ��� �ִ� "/"�� �ε����� ã�� ���
		
		int index = url.lastIndexOf("/");
		System.out.println(index);
	}

}
