package com.sist.exam03;

import java.util.ArrayList;

public class ArrayListTest {

	 public static void main(String[] args)
	 {
	  ArrayList list = new ArrayList(); //ArrayList ���
	  
	  list.add(100);
	  list.add("hello");
	  list.add(5.7);
	  list.add(1,500); //1�迭�� 1���ڸ��� 500�� �ְڴ�. hello�ڸ��� �з�����, 1���ڸ��� 500 �Ŀ� hello
	  
	  System.out.println(list); //toStringȣ�� (�̰��� �⺻)
	  list.set(1,777); //1���ڸ��� 777�� ����(500->777��)
	  System.out.println(list);
	  
	  list.remove(2); //2��°�� ���� hello
	  System.out.println(list);
	  System.out.println(list.get(0)); //����ù��°���� �˷��޶�. 100
	
	  list.clear(); //��ü����
	  System.out.println(list); // [ ]
	 }
}


