package com.sist.product2;

public class Producer extends Thread{
	//��ǰ�� ���� Ŭ������ ��������� ����
	private Product product;
	
	public Producer(Product product) {
		this.product = product;
	}
	//�����尡 �ؾ��ϴ� ���� run�޼ҵ带 �������̵� �Ͽ� ���ش�.
	public void run() {
		//10���� ���ο� ��ǰ�� ����
		for(int i=1;i<=10;i++) {
			product.makeNumber();
			try {
				Thread.sleep(200);
			}catch(Exception e) {
				
			}
		}
	}
}
