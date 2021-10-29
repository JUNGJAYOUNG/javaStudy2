package com.sist.exam03;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class StudentTestObjectInputStream {
	//c:/myData/lee.stu 파일을 읽어들여
	//객체의 정보를 화면에 출력
	
	public static void main(String[] args) {
		//바이트단위(객체단위)출력
		try {//객체단위로 입력을 위한 객체를 생성
			ObjectInputStream oos = new ObjectInputStream(new FileInputStream("c:/myData/lee.stu"));
			//파일로부터 객체를 읽어 들여 객체참조변수에 저장
			Student lee = (Student)oos.readObject();	//readObject는 Object형으로 받아서 캐스팅 해줘야한다.
			
			System.out.println("이름:"+lee.getName());
			System.out.println("국어:"+lee.getKor());
			System.out.println("영어:"+lee.getEng());
			System.out.println("수학:"+lee.getMath());
			
			oos.close();
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}
