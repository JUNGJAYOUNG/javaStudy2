package com.sist.exam02;

import java.io.FileWriter;

public class StudentTest {
	public static void main(String[] args) {
		Student lee = new Student("�̰ǿ�",100,100,100);
		try {
			FileWriter fw = new FileWriter("c:/myData/lee.txt");
			
			fw.write(lee.getName()+",");
			fw.write(lee.getKor()+",");
			fw.write(lee.getEng()+",");
			fw.write(lee.getMath()+"");
			
			fw.close();
			System.out.println("������ �����Ͽ����ϴ�.");
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
	}
}
