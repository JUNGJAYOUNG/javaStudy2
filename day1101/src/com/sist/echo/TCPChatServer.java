package com.sist.echo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class TCPChatServer {
	public static void main(String[] args) {
		
		//클라이언트로부터 수신된 데이터를 담기 위한 byte의 배열을 만든다
		byte [] data = new byte[100];

		try {
			//1. 
			ServerSocket server = new ServerSocket(9003);
			
			while(true) {	//무한대기 상태로 클라이언트의 접속 기다림
				
				//클라이언트의 요청을 수락한다.
				Socket socket = server.accept();
				
				//소켓객체를 통해 데이터를 주고 받을 스트리믕ㄹ 생성
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				//연결이 된 클라이언트와 계속하여 데이터를 주고받기 위하여 반복문 이용
				while(true) {
					//클라이언트로부터 데이터를 수신한다.
					is.read(data);
					String msg = new String(data);
					System.out.println("수신된 데이터:"+ msg.trim());
					
					//클라이언트로부터 수신된 데이터를 그대로 메아리
					os.write(data);
					//다음에 수신될 데이터를 위하여 배열을 깨끗이 비워준다.
					Arrays.fill(data,(byte)0);
				}
				
			}
		}catch(Exception e) {
			
		}
		
		
	}
}
