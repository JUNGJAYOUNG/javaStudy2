package com.sist.gui;

import javax.swing.JFrame;

public class JButtonTest extends JFrame {

	public JButtonTest() {
		//창의 크기를 설정
		
	}
	
	public static void main(String[] args) {
		//우리가 만든 JButtonTest가 곧 JFrame이다.
		JButtonTest f = new JButtonTest();
		
		//창을 만들었지만 창이 화면에 보이지는 않는다.
		//보이게 하려면 창의 가로, 세로 길이를 설정하고 화면에 보이도록 설정해야함

		f.setSize(400,300);
		f.setVisible(true);
		
		//"창"을 닫을때 프로그램도 같이 종료
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
