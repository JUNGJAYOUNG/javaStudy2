package com.sist.exam01;

import java.util.Random;
import java.util.TreeSet;

public class AutoLotto5 {
	public static void main(String[] args) {
		Random r = new Random();
		TreeSet<Integer> []arr = new TreeSet[5];
		for(int i=0;i<arr.length;i++) {
			arr[i] = new TreeSet<Integer>();
			while(arr[i].size()<6) {
				arr[i].add(r.nextInt(45)+1);
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}
