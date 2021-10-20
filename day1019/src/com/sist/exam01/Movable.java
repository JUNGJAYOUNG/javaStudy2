package com.sist.exam01;

public interface Movable {
	int speed=100;	//interface에서의 변수는 상수니까 초기화를 무조건 해줘야함.	
	
	public void speedUp(int amount);
	public void speedDown(int amount);
	
	/*
	public void printSpeed() {
		body올 수 없다.
	}
	*/
}
