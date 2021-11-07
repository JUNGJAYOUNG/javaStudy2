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
	//UDP방식으로 데이터를 주고 받기 위해 선언
	DatagramSocket socket;
	DatagramPacket packet;
	
	//대화내용을 표시하기 위한 텍스트에리어를 멤버변수로 선언한다
	JTextArea jta;
	JTextField jtf;
	
	public UDPChatClient() {
		//멤버변수를 생성한다.
		jta = new JTextArea();
		jtf = new JTextField(50);
		
		//"전송"을 위한 버튼 생성
		JButton btn = new JButton("전송");
	
		//텍스트필드와 버튼을 담을 패널을 생성
		JPanel p = new JPanel();
		p.add(jtf);
		p.add(btn);
		
		//텍스트에리어에 스크롤을 표현하는 스크롤객체를 생성한디.
		JScrollPane jsp = new JScrollPane(jta);
		
		//프레임의 가운데에 텍스트에에리어를 감싸고 있는 스크롤팬을 담는다.
		add(jsp,BorderLayout.CENTER);
		add(p,BorderLayout.SOUTH);
		
		setSize(800,600);
		setVisible(true);
		
		try {
			//데이터를 주고 받기 위한 메소드를 갖고 있는 DatagramSocket 객체를 생성
			socket = new DatagramSocket();
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		//"전송"버튼에 이벤트를 등록하여 텍스트필드에 입력한 내용을 서버로 전송
		btn.addActionListener(this);
		
		//서버로부터 데이터를 계속하여 수신하기 위한 쓰레드클래스를 inner클래스로 만든다.
		class ClientThread implements Runnable{
			DatagramPacket packet;
			byte []data = new byte[100];
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				packet = new DatagramPacket(data, data.length);
				
				//계속하여 서버로부터 데이터를 수신하도록 합니다.
				while(true) {	//계속하여 서버로부터 데이터를 수신
					try {
						//데이터의 수신하기 위해서는 어떤 클래스의 어떤 메소드를 이용?
						socket.receive(packet);
						
						String msg = new String(data);
						
						//수신된 문자열을 텍스트에리어에 추가한다.
						jta.append(msg.trim() + "\n");
						
						//다음 데이터 수신을 위하여 배열을 지워준다.
						Arrays.fill(data, (byte)0);
					}catch(Exception e) {
						System.out.println("예외발생:"+e.getMessage());
					}
				}
				
				
			}//end run
			
		}//end inner클래스
		
		//쓰레드객체를 생성하고 쓰레드를 가동시킨다.
		new Thread(new ClientThread()).start();
		
		
	}//생성자 끝
	
	public static void main(String[] args) {
		new UDPChatClient();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			//사용자가 입력한 대화내용이 있는 텍스트필드의 문자열을 갖고 온다.
			String msg = jtf.getText();
			
			//UDP방식으로 데이터를 보내려면 패킷을 생성해야한다.
			//그래서 이 문자열을 byte[] 배열로 만들어야 한다.
			byte []data = msg.getBytes();
			
			InetAddress addr = InetAddress.getByName("192.168.219.105");
			
			int port = 9005;
			
			//데이터를 보낼 패킷을 생성합니다.
			packet = new DatagramPacket(data, data.length, addr, port);
			
			//데이터를 서버로 전송
			socket.send(packet);	//목적지 주소를 갖고 있는 패킷을 소켓으로 감싸서 보낸다
			
			
		}catch(Exception ex) {
			System.out.println("예외발생:"+ex.getMessage());
		}
		
	}
}
