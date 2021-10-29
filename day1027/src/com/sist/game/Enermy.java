package com.sist.game;

import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Enermy extends GraphicObject {
	//���� x������ �����̴� ������ ���� ����
	//�� ó������ �����ʳ����� �������� �����̵��� �ϱ� ���Ͽ� ������ ����
	//int dx = -10;
	//int dy = 10;
	
	//���� �̵���θ� ������ �����
	int dx;
	int dy;
	
	//�����ÿ� "��"���� ǥ���� �׷��� �����̸��� �Ű������� ���޹޾� 
	//�θ�Ŭ������ �����ڿ��� �����Ѵ�.
	public Enermy(String name) {
		super(name);
		
		//�� ó���� ���α׷� �����Ͽ������� ���� ��ġ�� ������ ��ܿ� ��ġ��Ű�� ����
		//x=500;
		//y=0;
		
		//��ó�� ���� ��ġ�� ������ ����
		Random r = new Random();
		x=r.nextInt(500);
		y=r.nextInt(300);
		
		//���� �̵���ΰ��� �����ÿ� ������ �����
		//�̵��ϴ� �ּҰ�: 10
		//�̵��ϴ� �ִ밪: 100
		//� ������ ���� 90���� ���� ���������ٰ� 10�� ���ϸ� �ȴ�.
		
		
		dx=r.nextInt() % 30;
		dy=r.nextInt() % 30;
			
		if(dx>=0) {
			dx+=10;
		}else {
			dx-=10;
		}
		
		if(dy>=10) {
			dy+=10;
		}else {
			dy-=10;
		}
		
		System.out.println("dx:"+x);
		System.out.println("dy:"+y);
		
	}
	
	public void update() {
		
		//x��ǥ�� dx��ŭ �����Ŵ
		x+=dx;
		y+=dy;
		
		//x������ ���� ���������� ��ȣ�� �ٲ��ش�
		if(x<0 || x>500) {
			dx = dx * -1;
		}
		if(y<0 || y>300) {
			dy = dy * -1;
		}
		/*
		//���� ������ ���� �����ϸ� �ٽ� �������� �̵���Ű�� ���Ͽ� dx�� ������ �����.
		if(x>500) {
			dx = -10;
		}
		if(y>=300) {
			dy = -10;
		}
		if(y<0) {
			dy = 10;
		}
	*/	
	}
	
	//"��"(����)�� "�̻���"�� �¾Ҵ��� �Ǻ��ϴ� �޼ҵ� ����
	public void crush(Missile missile){
		//"��"�� "�̻���"�� �¾Ҵ��� �Ǻ�
		if(missile.x>=x && missile.x<=x+30 && missile.y>=y && missile.y<=y+30) {
			y=-1000;	
			
			//�Ҹ����� ��ü ����
			File file = new File("EXPLODE.WAV");
			try {
				//����� ������ �о���� ���� �غ�
				Clip clip = AudioSystem.getClip();
				//��������� �о����
				clip.open(AudioSystem.getAudioInputStream(file));
				//����� ���� ���
				clip.start();
			}catch(Exception e) {
				
			}
		}
		
	}	
}
