package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcTest02 extends JFrame implements ActionListener{
	
	//계산결과를 출력할 텍스트필드를 멤버변수로 만든다.
	JTextField result;
	
	int num1;
	int num2;
	String op=""; //연산자

	public CalcTest02(){
		result = new JTextField();
		JPanel p = new JPanel();
		
		p.setLayout(new GridLayout(4,4));
		
		//16의 버튼에 표시될 문자열을 배열에 담는다.
		String []arr = {"7","8","9","+","4","5","6","-","1","2","3","*","0","c","=","/"};
		
		JButton []btn = new JButton[arr.length]; 
		
		//버튼배열 길이만큼 반복실행하여 버튼을 생성하여 패널에 담는다.
		for(int i=0;i<btn.length;i++) {
			btn[i] = new JButton(arr[i]);
			p.add(btn[i]);
			btn[i].addActionListener(this);
		}
		
		add(result,BorderLayout.NORTH);
		add(p,BorderLayout.CENTER);
		
		setSize(300,400);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CalcTest02();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//눌러진 버튼의 글자를 읽어온다.
		String cmd = e.getActionCommand();
		
		System.out.println(cmd);
		
		if(cmd.equals("+") || cmd.equals("-") || cmd.equals("*") || cmd.equals("/")) {
			
			if(!result.getText().equals("")) {	//입력된게 있으면
				num1 = Integer.parseInt(result.getText());//지금화면에 보이고 있는 숫자를 num1에 저장
				result.setText("");
			}
			//어떤 연산을 해야할지 변수op에 저장
			op = cmd;
			
		}else if(cmd.equals("=")) {
			//지금화면에 보이고 있는 숫자를 변수(num2)에 저장
			num2 = Integer.parseInt(result.getText());
			//그리고 op에 연산자의 종류에 따라 num1과 num2를 해당연산을 수행하여 result에 출력
			int total=0;
			switch(op) {
				case "+":total = num1+num2;break;
				case "-":total = num1-num2;break;
				case "*":total = num1*num2;break;
				case "/":total = num1/num2;break;
			}
			op=cmd;
			result.setText(total+"");
			
		}else if(cmd.equals("c")) {
			//지금 화면에 보이고 있는 숫자를 지운다.
			result.setText("");
		}else {
			if(op.equals("=")) {	//"="을 눌렀으면 다시 초기화해주기
				result.setText("");
				op="";
			}
			//눌러진 버튼의 글자를 텍스트필드에 계속 누적하여 출력
			result.setText(result.getText()+cmd);	
		}
		
	}

}
