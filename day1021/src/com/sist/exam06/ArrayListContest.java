package com.sist.exam06;
import java.util.*;

public class ArrayListContest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Double> score = new ArrayList<Double>();
		double sum=0;
		for(int i=0;i<10;i++) {		//점수입력 for문
			while(true) {
				System.out.print(i+1+"번째 점수를 입력하세요:");
				double input=sc.nextDouble();
				if(input<0.0 || input>10.0) {
					System.out.println("잘못된 입력입니다.");
				}else {
					score.add(input);
					sum+=input;
					break;
				}
			}
		}
		double max=score.get(0);		//가장 큰 값 구하기
		int indexMax=0;
		for(int i=1;i<score.size();i++) {
			if(max<score.get(i)) {
				max=score.get(i);
				indexMax=i;
			}
		}
		
		double min=score.get(0);	//가장 작은 값 구하기
		int indexMin=0;
		for(int j=1;j<score.size();j++) {
			if(min>score.get(j)) {
				min=score.get(j);
				indexMin=j;
			}
		}
		sum-=score.get(indexMin);	//합계에서 가장 작은 값 빼기
		sum-=score.get(indexMax);	//합계에서 가장 큰 값 빼기
		score.remove(indexMax);		//점수리스트에서 가장 큰 값 제거
		score.remove(indexMin);		//점수리스트에서 가장 작은 값 제거	
		
		
		System.out.println(score);
		System.out.println("집계결과(총점수):"+sum+"점");
	}

}
