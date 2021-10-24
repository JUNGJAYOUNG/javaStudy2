package com.sist.exam06;

import java.util.*;
//5개의 로또번호 생성
public class AutoLottoUsingSet {

	public static void main(String[] args) {
		TreeSet set = new TreeSet();	//TreeSet 중복허용x, 정렬o
		Random r = new Random();	//난수 발생시키는 Random 객체 생성
		
		while(set.size()<5) {
			set.add(r.nextInt(45)+1); //0부터 발생시키니까 +1 해줘야함
		}
		System.out.println(set);
	}	

}
