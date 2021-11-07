package com.sist.net;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;

import javax.swing.*;

public class URLTestFrame extends JFrame implements ActionListener{
	
	JTextField jtf;
	
	JTextArea jta;
	
	public URLTestFrame() {
		//������� �ؽ�Ʈ�ʵ�� �ؽ�Ʈ������ ��ü�� ����
		jtf = new JTextField(50);		//�˻��ϰ����ϴ� url�Է��ϴ� textField
		jta = new JTextArea();			//�������� text�Է�
		
		//�о���⸦ �����ų ��ư�� �����Ѵ�.
		JButton btn = new JButton("�о����");
		
		//�ؽ�Ʈ�ʵ�� ��ư�� ��� ���� �г��� ����
		JPanel p = new JPanel();
		
		p.add(jtf);
		p.add(btn);
		
		//�ؽ�Ʈ����� ���α� ���� ��ũ������ ����
		JScrollPane jsp = new JScrollPane(jta);
		
		add(p, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
		setSize(800,600);
		
		setVisible(true);
		
		//��ư�� �̺�Ʈ�� ����Ѵ�.
		btn.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new URLTestFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			//����ڰ� �Է��� ���ͳ��ּҸ� �о�ͼ�
			//���ͳݻ��� ������ü�� �����Ѵ�.
			URL url = new URL(jtf.getText());
			
			//�� ������ ������ �о���̱� ���Ͽ� ��Ʈ���� �����մϴ�.
			InputStream is = url.openStream();
			
			//�ѹ��� �о���� byte���� �迭�� �����
			byte []data = new byte[100];
			
			//��Ʈ���� ���� �о�� ���ڿ��� �� ��Ƴ��� ������ �����.
			String str = "";
			
			//��Ʈ���� ���� �ƴҶ����� 100����Ʈ�� �о���δ�.
			while(is.read(data) != -1) {
				//�о�帰 byte���� ���ڿ��� ���� �����Ѵ�.
				str += new String(data,"utf-8");
				//�迭�� �ٽ� �о���̱� ���� ������ ����ش�
				//�׷��� ������ �ǳ��� �̻��� �����Ⱑ ��µ� �� �ִ�
				//byte���� �迭 data�� ��� 0���� �ʱ�ȭ�ȴ�.
				//���� 0�̿��� �ڹٴ� int�� ����ϱ� ������ byte�� ����ȯ
				Arrays.fill(data,(byte)0);
			}
			jta.setText(str);
		
			is.close();
		
		}catch(Exception ex) {
			System.out.println("���ܹ߻�:"+ex.getMessage());
		}
		
	}
}
