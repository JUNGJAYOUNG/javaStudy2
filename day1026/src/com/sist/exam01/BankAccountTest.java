package com.sist.exam01;

public class BankAccountTest {

	public static void main(String[] args) {
		try {
			BankAccount b = new BankAccount();
			b.deposit(10000);
			b.withdraw(50000);
			System.out.println("�ܾ�:"+b.getBalance()+"��");
		}catch(NegativeBalanceException e) {
			e.printStackTrace();
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
	}
}
