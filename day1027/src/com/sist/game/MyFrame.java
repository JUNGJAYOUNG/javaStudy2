package com.sist.game;

import javax.swing.JFrame;

//GUI(Graphic User Interface)���α׷��ֿ���
//"â"�� ����� ���ؼ��� JFrame�� ��ӹ޴´�.
public class MyFrame extends JFrame{
	public MyFrame() {
		setTitle("My Game");	//â����
		add(new MyPanel());		//�ҳ��� �����ؼ� ��´�.
		setSize(500,500);		
		setVisible(true);		//�������� ȭ�鿡 ���̵��� ����
	}
	public static void main(String[] args) {
		new MyFrame();
	}
}
