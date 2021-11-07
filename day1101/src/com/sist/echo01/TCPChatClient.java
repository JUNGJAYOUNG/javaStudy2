package com.sist.echo01;

import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.*;
public class TCPChatClient extends JFrame implements ActionListener, Runnable {
	//��ȭ������ ����� �ؽ�Ʈ����� ��������� �����
	JTextArea jta;
	
	JTextField jtf;
	
	InputStream is;
	OutputStream os;
	
	public TCPChatClient() {
		//������� �ؽ�Ʈ������� �ؽ�Ʈ�ʵ带 ����
		jta = new JTextArea();
		jtf = new JTextField(50);
		
		
		//"����"�� ���� ��ư ����
		JButton btn = new JButton("����");
		
		//��ư�� �̺�Ʈ ���
		btn.addActionListener(this);
		
		//�ؽ�Ʈ�ʵ�� ��ư�� ������� �г��� ����
		JPanel p = new JPanel();
		p.add(jtf);
		p.add(btn);
		
		//�ؽ�Ʈ����� ��ũ�������� ���Ѵ�
		JScrollPane jsp = new JScrollPane(jta);
		
		//�����Ӱ���� �ؽ�Ʈ����� ���ΰ� �ִ� ��ũ������ ��´�.
		add(jsp,BorderLayout.CENTER);
		
		//�ؽ�Ʈ�ʵ�� ��ư�� ��� �ִ� �г��� �������� �Ʒ��� ��´�.
		add(p,BorderLayout.SOUTH);
		
		//������ ũ�� ����
		setSize(800,600);
		
		//������ ȭ�鿡 ���̵��� ����
		setVisible(true);
		
		try {
			//����� ���Ͽ� ������ ������ ��û�Ѵ�.
			Socket socket = new Socket("192.168.219.105",9003);
			
			//������� ���� ��Ʈ�� ����
			is = socket.getInputStream();
			os = socket.getOutputStream();
		}catch(Exception e) {
			
		}
		
		Thread t = new Thread(this);
		t.start();
		
	}//end ������

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			//����ڰ� �Է��� �ؽ�Ʈ�ʵ��� ������ ������ �������� �Ѵ�.
			//OutputStream  void write(byte[] b) �޼ҵ带 �̿�
			byte []data = jtf.getText().getBytes();
			os.write(data);
			
			//�޼����� �����ϰ� ���� �޼��� �Է��� ���Ͽ� �ؽ�Ʈ�ʵ带 �Ʋ��� ������
			jtf.setText("");
			
		}catch(Exception ex) {
			System.out.println("���ܹ߻�:"+ex.getMessage());
		}

	}//end ������

	public static void main(String[] args) {
		new TCPChatClient();
	}
	
	//�����κ��� ���ŵ� �����͸� ��� �޵��� �Ѵ�.
	@Override
	public void run() {
		// TODO Auto-generated method stub
		byte []data = new byte[100];
		while(true) {
			try {
				is.read(data);
				String msg = new String(data);
				msg = msg.trim();
				jta.append(msg+"\n");
			}catch(Exception e) {
				
			}//end catch
			
		}//end while
	}//end run

}
