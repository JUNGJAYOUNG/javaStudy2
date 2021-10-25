package com.sist.exam03;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class NotRuntimeException {
	public static void main(String[] args) {
		/*
		try {
			FileWriter fw = new FileWriter("c:/work_day_1025/hello.txt");
			fw.write("안녕하세요.");
			fw.close();
		}catch(IOException e) {
			System.out.println("예외발생"+e.getMessage());
		}
		*/
		try {
			FileReader fr = new FileReader("c:/work_day_1025/hello.txt");
			int ch;
			while((ch=fr.read())!= -1){
				System.out.print((char)ch);
			}
			fr.close();
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	
	}
}
