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
				System.out.printf("%d번째의 데이터를 입력하세요",i+1);
				data[i]=sc.nextInt();
			}
		}catch(NegativeArraySizeException e) {
			System.out.println("배열의 크기는 음수가 될 수 없어용");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 인덱스 범위를 넘었습니다.");
		}catch(NullPointerException e) {
			System.out.println("배열이 생성되지 않았어요.");
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
			System.out.println("배열의 데이터가 없어요");
		}
		
		return avg;
	}
	
	
}
