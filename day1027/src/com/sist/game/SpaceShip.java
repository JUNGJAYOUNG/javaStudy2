package com.sist.game;
//�츮��(���ּ�)�� ���� Ŭ����

import java.awt.event.KeyEvent;
public class SpaceShip extends GraphicObject {
	
	//�����ÿ� �̹������ϸ��� �Ű������� ���޹޾� �θ��� �����ڿ� �����Ѵ�.
	public SpaceShip(String name) {
		super(name);
		//��ó�� ���ּ��� ��ġ x,y�� ����
		x=150;
		y=350;
	}
	
	//"���ּ�"�� ������ ����Ű�� ���� ���ּ��� ��ġ�� �̵����ѿ�.
	//�Ű������� ���޹��� KeyEvent event�� ���ؼ� �Ű�� ���������� �˼� �ִ�. 
	public void keyPressed(KeyEvent event) {
		
		//���ʹ���Ű�� ��������
		if(event.getKeyCode() == KeyEvent.VK_LEFT) {
			//x��ǥ�� �������� �̵���Ű�� ���Ͽ� 10�� �����Ѵ�.
			x -=10;
		}
		//������ ����Ű
		if(event.getKeyCode() == KeyEvent.VK_RIGHT) {
			//x��ǥ�� ���������� �̵���Ű�� ���Ͽ� 10�� �����Ѵ�.
			x +=10;
		}
		//���� ����Ű
		if(event.getKeyCode() == KeyEvent.VK_UP) {
			//y��ǥ�� �������� �̵���Ű�� ���Ͽ� 10�� �����Ѵ�.
			y -=10;
		}
		//�Ʒ��� ����Ű
		if(event.getKeyCode() == KeyEvent.VK_DOWN) {
			//y��ǥ�� �Ʒ������� �̵���Ű�� ���Ͽ� 10�� �����Ѵ�.
			y +=10;
		}
		
		
	}
}
