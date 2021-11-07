package com.sist.net;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;

import javax.swing.*;

public class URLTestFrame extends JFrame implements ActionListener{
	
	JTextField jtf;
	
	JTextArea jta;
	
	public URLTestFrame() {
		//멤버변수 텍스트필드와 텍스트에리어 객체를 생성
		jtf = new JTextField(50);		//검색하고자하는 url입력하는 textField
		jta = new JTextArea();			//여러줄의 text입력
		
		//읽어오기를 수행시킬 버튼을 생성한다.
		JButton btn = new JButton("읽어오기");
		
		//텍스트필드와 버튼을 담기 위한 패널을 생성
		JPanel p = new JPanel();
		
		p.add(jtf);
		p.add(btn);
		
		//텍스트에리어를 감싸기 위한 스크롤팬을 생성
		JScrollPane jsp = new JScrollPane(jta);
		
		add(p, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
		setSize(800,600);
		
		setVisible(true);
		
		//버튼에 이벤트를 등록한다.
		btn.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new URLTestFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			//사용자가 입력한 인터넷주소를 읽어와서
			//인터넷상의 문서객체를 생성한다.
			URL url = new URL(jtf.getText());
			
			//그 문서의 내용을 읽어들이기 위하여 스트림을 생성합니다.
			InputStream is = url.openStream();
			
			//한번에 읽어들일 byte형의 배열을 만든다
			byte []data = new byte[100];
			
			//스트림을 통해 읽어온 문자열을 다 모아놓을 변수를 만든다.
			String str = "";
			
			//스트림의 끝이 아닐때까지 100바이트씩 읽어들인다.
			while(is.read(data) != -1) {
				//읽어드린 byte형을 문자열로 만들어서 누적한다.
				str += new String(data,"utf-8");
				//배열을 다시 읽어들이기 전에 깨끗이 비워준다
				//그렇지 않으면 맨끝에 이상한 쓰레기가 출력될 수 있다
				//byte형이 배열 data를 모두 0으로 초기화된다.
				//숫자 0이오면 자바는 int로 취급하기 때문에 byte로 형변환
				Arrays.fill(data,(byte)0);
			}
			jta.setText(str);
		
			is.close();
		
		}catch(Exception ex) {
			System.out.println("예외발생:"+ex.getMessage());
		}
		
	}
}
