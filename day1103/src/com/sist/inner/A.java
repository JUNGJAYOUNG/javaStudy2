package com.sist.inner;

public class A {
	public String title="hello";
	public void pro() {
		System.out.println("AŬ������ pro");
		//System.out.println(year);
		//outterŬ������ innerŬ������ ����� �����Ӱ� ������ �� x
		//�����Ϸ��� ��ü�� �����ϰ� ��ü�� ���ؼ� ������ �� �ִ�.
		B ob = new B();		//outterŬ���������� innerŬ������ ��ü�� �����ؼ� ����
		System.out.println(ob.year);
		ob.test();
	}
	
	class B{
		public int year = 2021;
		public void test() {
			System.out.println("BŬ������ test");
			System.out.println(title);	//innerŬ������ outterŬ������ ����� �����Ӱ� ����ok
		}
	}
	public static void main(String[] args) {
		A a = new A();
		a.pro();
	}
}
