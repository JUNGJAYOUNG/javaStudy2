package com.sist.exam02;

import java.util.*;

public class AutoLottoUsingSet {

	public static void main(String[] args) {
		TreeSet set = new TreeSet();
		Random r = new Random();
		
		while(set.size()<6) {
			set.add(r.nextInt(45)+1); //0���� �߻���Ű�ϱ� +1 �������
		}
		System.out.println(set);
	}	

}
