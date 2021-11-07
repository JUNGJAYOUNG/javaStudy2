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
	
	//��ǻ�Ͱ� ������ ������ �����ϱ� ���� ������ ��������� ������
	int num;

	public NumberGuess() {
		
		//������ �ϳ� �����Ͽ� ������� num�� ����
		Random r = new Random();
		num = r.nextInt(100)+1;//0~99 +1 -> 1~100
		
		jtf= new JTextField(10);
		result = new JTextField("                 ���⿡ ��� ��Ÿ��                    ");
	
		setLayout(new FlowLayout());
		
		add(new JLabel("���ڸ� �����Ͻÿ�:"));
		add(jtf);
		add(result);
		
		//�� ���� ��ư ����
		JButton btn01 = new JButton("�ٽ� �ѹ�");
		JButton btn02 = new JButton("����");
		add(btn01);
		add(btn02);
		
		//�������� ũ��� ȭ�鿡 ���̵��� ����
		setSize(300,300);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);	//â ũ�������Ұ�
		
		//��ư�� �̺�Ʈ ���
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
		
		if(cmd.equals("�ٽ� �ѹ�")) {
			//��ǻ�Ͱ� �����ϰ� �ִ� ������ ����ڰ� �Է��� ���ڰ� �������� �Ǻ�
			
			//����ڰ� �Է��� ���� �������
			int user= Integer.parseInt(jtf.getText());
			
			//������, ��ū��, �� ������ �Ǻ��Ͽ� ��� ���
			if(user == num) {
				result.setText("                      �����Դϴ�!                    ");
			}else if(user > num) {
				result.setText("             �� ū ���ڸ� �Է��߾��!                    ");
				jtf.setText("");
				result.setBackground(Color.red);
			}else {
				result.setText("             �� ���� ���ڸ� �Է��߾��!                    ");
				jtf.setText("");
				result.setBackground(Color.red);
			}

		}else if(cmd.equals("����")) {
			System.exit(0);
		}
	}
	
}
