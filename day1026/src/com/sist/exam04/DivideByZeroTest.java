package com.sist.exam04;
import java.util.InputMismatchException;
//lab2��
import java.util.Scanner;

public class DivideByZeroTest {
	public static void main(String[] args) {
		int number1, number2, result;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("ù��° ����:");
			number1 = sc.nextInt();
		
			System.out.println("�ι�° ����:");
			number2 = sc.nextInt();

			result = quotient(number1,number2);
			System.out.println(result);
		}catch(DivideByZeroException e) {
			//e.printStackTrace();
			System.out.println("���ܹ߻�:"+e.getMessage());
		}catch(InputMismatchException e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}finally {
			System.out.println("�۾��Ϸ�");
		}
	}
	
	public static int quotient(int numerator, int denominator) throws DivideByZeroException{
		if(denominator==0) 
			throw new DivideByZeroException("�и�� 0�� �� �� �����!");
		return numerator/denominator;
	}
}

//20,5 =>4
//20,"abc" =>java.util.InputMismatchException (�ڹٰ� �̸� �����ص� ����)



