package com.sist.exam05;

import java.util.Scanner;

public class MyArrayTest {
	public static void main(String[] args) {
		try {
			MyArray array = new MyArray();
			System.out.println(array.getAverage());
		}catch(NegativeArraySizeException e) {
			System.out.println("�迭�� ũ��� ������ �� �� �����");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("�迭�� �ε��� ������ �Ѿ����ϴ�.");
		}catch(NullPointerException e) {
			System.out.println("�迭�� �������� �ʾҾ��.");
		}
	}
	
}
