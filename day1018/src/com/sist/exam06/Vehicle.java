package com.sist.exam06;

public abstract class Vehicle {
	protected int speed;
	//추상클래스에 속성을 추가할 수 있다.(추상클래스는 추상메소드 이외에 일반 속성 포함 가능)
	public void printSpeed() {
		System.out.println("현재속도:"+speed);
	}
	//추상클래스는 추상메소드 말고도 body가 구체화된 일반 메소드를 포함할 수 있다.
	public abstract double getKilosPerLiter();

}
