package com.sist.lab02;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c = new Car();	//6��
		c.speedUp(20);
		c.speedDown(10);
		System.out.println("------");
		
		Movable m = new Car();	//7��
		m.speedUp(0);
		//m.printSpeed();
		//m.TurnLeft();
		
		/*
		Car c = m;	//8�� 
		Car c = (Car)m;
		Car c = new Car();
		Movable m = c;
		Movable m = (Movable)c;
		*/
	}

}
