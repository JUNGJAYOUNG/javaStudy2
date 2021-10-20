package com.sist.exam04;

class Person{
	private String name;
	private int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}

public class StringTestPerson {
	public static void main(String[] args) {
		Person []arr = {
				new Person("tiger",20),
				new Person("lion",21),
				new Person("Tiger",23),
				new Person(" Tiger",23),
				new Person("KIM",25)
		};
		//이름이 tiger인 사람이 모두 몇명인지 조사
		int cnt=0;
		for(Person p:arr) {
			if(p.getName().trim().equalsIgnoreCase("tiger"))
				cnt++;
		}
		System.out.println(cnt);
	}
}
