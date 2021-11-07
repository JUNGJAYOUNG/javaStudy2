package com.sist.chat;

import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.*;
public class ChatClient extends JFrame implements ActionListener{
	//대화내용을 출력할 텍스트에리어를 멤버변수로 만든다
	JTextArea jta;
	
	JTextField jtf;
	
	InputStream is;
	OutputStream os;
	
	public ChatClient() {
		//멤버변수 텍스트에리어와 텍스트필드를 생성
		jta = new JTextArea();
		jtf = new JTextField(50);
		
		
		//"전송"을 위한 버튼 생성
		JButton btn = new JButton("전송");
		
		//버튼에 이벤트 등록
		btn.addActionListener(this);
		
		//텍스트필드와 버튼을 담기위한 패널을 생성
		JPanel p = new JPanel();
		
		//패널의 레이아웃방식을 BorderLayout으로 변경
		p.setLayout(new BorderLayout());
		
		p.add(jtf,BorderLayout.CENTER);
		p.add(btn,BorderLayout.EAST);
		
		//텍스트에리어를 스크롤팬으로 감싼다
		JScrollPane jsp = new JScrollPane(jta);
		
		//프레임가운데에 텍스트에리어를 감싸고 있는 스크롤팬을 담는다.
		add(jsp,BorderLayout.CENTER);
		
		//텍스트필드와 버튼을 담고 있는 패널을 프레임의 아래에 담는다.
		add(p,BorderLayout.SOUTH);
		
		//프레임 크기 설정
		setSize(800,600);
		
		//프레임 화면에 보이도록 설정
		setVisible(true);
		
		try {
			//통신을 위하여 서버에 접속을 요청한다.
			Socket socket = new Socket("222.120.183.156",9003);
			
			//입출력을 위한 스트림 생성
			is = socket.getInputStream();
			os = socket.getOutputStream();
		}catch(Exception e) {
			
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			//사용자가 입력한 텍스트필드의 내용을 서버로 보내도록 한다.
			//OutputStream  void write(byte[] b) 메소드를 이용
			byte []data = jtf.getText().getBytes();
			os.write(data);
			
			//메세지를 전송하고 다음 메세지 입력을 위하여 텍스트필드를 꺠끗히 지워라
			jtf.setText("");
			
		}catch(Exception ex) {
			System.out.println("예외발생:"+ex.getMessage());
		}

		//서버가 보내오는 데이터를 계속하여 받기 위한 쓰레드 클래스 생성
		//inner클래스(클래스 안에있는 클래스)
		//outter클래스(바깥에 있는 클래스)
		//inner클래스는 마치 outter 클래스의 멤버처럼 동작
		//outter클래스의 멤버에 자유롭게 접근할 수 잇따.
		class ClientThread implements Runnable {
		
			public void run() {
				
			}
		}//end innerClass
	
		//보통 inner클래스를 만들때는 대부분의 경우
		//클래스이름을 정해주지 않고 이름없는 클래스로 정의하면서 
		//바로 객체를 생성한다.
		//new 인터페이스이름(){ 메소드이름(){}}
		//->인터페이스를 구현한 클래스를 정의하고 바로 객체를 생성해라!
		
		new Thread(new Runnable() {
			byte []data = new byte[100];
			@Override
			public void run() {
				while(true) {
					try {
						//서버가 보내온 데이터를 수신한다.
						is.read(data);
						
						//수신한 데이터를 문자열로 만든다.
						String msg = new String(data);
						
						//수신한 문자열을 텍스트에리어에 추가한다.
						jta.append(msg.trim()+"\n");
						
					}catch(Exception e) {
						System.out.println("예외발생:"+e.getMessage());
					}
				}//end while
				
			}
		}).start();
	}//end 생성자

	public static void main(String[] args) {
		new ChatClient();
	}

}
