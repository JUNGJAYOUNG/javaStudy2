package com.sist.exam07;

public class Person {
	private String name;
	public Person(String name) {
		this.name = name;
	}
	
	public void sayHello() {
		for(int i=1;i<=20;i++) {
			System.out.println("�ȳ�,"+name);
		}
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			
		}
	}
}
