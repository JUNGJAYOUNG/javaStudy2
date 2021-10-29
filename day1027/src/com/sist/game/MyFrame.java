package com.sist.game;

import javax.swing.JFrame;

//GUI(Graphic User Interface)프로그래밍에서
//"창"을 만들기 위해서는 JFrame을 상속받는다.
public class MyFrame extends JFrame{
	public MyFrame() {
		setTitle("My Game");	//창제목
		add(new MyPanel());		//팬널을 생성해서 담는다.
		setSize(500,500);		
		setVisible(true);		//프레임을 화면에 보이도록 설정
	}
	public static void main(String[] args) {
		new MyFrame();
	}
}
