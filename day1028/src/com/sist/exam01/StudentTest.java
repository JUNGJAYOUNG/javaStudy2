package com.sist.exam01;

import java.io.FileReader;

public class StudentTest {

//�ؽ�Ʈ ������ ������ ��ǻ�� �޸𸮷� �о� ���̱� ����
//FileReader Ŭ������ �̿��Ѵ�.
//FileReader �����ڴ� "����"�� �����ִ�. �׷��� ����ó�� �ؾ��Ѵ�.
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("c:/myData/student.txt");
			
			String str="";
			
			int ch;
			while(true) {
				ch=fr.read();
				if(ch==-1) {
					break;
				}
				char data = (char)ch;	//'A'=>65
				str=str+data;
				
			}
			
			fr.close();
			System.out.println(str);
			
			String []arr = str.split(",");
			String name = arr[0];
			
			int kor = Integer.parseInt(arr[1]);
			int eng = Integer.parseInt(arr[2]);
			int math = Integer.parseInt(arr[3]);
			
			int tot = kor+eng+math;
			int avg = tot/3;
			
			System.out.println("�̸�:"+name);
			System.out.println("����:"+kor);
			System.out.println("����:"+eng);
			System.out.println("����:"+math);
			System.out.println("����:"+tot);
			System.out.println("���:"+avg);
			
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
	}	
	
}
