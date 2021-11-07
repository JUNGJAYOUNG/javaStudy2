package com.sist.game;

import javax.swing.*;
import java.util.Scanner;
import java.util.Random;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGame extends JFrame implements ActionListener{

	JTextField jtf_title;	//������ �����
	JTextField jtf_num;		//���� �Է¶�
	JTextField jtf_hint;	//��Ʈ ��¶�
	int number;
	
	public NumberGame() {
		number = (int)(Math.random()*100);	//1~100������ ���� ���� ����
		
		JPanel p = new JPanel();
		
		jtf_title = new JTextField(40);
		jtf_num = new JTextField(25);
		jtf_hint = new JTextField(10);
		
		setLayout(new FlowLayout());
		
		p.setLayout(new FlowLayout());
		jtf_title.setText("���ڰ���");
		
		add(jtf_title,BorderLayout.NORTH);
		
		add(new JLabel("���ڸ� �����Ͻÿ�:"));
		add(jtf_num,BorderLayout.CENTER);
		
		add(jtf_hint,BorderLayout.CENTER);
		
		JButton btn1 = new JButton("�ٽ��ѹ�");
		JButton btn2 = new JButton("����");
		
		p.add(btn1);
		p.add(btn2);

		add(p,BorderLayout.SOUTH);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		setSize(500,300);
		setVisible(true);
		
		//"â"�� ������ ���α׷��� ���� ����
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//������
	
	public static void main(String[] args) {
		new NumberGame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		
		if(cmd.equals("�ٽ��ѹ�")) {
			jtf_hint.setBackground(null);
			int input =Integer.parseInt(jtf_num.getText());
			if(input>number) {
				jtf_hint.setText("�ʹ� �����ϴ�.");
				jtf_hint.setBackground(Color.red);
			}else if(input<number) {
				jtf_hint.setText("�ʹ� �����ϴ�.");
				jtf_hint.setBackground(Color.red);
			}else {
				jtf_hint.setText("�����Դϴ�.");
			}
		}else if(cmd.equals("����")){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
}
