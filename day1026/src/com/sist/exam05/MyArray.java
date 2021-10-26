package com.sist.exam05;

import java.util.Scanner;

public class MyArray {
	public int []data;
	
	public MyArray() {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<10;i++) {
			System.out.printf("%d번째의 데이터를 입력하세요",i+1);
			data[i]=sc.nextInt();
		}
		
	}
	
	public double getAverage() {
		double avg=0;
		int sum=0;
		for(int i=0;i<10;i++) {
			sum+=data[i];	
		}
		avg=sum/data.length;

		return avg;
	}
	
	
}
