package com.sist.db;

import java.sql.DriverManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

//gui�� ������
//��� �л��� ����� �ؽ�Ʈ����� ���
//������ ȭ�鱸���� �����Ӱ�

public class AllStudent extends JFrame implements ActionListener{
	JTextArea jta;
	JTextField jtf;
	
	public AllStudent() {
		jta = new JTextArea();
		JPanel p = new JPanel();
		jtf = new JTextField(10);
		
		setLayout(new BorderLayout());
		p.setLayout(new FlowLayout());
		
		JButton btn = new JButton("��ü��ȸ");
		JButton btn_clear = new JButton("�ʱ�ȭ");
		JButton btn_search = new JButton("�˻�");
		
		p.add(btn);
		p.add(btn_clear);
		p.add(jtf);
		p.add(btn_search);
		
		add(jta,BorderLayout.CENTER);
		add(p,BorderLayout.SOUTH);
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String sql = "select * from student";
					
					//1.jdbc ����̹��� �޸𸮷� �ε��Ѵ�.
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					//2.db������ ����
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.219.105","c##sist","sist");
					
					//3.�����ͺ��̽� ����� ������ Statement ��ü�� ����
					Statement stmt = conn.createStatement();
					
					//4.�����ͺ��̽� ����� �����Ѵ�.
					ResultSet rs = stmt.executeQuery(sql);
					
					//���ڵ尡 �ִ¸�ŭ Ŀ���� �� �྿ �ű��.
					while(rs.next()) {
						String name= rs.getString(1);
						int kor = rs.getInt(2);
						int eng = rs.getInt(3);
						int math = rs.getInt(4);
						jta.append(name+","+kor+","+eng+","+math+"\n");	
					}
					
					//5.����ߴ� �ڿ����� �ݾ��ش�.
					rs.close();
					stmt.close();
					conn.close();
					
				}catch(Exception ex) {
					System.out.println("���ܹ߻�:"+ex.getMessage());
				}
			}
			
		});
		
		btn_clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jta.setText("");	
			}
			
		});
		/*		
		btn_search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name=jtf.getText();
				if(name.equals(rs.getString(1)){
					
				}else {
					
				}
			}
		
		});
 		*/			
		setSize(500,500);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		new AllStudent();		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

}
