package com.sist.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class UDPReceiver {
	public static void main(String[] args) {
		
		//UDP방식에서 데이터를 주고받기 위해서는 DatagramSocket이 필요하다
		//DatagramSocket(int port)
		try {
			DatagramSocket socket = new DatagramSocket(9002);
			
			//보내오는 데이터를 담기위한 byte의 배열을 만든다
			byte []data = new byte[100];
			
			//Sender가 보내오는 데이터를 받기 위하여 DatagramPacket 객체를 생성한다.
			DatagramPacket packet = new DatagramPacket(data, data.length);
			
			
			System.out.println("Receiver가 동작중입니다.");
			//Sender가 보내오는 데이터를 계~속 받기 위하여 무한반복문으로 표현한다.
			while(true) {
				//DatagramSocket의 receive메소드를 통해 데이터를 받아요.
				socket.receive(packet);
				
				//진짜로 받아진 데이터는 byte의 배열인(패킷을 만들때 준 배열)data에 담아져 있따.
				//이것을 String생성자를 이용하여 문자열로 만든다
				String msg = new String(data);
				System.out.println("수신된 데이터:"+msg.trim());
				
				//다음의 수신되는 데이터를 위하여 data배열을 비워야 한다.
				Arrays.fill(data, (byte)0);
				
			}
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}
