package com.sist.chat;

import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.*;
public class ChatClient extends JFrame implements ActionListener{
	//��ȭ������ ����� �ؽ�Ʈ����� ��������� �����
	JTextArea jta;
	
	JTextField jtf;
	
	InputStream is;
	OutputStream os;
	
	public ChatClient() {
		//������� �ؽ�Ʈ������� �ؽ�Ʈ�ʵ带 ����
		jta = new JTextArea();
		jtf = new JTextField(50);
		
		
		//"����"�� ���� ��ư ����
		JButton btn = new JButton("����");
		
		//��ư�� �̺�Ʈ ���
		btn.addActionListener(this);
		
		//�ؽ�Ʈ�ʵ�� ��ư�� ������� �г��� ����
		JPanel p = new JPanel();
		
		//�г��� ���̾ƿ������ BorderLayout���� ����
		p.setLayout(new BorderLayout());
		
		p.add(jtf,BorderLayout.CENTER);
		p.add(btn,BorderLayout.EAST);
		
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
			Socket socket = new Socket("222.120.183.156",9003);
			
			//������� ���� ��Ʈ�� ����
			is = socket.getInputStream();
			os = socket.getOutputStream();
		}catch(Exception e) {
			
		}
		
	}

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

		//������ �������� �����͸� ����Ͽ� �ޱ� ���� ������ Ŭ���� ����
		//innerŬ����(Ŭ���� �ȿ��ִ� Ŭ����)
		//outterŬ����(�ٱ��� �ִ� Ŭ����)
		//innerŬ������ ��ġ outter Ŭ������ ���ó�� ����
		//outterŬ������ ����� �����Ӱ� ������ �� �յ�.
		class ClientThread implements Runnable {
		
			public void run() {
				
			}
		}//end innerClass
	
		//���� innerŬ������ ���鶧�� ��κ��� ���
		//Ŭ�����̸��� �������� �ʰ� �̸����� Ŭ������ �����ϸ鼭 
		//�ٷ� ��ü�� �����Ѵ�.
		//new �������̽��̸�(){ �޼ҵ��̸�(){}}
		//->�������̽��� ������ Ŭ������ �����ϰ� �ٷ� ��ü�� �����ض�!
		
		new Thread(new Runnable() {
			byte []data = new byte[100];
			@Override
			public void run() {
				while(true) {
					try {
						//������ ������ �����͸� �����Ѵ�.
						is.read(data);
						
						//������ �����͸� ���ڿ��� �����.
						String msg = new String(data);
						
						//������ ���ڿ��� �ؽ�Ʈ����� �߰��Ѵ�.
						jta.append(msg.trim()+"\n");
						
					}catch(Exception e) {
						System.out.println("���ܹ߻�:"+e.getMessage());
					}
				}//end while
				
			}
		}).start();
	}//end ������

	public static void main(String[] args) {
		new ChatClient();
	}

}
