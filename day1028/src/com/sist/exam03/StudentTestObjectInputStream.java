package com.sist.exam03;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class StudentTestObjectInputStream {
	//c:/myData/lee.stu ������ �о�鿩
	//��ü�� ������ ȭ�鿡 ���
	
	public static void main(String[] args) {
		//����Ʈ����(��ü����)���
		try {//��ü������ �Է��� ���� ��ü�� ����
			ObjectInputStream oos = new ObjectInputStream(new FileInputStream("c:/myData/lee.stu"));
			//���Ϸκ��� ��ü�� �о� �鿩 ��ü���������� ����
			Student lee = (Student)oos.readObject();	//readObject�� Object������ �޾Ƽ� ĳ���� ������Ѵ�.
			
			System.out.println("�̸�:"+lee.getName());
			System.out.println("����:"+lee.getKor());
			System.out.println("����:"+lee.getEng());
			System.out.println("����:"+lee.getMath());
			
			oos.close();
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
	}
}
