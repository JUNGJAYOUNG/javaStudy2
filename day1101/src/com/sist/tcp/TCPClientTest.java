package com.sist.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClientTest {
	public static void main(String[] args) {
		try {
			//1.������ ����� ��û
			Socket socket = new Socket("localhost",9001);
			
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			for(int i=1;i<=10;i++) {
				int n = is.read();
				System.out.println("�����κ��� ���ŵ� ������:"+n);
				Thread.sleep(200);
			}
			//4. ����ߴ� �ڿ��� �ݾ��ش�
			is.close();
			os.close();
			socket.close();
			
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
	}
}
