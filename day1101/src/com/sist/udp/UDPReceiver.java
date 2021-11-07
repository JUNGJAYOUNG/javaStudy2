package com.sist.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class UDPReceiver {
	public static void main(String[] args) {
		
		//UDP��Ŀ��� �����͸� �ְ�ޱ� ���ؼ��� DatagramSocket�� �ʿ��ϴ�
		//DatagramSocket(int port)
		try {
			DatagramSocket socket = new DatagramSocket(9002);
			
			//�������� �����͸� ������� byte�� �迭�� �����
			byte []data = new byte[100];
			
			//Sender�� �������� �����͸� �ޱ� ���Ͽ� DatagramPacket ��ü�� �����Ѵ�.
			DatagramPacket packet = new DatagramPacket(data, data.length);
			
			
			System.out.println("Receiver�� �������Դϴ�.");
			//Sender�� �������� �����͸� ��~�� �ޱ� ���Ͽ� ���ѹݺ������� ǥ���Ѵ�.
			while(true) {
				//DatagramSocket�� receive�޼ҵ带 ���� �����͸� �޾ƿ�.
				socket.receive(packet);
				
				//��¥�� �޾��� �����ʹ� byte�� �迭��(��Ŷ�� ���鶧 �� �迭)data�� ����� �ֵ�.
				//�̰��� String�����ڸ� �̿��Ͽ� ���ڿ��� �����
				String msg = new String(data);
				System.out.println("���ŵ� ������:"+msg.trim());
				
				//������ ���ŵǴ� �����͸� ���Ͽ� data�迭�� ����� �Ѵ�.
				Arrays.fill(data, (byte)0);
				
			}
			
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
	}
}
