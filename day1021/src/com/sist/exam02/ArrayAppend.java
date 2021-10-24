package com.sist.exam02;

public class ArrayAppend {
	
	public static void printArray(int []data) {
		for(int n:data) {
			System.out.printf("%5d",n);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []data = {10,20,30,40};
		printArray(data);
		
		int []data2 = new int[data.length+1];
		
		for(int i=0;i<data.length;i++) {
			data2[i]=data[i];
		}
		
		data2[data2.length-1]=50;
		data = data2;
		printArray(data);
	}

}
