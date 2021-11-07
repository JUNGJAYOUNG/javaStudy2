package com.sist.chat;

import java.net.*;
import java.io.*;

public class TcpIpClient5 {
	public static void main(String[] args) {
		try {
			String serverIp = "127.0.0.1";
			System.out.println("������ �������Դϴ�. ���� IP:"+serverIp);
			//������ ����(�����ϰ����ϴ� ����IP, ��Ʈ��ȣ)�Ͽ� ������ ��û�Ѵ�.
			Socket socket = new Socket(serverIp, 7777); //�������� �־ ������ �����ϸ� �ڵ����� �����û��
			
			System.out.println("������ ����Ǿ����ϴ�.");
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
		}catch(ConnectException ce) {
			ce.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}//try catch
	}//main
}//class
