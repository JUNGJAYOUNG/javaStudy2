package com.sist.exam05;

import java.util.Scanner;

public class MyArrayTest {
	public static void main(String[] args) {
		try {
			MyArray array = new MyArray();
			System.out.println(array.getAverage());
		}catch(NegativeArraySizeException e) {
			System.out.println("배열의 크기는 음수가 될 수 없어용");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 인덱스 범위를 넘었습니다.");
		}catch(NullPointerException e) {
			System.out.println("배열이 생성되지 않았어요.");
		}
	}
	
}
