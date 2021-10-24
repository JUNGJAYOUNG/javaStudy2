package com.sist.exam03;
import java.util.*;

public class ArrayListStudent {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		int i=1;
		while(i<=5) {
			System.out.print(i+"번째 학생점수를 입력하세요:");
			list.add(sc.nextInt());	//.add로 넣고
			i++;
		}
		System.out.println("학생점수출력");
		int sum=0;
		for(int j=0;j<5;j++) {
			System.out.print(list.get(j)+" ");	
			sum+=list.get(j);	//.get으로 가져오고
		}
		double avg=(double)sum/list.size();	//.size로 길이계산
		System.out.println("총점:"+sum+"평균:"+avg);
	}
}
