package com.sist.exam03;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;


public class StudentTestObjectOutStream {
	public static void main(String[] args) {
		Student lee = new Student("이건우",100,100,100);
		//바이트단위(객체단위)출력
		try {
			//객체단위로 출력하기 위한 ObjectOutputStream 객체를 생성한다.
			//이때 확장자는 프로그램 성격에 맞도록 알맞게 확장자 이름을 정해준다.
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:/myData/lee.stu"));
			//객체를 출력한다.
			oos.writeObject(lee);
			oos.close();
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}
