package com.sist.inputoutput;

import java.io.FileWriter;

public class PrintFileHello{
	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("c:/myData/hello.txt");
			fw.write("���� �̸��� ȫ�浿�̰�\n");
			fw.write("���̴� 20���Դϴ�.");
			
			//������ ����� ������ ������ �ݾ��־�� �Ѵ�.
			//�ݾ����� ������ ���ݴ��� ������ ���� ���� �� ������
			//�������� �ٸ��������� ����Ѵٸ� 
			fw.close();
			System.out.println("������ �����Ͽ����ϴ�.");
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}

	}	
}