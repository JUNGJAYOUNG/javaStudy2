package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;

public class FlowLayoutTest extends JFrame {
	
	public FlowLayoutTest() {
		
		//프레임에 FlowLayout을 설정한다.
		setLayout(new FlowLayout());
		
		//반복문을 이용하여 버튼 15개를 생성하여 프레임에 담아본다.
		for(int i=1;i<=15;i++) {
			add(new JButton("버튼"+i));
		}
		
		setSize(400,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FlowLayoutTest();
	}

}
