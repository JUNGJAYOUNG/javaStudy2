package com.sist.exam04;
import java.util.Scanner;

public class StringTestPassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("��й�ȣ�� �Է��ϼ���.");
		String password = sc.next();
		System.out.println("��й�ȣ�� �ٽ��ѹ� �Է��ϼ���(Ȯ��)");
		String password2 = sc.next();
		
		int length=password.length();
		int length2=password2.length();
		
		if(length>=8 && length<=12 && password.equals(password2)) {
			System.out.println("�ùٸ� ��ȣ�Դϴ�.");
		}else {
			System.out.println("�ùٸ��� ���� ��ȣ�Դϴ�.");
		}
			

	}

}
