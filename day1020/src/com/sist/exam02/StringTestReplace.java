package com.sist.exam02;
import java.util.Scanner;

public class StringTestReplace {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���ڿ��� �Է��ϼ���:");
		String data = sc.next();
		
		System.out.println(data.replace("hello", "�ȳ�"));
	}
}
