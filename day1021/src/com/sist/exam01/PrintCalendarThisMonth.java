package com.sist.exam01;

import java.util.Scanner;
import java.util.Date;
//Calendar�� GregorianCalendar�� �ۼ��غ�
public class PrintCalendarThisMonth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�⵵�� �Է��ϼ���");
		int year = sc.nextInt()-1900;
		
		System.out.println("���� �Է��ϼ���");
		int month = sc.nextInt()-1;
		
		//�̴��� 1���� ������ �˱����� �̴��� 1���� Date��ü�� �����Ѵ�.
		Date startDate = new Date(year,month,1);
		int day = startDate.getDay();
		System.out.printf("%d�� %d��\n",year+1900,month+1);
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");
		
		//�׳��� 1���� ���ϸ�ŭ ��ĭ�� ���
		for(int i=1;i<=day;i++) {
			System.out.print("\t");
		}
		
		int []lastDate = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		for(int i=1;i<=lastDate[month];i++) {
			System.out.print(i+"\t");
			if((i+day)%7==0) {
				System.out.println();
			}
		}
	}

}
