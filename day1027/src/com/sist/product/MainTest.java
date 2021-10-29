package com.sist.product;

public class MainTest {
	public static void main(String[] args) {
	
		//"力前"按眉甫 积己
		Product product = new Product();
		//"积惑磊"静饭靛 按眉 积己
		Producer producer = new Producer(product);
		Consumer consumer = new Consumer(product);
		
		producer.start();
		consumer.start();
		
		
		
	}
	
}
