package com.sist.homework;
//lab2번
import java.util.Scanner;

public class DivideByZeroTest {
	public static void main(String[] args) {
		int number1, number2, result;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째 정수:");
		number1 = sc.nextInt();
		
		System.out.println("두번째 정수:");
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
			throw new DivideByZeroException("분모는 0이 될 수 없어요!");
		return numerator/denominator;
	}
}
