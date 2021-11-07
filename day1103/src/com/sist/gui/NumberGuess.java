package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.Color;

public class NumberGuess extends JFrame implements ActionListener{
	
	JTextField jtf;
	
	JTextField result;
	
	//컴퓨터가 생각할 난수를 저장하기 위한 변수를 멤버변수로 성ㄴ언
	int num;

	public NumberGuess() {
		
		//난수를 하나 생성하여 멤버변수 num에 저장
		Random r = new Random();
		num = r.nextInt(100)+1;//0~99 +1 -> 1~100
		
		jtf= new JTextField(10);
		result = new JTextField("                 여기에 결과 나타남                    ");
	
		setLayout(new FlowLayout());
		
		add(new JLabel("숫자를 추측하시오:"));
		add(jtf);
		add(result);
		
		//두 개의 버튼 생성
		JButton btn01 = new JButton("다시 한번");
		JButton btn02 = new JButton("종료");
		add(btn01);
		add(btn02);
		
		//프레임의 크기와 화면에 보이도록 설정
		setSize(300,300);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);	//창 크기조절불가
		
		//버튼에 이벤트 등록
		btn01.addActionListener(this);
		btn02.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new NumberGuess();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		
		if(cmd.equals("다시 한번")) {
			//컴퓨터가 생각하고 있는 난수와 사용자가 입력한 숫자가 동일한지 판별
			
			//사용자가 입력한 숫자 갖고오기
			int user= Integer.parseInt(jtf.getText());
			
			//같은지, 더큰지, 더 작은지 판별하여 결과 출력
			if(user == num) {
				result.setText("                      정답입니다!                    ");
			}else if(user > num) {
				result.setText("             더 큰 숫자를 입력했어요!                    ");
				jtf.setText("");
				result.setBackground(Color.red);
			}else {
				result.setText("             더 작은 숫자를 입력했어요!                    ");
				jtf.setText("");
				result.setBackground(Color.red);
			}

		}else if(cmd.equals("종료")) {
			System.exit(0);
		}
	}
	
}
