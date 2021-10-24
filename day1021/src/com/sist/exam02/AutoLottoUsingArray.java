package com.sist.exam02;
import java.util.*;

public class AutoLottoUsingArray {
	
	public static void printArray(int []data) {
		for(int n:data) {
			System.out.print(n + "\t");
		}
		System.out.println();
	}
	
	public static boolean isAlready(int value, int last, int []arr) {
		boolean flag = false;
		for(int i=0;i<=last;i++) {
			if(arr[i] == value) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public static void sortArray(int []arr) {	//배열정렬
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[i]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		//로또는 1~45까지 6개의 숫자를 선택(중복없이)
		int []n = new int[6];
		
		Random r = new Random();	//난수 생성하는 Random객체 생성
		for(int i=0;i<6;i++) {
			int temp = r.nextInt(45)+1;
			if(!isAlready(temp,i,n)) {	//배열 안에 temp값이 없으면 추가하는 if문
				n[i] = temp;
				i++;
			}
		sortArray(n);
		printArray(n);
		}	
	}
}

