package com.sist.exam04;
import java.util.Scanner;

public class StringTestIndexOf2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("�̸����� �Է��ϼ���.");
		String data = sc.next();
		
		if(data.indexOf("@")==-1) {
			System.out.println("�ùٸ� �̸����� �ƴմϴ�.");
		}else {
			System.out.println("�ùٸ� �̸����Դϴ�.");
		}
	}
}
