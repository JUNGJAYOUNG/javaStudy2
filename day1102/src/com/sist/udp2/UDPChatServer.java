package com.sist.udp2;

import javax.swing.JButton;
import javax.swing.*;
import java.net.*;
import java.util.Arrays;
import java.io.*;

public class UDPChatServer extends JFrame {
	//UDP������� �����͸� �ְ�ޱ� ���� 
	DatagramSocket socket;
	DatagramPacket packet;

	
	public UDPChatServer() {
		try {
			socket = new DatagramSocket(9005);
			
			//Ŭ���̾�Ʈ�κ��� ���ŵǴ� �����͸� ��� ���� byte�� �迭�� ��Ŷ�� ����
			byte []data = new byte[100];
			packet = new DatagramPacket(data, data.length);

			//���Ѵ����·� Ŭ���̾�Ʈ�� ������ �����͸� �״�� �޾Ƹ� �ϵ��� �Ѵ�.
			while(true) {
				
				//Ŭ���̾�Ʈ�κ��� �����͸� �����Ѵ�.
				//�޾ƿö��� �������� InetAddress�� ����־��! 
				socket.receive(packet);
				
				//Ŭ���̾�Ʈ�� ������ �����͸� ����غ���
				String msg = new String(data);
				System.out.println("���ŵ� ������:"+msg.trim());

				//��Ŷ�ȿ� ��� ���������� InetAddress�� Ȯ���غ���
				InetAddress addr = packet.getAddress();
				System.out.println("���������� �ּ�:"+addr);
				
				//�� ��Ŷ�� �״�� �޾Ƹ��Ѵ�.
				socket.send(packet);
				
				//���� �����͸� �����ϵ��� �迭�� ������ ����ݴϴ�.
				Arrays.fill(data, (byte)0);
				
			}
			
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		new UDPChatServer();
	}
	
}
