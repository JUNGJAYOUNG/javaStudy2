package com.sist.exam01;

import java.io.FileReader;

public class StudentTest {

//텍스트 파일의 내용을 컴퓨터 메모리로 읽어 들이기 위해
//FileReader 클래스를 이용한다.
//FileReader 생성자는 "예외"를 갖고있다. 그래서 예외처리 해야한다.
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
			
			System.out.println("이름:"+name);
			System.out.println("국어:"+kor);
			System.out.println("영어:"+eng);
			System.out.println("수학:"+math);
			System.out.println("총점:"+tot);
			System.out.println("평균:"+avg);
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}	
	
}
