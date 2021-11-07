package com.sist.homework;

import java.net.*;
import java.io.*;

public class TcpIpClient {
	public static void main(String[] args) {
		try {
			String serverIp = "127.0.0.1";
			System.out.println("������ �������Դϴ�. ���� IP:"+serverIp);
			//������ ����(�����ϰ����ϴ� ����IP, ��Ʈ��ȣ)�Ͽ� ������ ��û�Ѵ�.
			Socket socket = new Socket(serverIp, 7777); //�������� �־ ������ �����ϸ� �ڵ����� �����û��
			
			//������ �Է½�Ʈ���� ��´�.
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			//�������κ��� ���� �����͸� ����Ѵ�.
			System.out.println("�����κ��� ���� �޼���:"+dis.readUTF());
			System.out.println("������ �����մϴ�.");
			
			dis.close();
			socket.close();
			System.out.println("������ ����Ǿ����ϴ�.");
		}catch(Exception e) {
			e.printStackTrace();
		}//try catch
	}//main
}//class
