package com.sist.exam03;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;


public class StudentTestObjectOutStream {
	public static void main(String[] args) {
		Student lee = new Student("�̰ǿ�",100,100,100);
		//����Ʈ����(��ü����)���
		try {
			//��ü������ ����ϱ� ���� ObjectOutputStream ��ü�� �����Ѵ�.
			//�̶� Ȯ���ڴ� ���α׷� ���ݿ� �µ��� �˸°� Ȯ���� �̸��� �����ش�.
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:/myData/lee.stu"));
			//��ü�� ����Ѵ�.
			oos.writeObject(lee);
			oos.close();
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
	}
}
