package com.sist.exam11;

import com.sist.exam12.CountDownEvent;

public class CountDownTest {
	public static void main(String[] args) {
		CountDown c1 = new CountDown();
		CountDown c2 = new CountDown();
		
		new Thread(c1).start();	//��ü�� Thread�� �����ؼ� start �� �� �ִ�.
		new Thread(c2).start();	

	}
}
