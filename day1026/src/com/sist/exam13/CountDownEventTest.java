package com.sist.exam13;

public class CountDownEventTest {
	public static void main(String[] args) {
		CountDown e1 = new CountDown();
		CountDownEvent e2 = new CountDownEvent(2, "���� ��ġ �и�!");
		e1.start();
		e2.start();
	}
}
