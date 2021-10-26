package com.sist.exam01;
//사용자정의예외(부모에게 오류 메세지를 보낸다)
public class NegativeBalanceException extends Exception{
	public NegativeBalanceException(String msg) {
		super(msg);
	}
}
