package com.sist.lab02;

public class Car implements Movable {
	//�ʵ� �߰�????

	@Override
	public void speedUp(int amount) {
		amount = speed + amount;
		System.out.println("�ӵ���"+amount+"�� �÷Ƚ��ϴ�.");
	}

	@Override
	public void speedDown(int amount) {
		amount = speed + amount;
		System.out.println("�ӵ���"+amount+"�� ���Ƚ��ϴ�.");
		
	}

	public void TurnLeft() {
		System.out.println("��ȸ���ϼ���.");
	}
	public void TurnRight() {
		System.out.println("��ȸ���ϼ���");
	}
}