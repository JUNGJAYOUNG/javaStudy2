package com.sist.exam04;
import java.util.Scanner;

public class StringTest06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); //����1
		System.out.println("�̸����� �Է��ϼ���");
		String email = sc.next();
		String id = email.substring(0, email.indexOf("@"));
		System.out.println("���̵��"+id+"�Դϴ�.");
		
		System.out.println("������ ������ �Է��ϼ���"); //����2
		String data = sc.next();
		
		int cnt=0;
		int index;
		while(data.indexOf('o')!=-1) {	//charAt + for�� ������
			index = data.indexOf('o');
			data = data.substring(index);
			cnt++;
		}
		System.out.println(cnt+"��");
		
		System.out.println("���̵� �Է��ϼ���");	//����3
		String idd = sc.next();
		System.out.println("��ȣ�� �Է��ϼ���");
		String pwd = sc.next();
		if(idd.equals("tiger") && pwd.equals("tiger1234")) {
			System.out.println("�α��ο� �����Ͽ����ϴ�.");
		}else {
			System.out.println("�α��ο� �����Ͽ����ϴ�.");
		}
			
	}

}
