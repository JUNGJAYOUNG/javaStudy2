package com.sist.product;

import java.util.Random;

//"생산자"와 "소비자"가 공유할 "제품"클래스를 만든다.
public class Product {
	//생산되는 제품을 임의의 정수라고 한다.
	int number;
	//제품을 새로 생산하였는지 소비하는지 판별하기 위한 변수
	public boolean isNew=false;
	
	//생산자가 제품을 생산하고 잇는 동안에는 소비자가 접근할 수 없게 하기 위해 임계영역으로 설정
	public synchronized void makeNumber() {
		
		//새로운 제품(정수)를 생산하기 전에 소비가 일어날때까지 대기상태로 있도록 한다.
		while(isNew == true) {
			try {
				wait();
			}catch(Exception e) {
				
			}
		}
		
		//새로운 제품(정수)을 난수로 만든다.
		Random r = new Random();
		number = r.nextInt(100);	//새로운 제품 생산
		System.out.println("생산자가 새로운 제품 생성");
		isNew = true;	//새로운 제품을 생산했다는 표시
		notify();	//대기중인 스레드(소비자)를 꺠워준다.
	}
	
	//소비자가 사용할 제품을 소비하기 위한 메소드를 정의
	public synchronized int getNumber() {
		
		//생산자가 새로운 제품을 생산할때까지 대기상태로 있도록 한다.
		while(isNew==false) {
			try {
				wait();
			}catch(Exception e) {
			
			}
		}
		System.out.println("소비자가 제품 소비함 ==>"+number);
		isNew=false;
		notify();
		return number;
		
	}
}
