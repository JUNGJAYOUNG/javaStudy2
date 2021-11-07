package com.sist.homework;

import java.net.*;
import java.io.*;

public class TcpIpClient {
	public static void main(String[] args) {
		try {
			String serverIp = "127.0.0.1";
			System.out.println("서버에 연결중입니다. 서버 IP:"+serverIp);
			//소켓을 생성(연결하고자하는 서버IP, 포트번호)하여 연결을 요청한다.
			Socket socket = new Socket(serverIp, 7777); //서버정보 넣어서 소켓을 생성하면 자동으로 연결요청됨
			
			//소켓의 입력스트림을 얻는다.
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			//소켓으로부터 받은 데이터를 출력한다.
			System.out.println("서버로부터 받은 메세지:"+dis.readUTF());
			System.out.println("연결을 종료합니다.");
			
			dis.close();
			socket.close();
			System.out.println("연결이 종료되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}//try catch
	}//main
}//class
