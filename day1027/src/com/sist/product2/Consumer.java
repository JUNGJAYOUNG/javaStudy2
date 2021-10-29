package com.sist.product2;

public class Consumer extends Thread{
	
	private Product product; //제품을 위한 클래스를 멤버변수로 선언한다.
	//이 제품객체는 생산자가 갖고 잇는 제품과 동일한 객체 -> 공유자원
	
	public Consumer(Product product) {
		this.product=product;
	}
	//쓰레드가 해야할 일을 run을 오버라이딩하여 써준다.
	public void run() {
		//반복실행하여 10개의 제품을 사용하도록 한다.
		for(int i=0;i<=10;i++) {
			product.getNumber(); //제품을 소비하기 위한 getNumber메소드 호출
			
		}
	}
}
