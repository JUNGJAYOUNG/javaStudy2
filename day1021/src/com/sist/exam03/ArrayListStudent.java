package com.sist.exam03;
import java.util.*;

public class ArrayListStudent {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		int i=1;
		while(i<=5) {
			System.out.print(i+"��° �л������� �Է��ϼ���:");
			list.add(sc.nextInt());	//.add�� �ְ�
			i++;
		}
		System.out.println("�л��������");
		int sum=0;
		for(int j=0;j<5;j++) {
			System.out.print(list.get(j)+" ");	
			sum+=list.get(j);	//.get���� ��������
		}
		double avg=(double)sum/list.size();	//.size�� ���̰��
		System.out.println("����:"+sum+"���:"+avg);
	}
}
