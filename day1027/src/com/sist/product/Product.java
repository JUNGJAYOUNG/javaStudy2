package com.sist.product;

import java.util.Random;

//"������"�� "�Һ���"�� ������ "��ǰ"Ŭ������ �����.
public class Product {
	//����Ǵ� ��ǰ�� ������ ������� �Ѵ�.
	int number;
	//��ǰ�� ���� �����Ͽ����� �Һ��ϴ��� �Ǻ��ϱ� ���� ����
	public boolean isNew=false;
	
	//�����ڰ� ��ǰ�� �����ϰ� �մ� ���ȿ��� �Һ��ڰ� ������ �� ���� �ϱ� ���� �Ӱ迵������ ����
	public synchronized void makeNumber() {
		
		//���ο� ��ǰ(����)�� �����ϱ� ���� �Һ� �Ͼ������ �����·� �ֵ��� �Ѵ�.
		while(isNew == true) {
			try {
				wait();
			}catch(Exception e) {
				
			}
		}
		
		//���ο� ��ǰ(����)�� ������ �����.
		Random r = new Random();
		number = r.nextInt(100);	//���ο� ��ǰ ����
		System.out.println("�����ڰ� ���ο� ��ǰ ����");
		isNew = true;	//���ο� ��ǰ�� �����ߴٴ� ǥ��
		notify();	//������� ������(�Һ���)�� �ƿ��ش�.
	}
	
	//�Һ��ڰ� ����� ��ǰ�� �Һ��ϱ� ���� �޼ҵ带 ����
	public synchronized int getNumber() {
		
		//�����ڰ� ���ο� ��ǰ�� �����Ҷ����� �����·� �ֵ��� �Ѵ�.
		while(isNew==false) {
			try {
				wait();
			}catch(Exception e) {
			
			}
		}
		System.out.println("�Һ��ڰ� ��ǰ �Һ��� ==>"+number);
		isNew=false;
		notify();
		return number;
		
	}
}
