package com.sist.product2;

public class Consumer extends Thread{
	
	private Product product; //��ǰ�� ���� Ŭ������ ��������� �����Ѵ�.
	//�� ��ǰ��ü�� �����ڰ� ���� �մ� ��ǰ�� ������ ��ü -> �����ڿ�
	
	public Consumer(Product product) {
		this.product=product;
	}
	//�����尡 �ؾ��� ���� run�� �������̵��Ͽ� ���ش�.
	public void run() {
		//�ݺ������Ͽ� 10���� ��ǰ�� ����ϵ��� �Ѵ�.
		for(int i=0;i<=10;i++) {
			product.getNumber(); //��ǰ�� �Һ��ϱ� ���� getNumber�޼ҵ� ȣ��
			
		}
	}
}
