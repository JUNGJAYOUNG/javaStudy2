package com.sist.exam14;

import java.util.Date;

public class SayHello extends Thread{
	int hour;
	int min;
	int sec;
	public void run() {
		
		while(true) {
			Date now = new Date();
			hour = now.getHours();
			min = now.getMinutes();
			sec = now.getSeconds();
			System.out.println(hour+"시"+min+"분"+sec+"초"+"안녕하세요?");
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				
			}
		}
	}
}
