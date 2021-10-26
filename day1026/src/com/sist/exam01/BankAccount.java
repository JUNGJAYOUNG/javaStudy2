package com.sist.exam01;
//���α׷��� 3��
public class BankAccount{
	private int balance;
	
	public void deposit(int amount) {
		balance+=amount;
		System.out.printf("%d���� �Ա��Ͽ� �ܾ��� %d���� �Ǿ����ϴ�.\n",amount,balance);
	}
	
	public void withdraw(int amount) throws NegativeBalanceException{
		if(amount>balance) {
			throw new NegativeBalanceException("�ܾ׺����Դϴ�.");
		}
		balance-=amount;
		System.out.printf("%d���� �����Ͽ� �ܾ��� %d���� �Ǿ����ϴ�.\n",amount,balance);
	}

	public int getBalance() {
		return balance;
	}
	
}