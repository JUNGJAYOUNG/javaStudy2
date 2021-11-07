package com.sist.echo01;

import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.*;
public class TCPChatClient extends JFrame implements ActionListener, Runnable {
	//대화내용을 출력할 텍스트에리어를 멤버변수로 만든다
	JTextArea jta;
	
	JTextField jtf;
	
	InputStream is;
	OutputStream os;
	
	public TCPChatClient() {
		//멤버변수 텍스트에리어와 텍스트필드를 생성
		jta = new JTextArea();
		jtf = new JTextField(50);
		
		
		//"전송"을 위한 버튼 생성
		JButton btn = new JButton("전송");
		
		//버튼에 이벤트 등록
		btn.addActionListener(this);
		
		//텍스트필드와 버튼을 담기위한 패널을 생성
		JPanel p = new JPanel();
		p.add(jtf);
		p.add(btn);
		
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
			Socket socket = new Socket("192.168.219.105",9003);
			
			//입출력을 위한 스트림 생성
			is = socket.getInputStream();
			os = socket.getOutputStream();
		}catch(Exception e) {
			
		}
		
		Thread t = new Thread(this);
		t.start();
		
	}//end 생성자

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

	}//end 생성자

	public static void main(String[] args) {
		new TCPChatClient();
	}
	
	//서버로부터 수신된 데이터를 계속 받도록 한다.
	@Override
	public void run() {
		// TODO Auto-generated method stub
		byte []data = new byte[100];
		while(true) {
			try {
				is.read(data);
				String msg = new String(data);
				msg = msg.trim();
				jta.append(msg+"\n");
			}catch(Exception e) {
				
			}//end catch
			
		}//end while
	}//end run

}
