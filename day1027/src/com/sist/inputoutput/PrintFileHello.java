package com.sist.inputoutput;

import java.io.FileWriter;

public class PrintFileHello{
	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("c:/myData/hello.txt");
			fw.write("나의 이름은 홍길동이고\n");
			fw.write("나이는 20살입니다.");
			
			//파일의 사용이 끝나면 파일을 닫아주어야 한다.
			//닫아주지 않으면 지금당장 오류가 나지 않을 수 있지만
			//이파일을 다른곳에서도 써야한다면 
			fw.close();
			System.out.println("파일을 생성하였습니다.");
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}

	}	
}