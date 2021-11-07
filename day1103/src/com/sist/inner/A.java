package com.sist.inner;

public class A {
	public String title="hello";
	public void pro() {
		System.out.println("A클래스의 pro");
		//System.out.println(year);
		//outter클래스는 inner클래스의 멤버에 자유롭게 접근할 수 x
		//접근하려면 객체를 생성하고 객체를 통해서 접근할 수 있다.
		B ob = new B();		//outter클래스에서는 inner클래스의 객체를 생성해서 쓴다
		System.out.println(ob.year);
		ob.test();
	}
	
	class B{
		public int year = 2021;
		public void test() {
			System.out.println("B클래스의 test");
			System.out.println(title);	//inner클래스는 outter클래스의 멤버에 자유롭게 접근ok
		}
	}
	public static void main(String[] args) {
		A a = new A();
		a.pro();
	}
}
