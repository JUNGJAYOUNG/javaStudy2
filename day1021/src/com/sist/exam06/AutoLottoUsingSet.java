package com.sist.exam06;

import java.util.*;
//5���� �ζǹ�ȣ ����
public class AutoLottoUsingSet {

	public static void main(String[] args) {
		TreeSet set = new TreeSet();	//TreeSet �ߺ����x, ����o
		Random r = new Random();	//���� �߻���Ű�� Random ��ü ����
		
		while(set.size()<5) {
			set.add(r.nextInt(45)+1); //0���� �߻���Ű�ϱ� +1 �������
		}
		System.out.println(set);
	}	

}
