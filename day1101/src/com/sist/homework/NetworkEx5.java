package com.sist.homework;

import java.net.*;
import java.io.*;

public class NetworkEx5 {

	public static void main(String[] args) {
		URL url = null;
		InputStream in = null;
		FileOutputStream out = null;	//���Ϸ� ����ؼ� ����
		String address = "http://www.codechobo.com";
		
		int ch = 0;
		
		try {
			url = new URL(address);
			in = url.openStream();
			out = new FileOutputStream("javajungsuk3_arc.zip");	//workspace ������ ����
			
			while((ch=in.read()) != -1) {	//in.read() �Է½�Ʈ������ �ѱ��ھ� �о�ͼ� int������ ��ȯ�Ѵ� 
				out.write(ch);
			}
			in.close();	//��Ʈ���� ��� �ݾ��ش�.
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	//main

}
