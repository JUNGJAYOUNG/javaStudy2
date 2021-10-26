package com.sist.game;
import java.awt.event.KeyEvent;

public class Missile extends GraphicObject {
	//�̻����� �߻�Ǿ����� �Ǻ��ϱ� ���� ����
	boolean launched = false;
	
	//�����ÿ� �̹��������̸��� �Ű������� ���޹޾�
	public Missile(String name) {
		//�θ��� �����ڿ��� �����մϴ�.
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public void update() {
		//���࿡ �̻����� �߻� �Ǿ��ٸ� 
		//y��ǥ�� 1�� ����
		if(launched) {
			y -=1;
		}
		//�̻����� y��ǥ�� ȭ���� ���� �Ⱥ��̴� �����̸� launched�� false����
		if(y <-100) {
			launched = false;
		}
	}

	//Ű���尡 �������� ���� ���ּ��� �ִ� ��ġ x,y��ǥ�������� ����Ͽ�
	//�̻����� �߻��Ű�� ���Ͽ� keyPressed �޼ҵ带 �������̵� �Ѵ�.
	//���� �Ű������� ���޹޴� KeyEvent event�� ���ؼ� � key�� ���������� �� �� �ֵ�.
	//�Ű����� x,y�� ���ּ��� ��ġ x,y�� ���޹޴´�.
	public void keyPressed(KeyEvent event, int x, int y) {
		//������ Ű�� �����̽��� ���
		if(event.getKeyCode()==KeyEvent.VK_SPACE) {
			launched = true;//�̻����� �߻��Ű�� ���Ͽ� launched�� true����
			this.x=x;	//�̻����� x,y��ǥ�� ���ּ��� x,y��ǥ�� ����
			this.y=y;
		}
	}
	
}
	
	
