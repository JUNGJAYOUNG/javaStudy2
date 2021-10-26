package com.sist.exam13;

public class CountDownEvent extends Thread{
	private int delay;
	private String msg;
	
	public CountDownEvent(int delay, String msg) {
		this.delay=delay*1000;
		this.msg = msg;
	}
	
	public void run() {
		try {
			Thread.sleep(delay);
		}catch(Exception e) {
			
		}
		System.out.println(msg);
	}
}
