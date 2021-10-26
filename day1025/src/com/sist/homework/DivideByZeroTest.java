package com.sist.homework;
//lab2��
import java.util.Scanner;

public class DivideByZeroTest {
	public static void main(String[] args) {
		int number1, number2, result;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("ù��° ����:");
		number1 = sc.nextInt();
		
		System.out.println("�ι�° ����:");
		number2 = sc.nextInt();
		
		try {
			result = quotient(number1,number2);
			System.out.println(result);
		}catch(DivideByZeroException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static int quotient(int numerator, int denominator) throws DivideByZeroException{
		if(denominator==0) 
			throw new DivideByZeroException("�и�� 0�� �� �� �����!");
		return numerator/denominator;
	}
}
