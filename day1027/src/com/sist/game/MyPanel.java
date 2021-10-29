package com.sist.game;

import javax.swing.JPanel;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Graphics;

public class MyPanel extends JPanel implements KeyListener {
	//Enermy enermy;
	//�������� ���� ����� ���Ͽ� ArrayList�� �����
	ArrayList<Enermy> enermyList;
	
	SpaceShip spaceship;
	Missile missile;
	
	//�����ڿ� ��, �г��� �����ǰ� ���ÿ� �����Ͽ�
	public MyPanel() {
		super();
		this.addKeyListener(this);	//�г��� Ű���� �̺�Ʈ�� ��û
		this.requestFocus();		//�г��� Ű���� ��û�� ���� a
		setFocusable(true);			//�гο� ��Ŀ�� ���� b
		//�г��� �������� Ű����κ��� �Է¹޾� ���̴� �뵵�� �ƴϱ� ������
		//Ű����κ��� �Է��� �޾Ƶ��̰� �Ϸ��� ��Ŀ�������� �ʿ�(a,b �ʿ�)
		
		//�������� ���� ��� ���� ArrayList��ü�� ����
		enermyList = new ArrayList<Enermy>();
		
		//���� 5�� ���� ����Ʈ�� ��´�.
		enermyList.add(new Enermy("enermy.png"));
		enermyList.add(new Enermy("enermy.png"));
		enermyList.add(new Enermy("enermy.png"));
		enermyList.add(new Enermy("enermy.png"));
		enermyList.add(new Enermy("enermy.png"));
				
		//enermy = new Enermy("enermy.png");				//�̹��� ���Ϸ� ���� ��ü ����
		spaceship = new SpaceShip("spaceship.png");
		missile = new Missile("missile.png");
		
		//�г��� ��������� ��,�̻���,���ּ��� ���� ���ÿ� �����̵��� �ϱ� ���Ͽ�
		//��Ƽ������� �����Ѵ�.
		//�̱���� �гο����� �ʿ��ϴ�.
		//�̷����� Ŭ������ Ŭ�����ȿ� ����� �ִ�.
		//�̰��� inner class��� �Ѵ�.
		class MyThread extends Thread{	//thread ��ӹ޾� ��ƼŬ���� ����
			public void run() {			//run �������̵��Ͽ� ���ÿ� �����ų ���ɾ� �ۼ�										//
				while(true) {	
					
					missile.update();
					
					//����Ʈ�� ��� ���� ����ŭ �ݺ��Ͽ� ���� ��ġ �����Ű��
					for(Enermy enermy:enermyList) {
						enermy.update();
						enermy.crush(missile);
					}
					
					repaint();	//����� ��ġ�� �ٽ� �׸���
								//ȭ�鿡 �׷����� �׷��ִ� �޼ҵ�� painComponent�ε�
								//����ڴ� repaint�� ȣ���Ͽ� �̸� ���۽�ų���ִ�. ����ȣ��x
					
					try {
						Thread.sleep(50);
					}catch(InterruptedException e) {
						
					}
				}
			}
		}
		Thread t = new MyThread(); //MyThread�� �θ� Thread�ϱ� ���� ����
		t.start();
	}
	@Override
	public void paintComponent(Graphics g) {	//ȭ�鿡 �׸��� �׸���.
		super.paintComponent(g);
		
		//�������� ���� ����ִ� ����Ʈ�� ����ŭ �ݺ��Ͽ� ���� �ٽ� �۹�
		for(Enermy enermy:enermyList) {
			enermy.draw(g); //�׷��Ƚ��� �����Ͽ� �̹����� �ٽ� �׸���.
		}
		spaceship.draw(g);	
		missile.draw(g);
	}
	
	@Override
	public void keyPressed(KeyEvent event) {	//Ű���� �̺�Ʈ ����
		// TODO Auto-generated method stub
		spaceship.keyPressed(event);
		missile.keyPressed(event,spaceship.x,spaceship.y);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}