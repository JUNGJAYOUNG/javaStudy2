package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonTest02 extends JFrame {

	public JButtonTest02() {
		
		//버튼을 생성하여 "창"닫아보자
		JButton btn01 = new JButton("버튼1");
		JButton btn02 = new JButton("버튼2");
		
		add(btn01);
		add(btn02);
		
		//창의 크기를 설정
		setSize(400,300);
		setVisible(true);
		
		//"창"을 닫을때 프로그램도 같이 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		
		//우리가 만든 JButtonTest가 곧 JFrame이다.
		//변수이름을 굳이 줄 필요가 없을 것 같아요.
		//객체를 생성하기마 해도 좋을 거 같다.
		new JButtonTest02();
		
	}
}
