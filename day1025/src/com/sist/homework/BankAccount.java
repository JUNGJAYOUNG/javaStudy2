package com.sist.homework;
//프로그래밍 3번
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
			throw new NegativeBalanceException("잔액부족입니다.");
		}
		balance-=amount;
	}
}
