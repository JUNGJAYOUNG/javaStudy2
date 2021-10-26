package com.sist.exam06;

import java.util.Scanner;

public class MyArray {
	public int []data;
	
	public MyArray() {
		try {
			//data = new int[-1];
			//data = new int[10];
			Scanner sc = new Scanner(System.in);
			for(int i=0;i<10;i++) {
				System.out.printf("%d��°�� �����͸� �Է��ϼ���",i+1);
				data[i]=sc.nextInt();
			}
		}catch(NegativeArraySizeException e) {
			System.out.println("�迭�� ũ��� ������ �� �� �����");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("�迭�� �ε��� ������ �Ѿ����ϴ�.");
		}catch(NullPointerException e) {
			System.out.println("�迭�� �������� �ʾҾ��.");
		}
	}
	
	public double getAverage() {
		double avg=0;
		int sum=0;
		try {
			for(int i=0;i<10;i++) {
				sum+=data[i];	
			}
			avg=sum/data.length;
		}catch(ArithmeticException e) {
			System.out.println("�迭�� �����Ͱ� �����");
		}
		
		return avg;
	}
	
	
}
