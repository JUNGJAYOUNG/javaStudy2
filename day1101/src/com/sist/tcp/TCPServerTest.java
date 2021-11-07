package com.sist.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServerTest {
	public static void main(String[] args) {
		
		Random r = new Random();
		
		try {
			//1. 서버소켓을 생성한다.
			ServerSocket server = new ServerSocket(9001);
		
			System.out.println("서버가 가동되었습니다.");
			//2. 클라이언트의 접속을 무한대기상태로 기다린다.
			while(true) {
				Socket socket = server.accept();
				System.out.println("클라이언트가 접속하였습니다.");
				//4. 데이터를 주고 받을 스트림을 생성
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				Thread.sleep(1000);
				
				//5.스트림을 통해 데이터를 주고 받는다
				//요청한 클라이언트한테 10개의 정수를 난수로 만들어 내보낸다.
				for(int i=1;i<=10;i++) {
					int n=r.nextInt(100);
					//0에서 100사이의 난수를 만든다.
					
					System.out.println("서버가 난수 하나를 만들었습니다."+n);
				
					//1초 대기시간을 준다
					Thread.sleep(1000);
					
					//그 난수를 클라이언트에게 출력
					os.write(n);
					
				}
				System.out.println("클라이언트에게 데이터를 모두 내보냈습니다.");
				//4. 사용했던 자원들을 닫아준다
				is.close();
				os.close();
				socket.close();
			}
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}
