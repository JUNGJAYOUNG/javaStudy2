package com.sist.net;

import java.io.InputStream;
import java.net.URL;

public class URLTest {
	public static void main(String[] args) {
		
		try {
			//인터넷상의 문서객체를 생성한다.
			URL url = new URL("https://www.hanbit.co.kr/");
			
			//그 문서의 내용을 읽어들이기 위하여 스트림을 생성합니다.
			InputStream is = url.openStream();
			
			//한번에 읽어들일 byte형의 배열을 만든다
			byte []data = new byte[100];
			
			//스트림을 통해 읽어온 문자열을 다 모아놓을 변수를 만든다.
			String str = "";
			
			//스트림의 끝이 아닐때까지 100바이트씩 읽어들인다.
			while(is.read(data) != -1) {
				//읽어드린 byte형을 문자열로 만들어서 누적한다.
				str += new String(data,"utf-8");
			}
			System.out.println(str);
			
			is.close();
		
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}
