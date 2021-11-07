package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class BorderLayoutTest extends JFrame {
	public BorderLayoutTest() {
		setLayout(new BorderLayout());
		add(new JButton("위"),BorderLayout.NORTH);
		//add(new JButton("아래"),BorderLayout.SOUTH);
		//add(new JButton("좌"),BorderLayout.WEST);
		add(new JButton("우"),BorderLayout.EAST);
		add(new JButton("가운데"),BorderLayout.CENTER);
		
		setSize(400,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new BorderLayoutTest();
	}
}
