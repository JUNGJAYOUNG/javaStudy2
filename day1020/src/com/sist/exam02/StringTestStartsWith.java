package com.sist.exam02;

import java.util.Scanner;

public class StringTestStartsWith {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("�̸� �Է�:");
		String data = sc.next();
		
		if(data.startsWith("��")) {
			System.out.println("�达�Դϴ�.");
		}else {
			System.out.println("�达�� �ƴմϴ�.");
		}

	}

}
