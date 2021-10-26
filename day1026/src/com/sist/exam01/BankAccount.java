package com.sist.exam01;
//프로그래밍 3번
public class BankAccount{
	private int balance;
	
	public void deposit(int amount) {
		balance+=amount;
		System.out.printf("%d원을 입금하여 잔액은 %d원이 되었습니다.\n",amount,balance);
	}
	
	public void withdraw(int amount) throws NegativeBalanceException{
		if(amount>balance) {
			throw new NegativeBalanceException("잔액부족입니다.");
		}
		balance-=amount;
		System.out.printf("%d원을 인출하여 잔액은 %d원이 되었습니다.\n",amount,balance);
	}

	public int getBalance() {
		return balance;
	}
	
}
