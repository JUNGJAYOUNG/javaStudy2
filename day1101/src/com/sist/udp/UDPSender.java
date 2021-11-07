package com.sist.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSender {
	public static void main(String[] args) {
		String ip = args[0];
		String msg = args[1];
		
		//데이터를 주고받기 위해서 DatagramSocket 객체를 생성한다.
		//DatagramSocket(int port)
		
		try {
			DatagramSocket socket = new DatagramSocket();
			
			//목적지의 주소 ip를 갖고 InetAddress 객체를 생성한다.
			InetAddress addr = InetAddress.getByName(ip);
			
			//전송하고자 하는 문자열 msg를 byte의 배열로 만든다.
			byte[]data = msg.getBytes();
			
			//UDP방식의 데이터전송단위 패킷을 생성한다.
			DatagramPacket packet = new DatagramPacket(data, data.length,addr, 9002);
			
			//DatagramSocket의 send메소드를 통해 데이터를 전송한다.
			socket.send(packet);
			
			socket.close();
			
		}catch(Exception e) {
			System.out.println("예외발생"+e.getMessage());
		}
		
	}
}
