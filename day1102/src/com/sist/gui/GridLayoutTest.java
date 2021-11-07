package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class GridLayoutTest extends JFrame{
	
	public GridLayoutTest() {
		//�������� 5�� 3���� �׸��巹�̾ƿ����� �����Ѵ�.
		setLayout(new GridLayout(5,3));
		
		//�ݺ����� �̿��Ͽ� 15���� ��ư�� �����Ͽ� �����ӿ� ��ƺ���.
		for(int i=1;i<=14;i++) {
			add(new JButton("��ư"+i));
		}
		
		setSize(400,300);
		setVisible(true);
	
	}
	
	
	public static void main(String[] args) {
		new GridLayoutTest();
	}
}
