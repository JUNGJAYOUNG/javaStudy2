package com.sist.lab02;

public class Car implements Movable {
	//필드 추가????

	@Override
	public void speedUp(int amount) {
		amount = speed + amount;
		System.out.println("속도를"+amount+"로 올렸습니다.");
	}

	@Override
	public void speedDown(int amount) {
		amount = speed + amount;
		System.out.println("속도를"+amount+"로 내렸습니다.");
		
	}

	public void TurnLeft() {
		System.out.println("좌회전하세요.");
	}
	public void TurnRight() {
		System.out.println("우회전하세요");
	}
}
