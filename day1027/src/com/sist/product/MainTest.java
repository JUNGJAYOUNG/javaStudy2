package com.sist.product;

public class MainTest {
	public static void main(String[] args) {
	
		//"��ǰ"��ü�� ����
		Product product = new Product();
		//"������"������ ��ü ����
		Producer producer = new Producer(product);
		Consumer consumer = new Consumer(product);
		
		producer.start();
		consumer.start();
		
		
		
	}
	
}
