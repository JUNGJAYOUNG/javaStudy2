package com.sist.homework;
//���α׷��� 3��
public class BankAccount{
	private int balance;
	
	public int getBalance() {
		return balance;
	}
	
	public void deposit(int amount) {
		balance+=amount;
	}
	
	public void withdraw(int amount) throws NegativeBalanceException{
		if(amount>balance) {
			throw new NegativeBalanceException("�ܾ׺����Դϴ�.");
		}
		balance-=amount;
	}
}
