package com.sist.inputoutput;

import java.io.FileReader;

public class ReadFile {
	public static void main(String[] args) {
		//�Ʊ� ������ hello.txt������ ������ �о� �鿩
		//ȭ�鿡 ����غ���
		//����Ʈ������ ����µ� �غ���
		try {
			FileReader fw = new FileReader("c:/myData/hello.txt");
			int c;
			while(true) {
				c=fw.read();	//read�޼ҵ�� ������ ��ȯ
				if(c==-1) {		//������ ���� �����ϸ�
					break;			
				}
				System.out.print((char)c);
			}
			fw.close();
			
		}catch(Exception e) {
			System.out.println("���ܹ߻�"+e.getMessage());
		}
	}
}
