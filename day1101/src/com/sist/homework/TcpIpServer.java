package com.sist.homework;

import java.io.*;
import java.net.*;
import java.util.Date;
import java.text.SimpleDateFormat;


public class TcpIpServer {
	
	public static void main(String[] args) {
		ServerSocket serverSocket=null;
	
		try {
			//서버소켓을 생성하여 7777번 포트와 결합(bind)시킨다.
			serverSocket=new ServerSocket(7777);
			System.out.println(getTime()+"서버가 준비되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		while(true) {	//클라이언트 프로그램의 요청을 지속적으로 처리하기 위해 무한반복문 사용 -> ctrl+c 강제종료해야함
			try {
				System.out.println(getTime()+"연결요청을 기다립니다.");
				//서버소켓은 클라이언트의 연결요청이 올 때까지 실행을 멈추고 계속 기다린다.
				//클라이언트의 연결요청이 오면 클라이언트 소켓과 통신할 새로운 소켓을 생성한다.
				Socket socket = serverSocket.accept();
				
				System.out.println(getTime() + socket.getInetAddress()+"로부터 연결요청이 들어왔습니다.");
				
				//소켓의 출력스트림을 얻는다.
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				//원격소켓(remote socket:클라이언트의 소켓)에 데이터를 보낸다.
				dos.writeUTF("[NOTICE] Test Message1 from Server");
				System.out.println(getTime()+"데이터를 전송했습니다.");
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		} //while

	}//main

	//현재시간을 문자열로 반환하는 함수
	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}

}//class
