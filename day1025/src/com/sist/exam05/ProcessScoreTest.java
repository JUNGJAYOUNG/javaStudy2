package com.sist.exam05;

public class ProcessScoreTest {
	public static void main(String[] args) {
		int[] score= {-1,20,40,50,100};
		try {
			ProcessScore p = new ProcessScore(score);
			System.out.println(p.getAvg());
		}catch(IllegalScore e) {
			System.out.println(e.getMessage());
		}
	}
	
}
