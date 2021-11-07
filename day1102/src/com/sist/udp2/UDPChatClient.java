package com.sist.udp2;

import javax.swing.JFrame;
import java.net.*;
import java.util.Arrays;
import java.io.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UDPChatClient extends JFrame implements ActionListener{
	//UDP������� �����͸� �ְ� �ޱ� ���� ����
	DatagramSocket socket;
	DatagramPacket packet;
	
	//��ȭ������ ǥ���ϱ� ���� �ؽ�Ʈ����� ��������� �����Ѵ�
	JTextArea jta;
	JTextField jtf;
	
	public UDPChatClient() {
		//��������� �����Ѵ�.
		jta = new JTextArea();
		jtf = new JTextField(50);
		
		//"����"�� ���� ��ư ����
		JButton btn = new JButton("����");
	
		//�ؽ�Ʈ�ʵ�� ��ư�� ���� �г��� ����
		JPanel p = new JPanel();
		p.add(jtf);
		p.add(btn);
		
		//�ؽ�Ʈ����� ��ũ���� ǥ���ϴ� ��ũ�Ѱ�ü�� �����ѵ�.
		JScrollPane jsp = new JScrollPane(jta);
		
		//�������� ����� �ؽ�Ʈ������� ���ΰ� �ִ� ��ũ������ ��´�.
		add(jsp,BorderLayout.CENTER);
		add(p,BorderLayout.SOUTH);
		
		setSize(800,600);
		setVisible(true);
		
		try {
			//�����͸� �ְ� �ޱ� ���� �޼ҵ带 ���� �ִ� DatagramSocket ��ü�� ����
			socket = new DatagramSocket();
			
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
		
		//"����"��ư�� �̺�Ʈ�� ����Ͽ� �ؽ�Ʈ�ʵ忡 �Է��� ������ ������ ����
		btn.addActionListener(this);
		
		//�����κ��� �����͸� ����Ͽ� �����ϱ� ���� ������Ŭ������ innerŬ������ �����.
		class ClientThread implements Runnable{
			DatagramPacket packet;
			byte []data = new byte[100];
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				packet = new DatagramPacket(data, data.length);
				
				//����Ͽ� �����κ��� �����͸� �����ϵ��� �մϴ�.
				while(true) {	//����Ͽ� �����κ��� �����͸� ����
					try {
						//�������� �����ϱ� ���ؼ��� � Ŭ������ � �޼ҵ带 �̿�?
						socket.receive(packet);
						
						String msg = new String(data);
						
						//���ŵ� ���ڿ��� �ؽ�Ʈ����� �߰��Ѵ�.
						jta.append(msg.trim() + "\n");
						
						//���� ������ ������ ���Ͽ� �迭�� �����ش�.
						Arrays.fill(data, (byte)0);
					}catch(Exception e) {
						System.out.println("���ܹ߻�:"+e.getMessage());
					}
				}
				
				
			}//end run
			
		}//end innerŬ����
		
		//�����尴ü�� �����ϰ� �����带 ������Ų��.
		new Thread(new ClientThread()).start();
		
		
	}//������ ��
	
	public static void main(String[] args) {
		new UDPChatClient();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			//����ڰ� �Է��� ��ȭ������ �ִ� �ؽ�Ʈ�ʵ��� ���ڿ��� ���� �´�.
			String msg = jtf.getText();
			
			//UDP������� �����͸� �������� ��Ŷ�� �����ؾ��Ѵ�.
			//�׷��� �� ���ڿ��� byte[] �迭�� ������ �Ѵ�.
			byte []data = msg.getBytes();
			
			InetAddress addr = InetAddress.getByName("192.168.219.105");
			
			int port = 9005;
			
			//�����͸� ���� ��Ŷ�� �����մϴ�.
			packet = new DatagramPacket(data, data.length, addr, port);
			
			//�����͸� ������ ����
			socket.send(packet);	//������ �ּҸ� ���� �ִ� ��Ŷ�� �������� ���μ� ������
			
			
		}catch(Exception ex) {
			System.out.println("���ܹ߻�:"+ex.getMessage());
		}
		
	}
}
