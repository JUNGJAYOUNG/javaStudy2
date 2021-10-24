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

	public static void sortArray(int []arr) {	//�迭����
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
		//�ζǴ� 1~45���� 6���� ���ڸ� ����(�ߺ�����)
		int []n = new int[6];
		
		Random r = new Random();	//���� �����ϴ� Random��ü ����
		for(int i=0;i<6;i++) {
			int temp = r.nextInt(45)+1;
			if(!isAlready(temp,i,n)) {	//�迭 �ȿ� temp���� ������ �߰��ϴ� if��
				n[i] = temp;
				i++;
			}
		sortArray(n);
		printArray(n);
		}	
	}
}
