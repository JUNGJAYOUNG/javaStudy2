package com.sist.homework;

import java.io.*;
import java.net.*;
import java.util.Date;
import java.text.SimpleDateFormat;


public class TcpIpServer {
	
	public static void main(String[] args) {
		ServerSocket serverSocket=null;
	
		try {
			//���������� �����Ͽ� 7777�� ��Ʈ�� ����(bind)��Ų��.
			serverSocket=new ServerSocket(7777);
			System.out.println(getTime()+"������ �غ�Ǿ����ϴ�.");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		while(true) {	//Ŭ���̾�Ʈ ���α׷��� ��û�� ���������� ó���ϱ� ���� ���ѹݺ��� ��� -> ctrl+c ���������ؾ���
			try {
				System.out.println(getTime()+"�����û�� ��ٸ��ϴ�.");
				//���������� Ŭ���̾�Ʈ�� �����û�� �� ������ ������ ���߰� ��� ��ٸ���.
				//Ŭ���̾�Ʈ�� �����û�� ���� Ŭ���̾�Ʈ ���ϰ� ����� ���ο� ������ �����Ѵ�.
				Socket socket = serverSocket.accept();
				
				System.out.println(getTime() + socket.getInetAddress()+"�κ��� �����û�� ���Խ��ϴ�.");
				
				//������ ��½�Ʈ���� ��´�.
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				//���ݼ���(remote socket:Ŭ���̾�Ʈ�� ����)�� �����͸� ������.
				dos.writeUTF("[NOTICE] Test Message1 from Server");
				System.out.println(getTime()+"�����͸� �����߽��ϴ�.");
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		} //while

	}//main

	//����ð��� ���ڿ��� ��ȯ�ϴ� �Լ�
	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}

}//class
