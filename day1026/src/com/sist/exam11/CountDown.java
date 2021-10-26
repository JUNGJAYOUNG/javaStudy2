package com.sist.exam11;

public class CountDown implements Runnable{
	
	//thread 가 해야하는 일은 run메소드를 오버라이딩
	public void run() {
		// TODO Auto-generated method stub
		for(int i=20;i>0;i--) {
			System.out.println(i+"초 전입니다.");
			try {
				Thread.sleep(1000);	//1초씩 간격.
				//sleep()은 exception을 포함하기 때문에 try문 안에 써줘야한다.
			}catch(Exception e) {
					
			}
		}
	}
}

