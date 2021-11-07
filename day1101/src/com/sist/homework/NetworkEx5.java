package com.sist.homework;

import java.net.*;
import java.io.*;

public class NetworkEx5 {

	public static void main(String[] args) {
		URL url = null;
		InputStream in = null;
		FileOutputStream out = null;	//파일로 출력해서 저장
		String address = "http://www.codechobo.com";
		
		int ch = 0;
		
		try {
			url = new URL(address);
			in = url.openStream();
			out = new FileOutputStream("javajungsuk3_arc.zip");	//workspace 폴더에 생김
			
			while((ch=in.read()) != -1) {	//in.read() 입력스트림에서 한글자씩 읽어와서 int형으로 반환한다 
				out.write(ch);
			}
			in.close();	//스트림을 모두 닫아준다.
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	//main

}
