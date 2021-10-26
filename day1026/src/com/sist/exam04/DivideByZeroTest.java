package com.sist.exam04;
import java.util.InputMismatchException;
//lab2번
import java.util.Scanner;

public class DivideByZeroTest {
	public static void main(String[] args) {
		int number1, number2, result;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("첫번째 정수:");
			number1 = sc.nextInt();
		
			System.out.println("두번째 정수:");
			number2 = sc.nextInt();

			result = quotient(number1,number2);
			System.out.println(result);
		}catch(DivideByZeroException e) {
			//e.printStackTrace();
			System.out.println("예외발생:"+e.getMessage());
		}catch(InputMismatchException e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			System.out.println("작업완료");
		}
	}
	
	public static int quotient(int numerator, int denominator) throws DivideByZeroException{
		if(denominator==0) 
			throw new DivideByZeroException("분모는 0이 될 수 없어요!");
		return numerator/denominator;
	}
}

//20,5 =>4
//20,"abc" =>java.util.InputMismatchException (자바가 미리 정의해둔 에러)



