package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcTest extends JFrame implements ActionListener {

	//�μ��� �Է¹ޱ� ����, ����� ����ϱ� ���� �ؽ�Ʈ �ʵ带 ��������� ����
	JTextField jtf01;
	JTextField jtf02;
	JTextField jtf03;
	
	public CalcTest() {
		//�ؽ�Ʈ�ʵ� ��ü�� ����. �Ű������� ���� �ѹ��� �����ִ� ������ ��
		jtf01 = new JTextField(10);
		jtf02 = new JTextField(10);
		jtf03 = new JTextField(10);
		
		setLayout(new FlowLayout());
		
		//���ʴ�� �󺧰� ��ư�� �����Ͽ� �����ӿ� ��´�.
		add(new JLabel("��1:")); 
		add(jtf01);
		
		add(new JLabel("��2:")); 
		add(jtf02);
	
		JButton btnAdd = new JButton("���ϱ�");
		add(btnAdd);
		
		add(new JLabel("���:"));
		add(jtf03);
		
		setSize(600,200);
		setVisible(true);
		
		//��ư�� �̺�Ʈ�� ����մϴ�.
		btnAdd.addActionListener(this);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CalcTest();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//�ؽ�Ʈ�ʵ� jtf01�� jtf02�� ���� ���� �о�;���
		int num1=Integer.parseInt(jtf01.getText());
		int num2=Integer.parseInt(jtf02.getText());
		
		int result=num1+num2;
		jtf03.setText(result+"");
	}

}