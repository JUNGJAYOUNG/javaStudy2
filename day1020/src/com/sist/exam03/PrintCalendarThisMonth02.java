package com.sist.exam03;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.GrayFilter;
//Calendar�� GregorianCalendar�� �ۼ��غ���
public class PrintCalendarThisMonth02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GregorianCalendar today = new GregorianCalendar();
		
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH);
		
		//�̴��� 1���� ������ �˱����� �̴��� 1���� Date��ü�� �����Ѵ�.
		GregorianCalendar startDate = new GregorianCalendar(year,month,1);
		int day = startDate.get(Calendar.DAY_OF_WEEK);	//�Ͽ��Ϻ��� 1
		System.out.println(day);
		System.out.printf("%d�� %d��\n",year,month+1);
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");
		
		//�׳��� 1���� ���ϸ�ŭ ��ĭ�� ���
		for(int i=1;i<day;i++) {
			System.out.print("\t");
		}
		
		int []lastDate = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		
		for(int i=1;i<=lastDate[month];i++) {
			System.out.print(i+"\t");
			if((i+day-1)%7==0) {
				System.out.println();
			}
		
	}
}
}
