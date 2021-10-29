package com.sist.exam02;

import java.io.FileWriter;

public class StudentTest {
	public static void main(String[] args) {
		Student lee = new Student("이건우",100,100,100);
		try {
			FileWriter fw = new FileWriter("c:/myData/lee.txt");
			
			fw.write(lee.getName()+",");
			fw.write(lee.getKor()+",");
			fw.write(lee.getEng()+",");
			fw.write(lee.getMath()+"");
			
			fw.close();
			System.out.println("파일을 생성하였습니다.");
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}
