package com.sist.exam02;

import java.util.Scanner;

public class StringTestStartsWith {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("ÀÌ¸§ ÀÔ·Â:");
		String data = sc.next();
		
		if(data.startsWith("±è")) {
			System.out.println("±è¾¾ÀÔ´Ï´Ù.");
		}else {
			System.out.println("±è¾¾°¡ ¾Æ´Õ´Ï´Ù.");
		}

	}

}
