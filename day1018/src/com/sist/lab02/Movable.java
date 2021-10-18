package com.sist.lab02;

public interface Movable {
	public void speedUp(int amount);
	public void speedDown(int amount);
	
	//int speed;	//2번
	//int speed=100;	//3번
	final int speed=100;
	
	public static void printSpeed() {	//static으로 해야 오류가 안났음..
		System.out.println(speed);
	}
}
