package com.sist.chat;

import java.net.*;
import java.io.*;

public class TcpIpClient5 {
	public static void main(String[] args) {
		try {
			String serverIp = "127.0.0.1";
			System.out.println("서버에 연결중입니다. 서버 IP:"+serverIp);
			//소켓을 생성(연결하고자하는 서버IP, 포트번호)하여 연결을 요청한다.
			Socket socket = new Socket(serverIp, 7777); //서버정보 넣어서 소켓을 생성하면 자동으로 연결요청됨
			
			System.out.println("서버에 연결되었습니다.");
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
