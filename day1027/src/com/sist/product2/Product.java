package com.sist.product2;

import java.util.Random;

//"������"�� "�Һ���"�� ������ "��ǰ"Ŭ������ �����.
public class Product {
	//����Ǵ� ��ǰ�� ������ ������� �Ѵ�.
	int number;
	//��ǰ�� ���� �����Ͽ����� �Һ��ϴ��� �Ǻ��ϱ� ���� ����
	public boolean isNew=false;
	
	//�����ڰ� ��ǰ�� �����ϰ� �մ� ���ȿ��� �Һ��ڰ� ������ �� ���� �ϱ� ���� �Ӱ迵������ ����
	public synchronized void makeNumber() {
		
		//���ο� ��ǰ(����)�� ������ �����.
		Random r = new Random();
		number = r.nextInt(100);	//���ο� ��ǰ ����
		System.out.println("�����ڰ� ���ο� ��ǰ ����");

	}
	
	//�Һ��ڰ� ����� ��ǰ�� �Һ��ϱ� ���� �޼ҵ带 ����
	public synchronized int getNumber() {
		
		System.out.println("�Һ��ڰ� ��ǰ �Һ��� ==>"+number);
		
		return number;
		
	}
}
