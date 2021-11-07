package com.sist.game;

import javax.swing.*;
import java.util.Scanner;
import java.util.Random;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGame extends JFrame implements ActionListener{

	JTextField jtf_title;	//윈도우 제목란
	JTextField jtf_num;		//숫자 입력란
	JTextField jtf_hint;	//힌트 출력란
	int number;
	
	public NumberGame() {
		number = (int)(Math.random()*100);	//1~100까지의 랜덤 정수 생성
		
		JPanel p = new JPanel();
		
		jtf_title = new JTextField(40);
		jtf_num = new JTextField(25);
		jtf_hint = new JTextField(10);
		
		setLayout(new FlowLayout());
		
		p.setLayout(new FlowLayout());
		jtf_title.setText("숫자게임");
		
		add(jtf_title,BorderLayout.NORTH);
		
		add(new JLabel("숫자를 추측하시오:"));
		add(jtf_num,BorderLayout.CENTER);
		
		add(jtf_hint,BorderLayout.CENTER);
		
		JButton btn1 = new JButton("다시한번");
		JButton btn2 = new JButton("종료");
		
		p.add(btn1);
		p.add(btn2);

		add(p,BorderLayout.SOUTH);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		setSize(500,300);
		setVisible(true);
		
		//"창"을 닫을때 프로그램도 같이 종료
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//생성자
	
	public static void main(String[] args) {
		new NumberGame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		
		if(cmd.equals("다시한번")) {
			jtf_hint.setBackground(null);
			int input =Integer.parseInt(jtf_num.getText());
			if(input>number) {
				jtf_hint.setText("너무 높습니다.");
				jtf_hint.setBackground(Color.red);
			}else if(input<number) {
				jtf_hint.setText("너무 낮습니다.");
				jtf_hint.setBackground(Color.red);
			}else {
				jtf_hint.setText("정답입니다.");
			}
		}else if(cmd.equals("종료")){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
}
