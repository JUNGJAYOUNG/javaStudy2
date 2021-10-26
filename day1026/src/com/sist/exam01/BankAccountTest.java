package com.sist.exam01;

public class BankAccountTest {

	public static void main(String[] args) {
		try {
			BankAccount b = new BankAccount();
			b.deposit(10000);
			b.withdraw(50000);
			System.out.println("잔액:"+b.getBalance()+"원");
		}catch(NegativeBalanceException e) {
			e.printStackTrace();
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}
