package com.sist.homework;
import java.net.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class UdpServer {
	public void start() throws IOException{
		//포트 7777번을 사용하는 소켓을 생성한다.
		DatagramSocket socket = new DatagramSocket(7777);
		DatagramSocket inPacket, outPacket;
		
		byte[] inMsg = new byte[10];
		byte[] outMsg;
		while(true) {
			
		}
		
		
		
		
		
		
		
	}//start()
	public static void main(String[] args) {
		try {
			new UdpServer().start();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}//main
}
