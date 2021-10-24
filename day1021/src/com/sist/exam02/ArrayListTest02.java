package com.sist.exam02;
import java.util.*;

class Person{
	private String name;
	private int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
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
	public void sayHello() {
		System.out.println(name+"님, 안녕하세요.");
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}

public class ArrayListTest02 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(true);
		list.add(new Person("홍길동",20));
		list.add(new Person("이순신",40));
		list.add(26.7);
		list.add(new Person("유관순",30));
		
		//list의 길이는 size()라는 메소드 사용
		for(int i=0;i<list.size();i++) {
			Object obj = list.get(i);
			System.out.println(obj);
			if(obj instanceof Person) { //obj가 Person형인지 확인하고 캐스팅해야한다.
				((Person)obj).sayHello();
			}
			//Person p=(Person) list.get(i);
			//p.sayHello();
		}
		
	}
}
