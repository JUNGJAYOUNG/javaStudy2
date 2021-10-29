package com.sist.ars;

public class Account {
	//전체 모금액
	private int balance;
	
	//입금 메소드
	public synchronized void deposit(int amount) {
		balance+=amount;
	}
	
	//현재 모금액을 반환하는 메소드
	public int getBalance() {
		return balance;
	}
	
}
