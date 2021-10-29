package com.sist.inputoutput;

import java.io.FileReader;

public class ReadFile {
	public static void main(String[] args) {
		//아까 생성한 hello.txt파일의 내용을 읽어 들여
		//화면에 출력해본다
		//바이트단위의 입출력도 해보기
		try {
			FileReader fw = new FileReader("c:/myData/hello.txt");
			int c;
			while(true) {
				c=fw.read();	//read메소드는 정수를 반환
				if(c==-1) {		//파일의 끝에 도달하면
					break;			
				}
				System.out.print((char)c);
			}
			fw.close();
			
		}catch(Exception e) {
			System.out.println("예외발생"+e.getMessage());
		}
	}
}
