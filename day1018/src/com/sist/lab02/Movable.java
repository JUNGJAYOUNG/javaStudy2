package com.sist.lab02;

public interface Movable {
	public void speedUp(int amount);
	public void speedDown(int amount);
	
	//int speed;	//2��
	//int speed=100;	//3��
	final int speed=100;
	
	public static void printSpeed() {	//static���� �ؾ� ������ �ȳ���..
		System.out.println(speed);
	}
}
