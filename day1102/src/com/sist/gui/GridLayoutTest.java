package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class GridLayoutTest extends JFrame{
	
	public GridLayoutTest() {
		//프레임을 5행 3열인 그리드레이아웃으로 설정한다.
		setLayout(new GridLayout(5,3));
		
		//반복문을 이용하여 15개의 버튼을 생성하여 프레임에 담아본다.
		for(int i=1;i<=14;i++) {
			add(new JButton("버튼"+i));
		}
		
		setSize(400,300);
		setVisible(true);
	
	}
	
	
	public static void main(String[] args) {
		new GridLayoutTest();
	}
}
