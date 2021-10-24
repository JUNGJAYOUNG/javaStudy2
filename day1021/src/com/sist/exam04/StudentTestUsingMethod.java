package com.sist.exam04;

import java.util.*;

public class StudentTestUsingMethod {
	public static Scanner sc = new Scanner(System.in);
	
	public static void printMenu() {
		System.out.println("1.�߰�,2.�˻�,3.����,4.������,5.��λ���,0.����");
		System.out.println("�޴��� �����ϼ���-->");
	}
	
	public static void insertStudent(ArrayList<Student> list) {
		String name,addr,phone;
		System.out.println("�л� �̸� �Է�:");
		name = sc.next();
		System.out.println("�л� �ּ� �Է�:");
		addr = sc.next();
		System.out.println("�л� �ڵ��� �Է�:");
		phone = sc.next();
		list.add(new Student(name,addr,phone));	
	}
	
	public static void searchStudent(ArrayList<Student> list) {
		String name;
		System.out.println("�˻��� �л��� �̸� �Է�:");
		name = sc.next();
		Student searchStudent = null;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getName().equals(name)) {
				searchStudent = list.get(i);
				break;
			}
		}
		if(searchStudent != null) {
			System.out.println(searchStudent);
		}else {
			System.out.println("ã�����ϴ� �л��� �����ϴ�.");
		}
	}
	
	public static void removeStudent(ArrayList<Student> list) {
		String name;
		System.out.println("������ �л��� �̸� �Է�:");
		name = sc.next();
		int i;
		int cnt = list.size();
		//�����ϱ� ���� ����Ʈ�� ũ�� �̸� ����
		for(i=0;i<list.size();i++) {
			if(list.get(i).getName().equals(name)) {
				list.remove(i); //.remove() ����
				break;
			}
		}
		if(i<cnt) {
			System.out.println(name+"�л��� �����͸� �����Ͽ����ϴ�.");
		}else {
			System.out.println("�����Ϸ��� �л� "+name+"�� �����ϴ�.");
		}					
	}
	
	public static void printArray(ArrayList<Student> list) {
		if(list.isEmpty()) {	//.isEmpty() ����Ʈ�� ����ִ��� Ȯ��
			System.out.println("�����Ͱ� �����ϴ�.");
		}else {
			for(Student student:list){	//ArrayList�� foreach�� ��� ����
				System.out.println(student);
			}
		}	
	}
	
	public static void main(String[] args) {
		
		ArrayList<Student> list = new ArrayList<Student>();
		
		String name,addr,phone;
		
		while(true) {
			System.out.println("1.�߰�,2.�˻�,3.����,4.������,5.��λ���,0.����");
			int menu=sc.nextInt();
			
			if(menu == 0) {
				break;
			}
			
			switch(menu) {
				case 1:insertStudent(list);break;
				case 2:searchStudent(list);break;
				case 3:removeStudent(list);break;
				case 4:printArray(list);break;
				case 5:list.clear();System.out.println("�����͸� ��� �����Ͽ����ϴ�.");break; //.clear()��� ����	
			}
		}	
		
		//main�޼ҵ� �ȿ� ��� ������ ��ó���� �� ����ְ� �Ǹ�
		//������(readability)�� ��������.
		//������ ��ü���� ��ó������ �޼ҵ忡�� �ñ��
		//main������ �ش� �޼ҵ带 ȣ���ϵ��� �����ϴ� ���� �������� ���̴� ����̴�.
		
		
	}
}
