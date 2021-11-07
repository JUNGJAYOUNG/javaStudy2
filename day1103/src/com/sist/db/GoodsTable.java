package com.sist.db;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class GoodsTable extends JFrame{
	JTextField jtf_mdNum;	//��ǰ��ȣ
	JTextField jtf_name;	//��ǰ��	
	JTextField jtf_quantity;//����
	JTextField jtf_price;	//�ܰ�
	
	public GoodsTable() {
		
		jtf_mdNum = new JTextField(10);
		jtf_name = new JTextField(10);
		jtf_quantity = new JTextField(10);
		jtf_price = new JTextField(10);
		
		JPanel p = new JPanel();
		
		p.setLayout(new GridLayout(4,2));
	
		p.add(new JLabel("��ǰ��ȣ:"));
		p.add(jtf_mdNum);
		p.add(new JLabel("��ǰ��:"));
		p.add(jtf_name);
		p.add(new JLabel("����:"));
		p.add(jtf_quantity);
		p.add(new JLabel("�ܰ�:"));
		p.add(jtf_price);
		
		JButton btn = new JButton("�߰�");
		
		add(p,BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String mdNum=jtf_mdNum.getText();
					String name = jtf_name.getText();
					int quantity = Integer.parseInt(jtf_quantity.getText());
					int price = Integer.parseInt(jtf_price.getText());
					
					String sql = "insert into goods values("+"'"+mdNum+"'"+","+"'"+name+"'"+","+quantity+ ","
							+ price+")";
					
					//1.jdbc ����̹��� �޸𸮷� �ε��Ѵ�.
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					//2.db������ ����
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.219.105:1521:XE","c##sist","sist");
					
					//3.�����ͺ��̽� ����� ������ Statement ��ü�� ����
					Statement stmt = conn.createStatement();
					
					//4.�����ͺ��̽� ����� �����Ѵ�.
					ResultSet rs = stmt.executeQuery(sql);
					
					//5.����ߴ� �ڿ����� �ݾ��ش�.
					rs.close();
					stmt.close();
					conn.close();
					
				}catch(Exception ex) {
					System.out.println("���ܹ߻�:"+ex.getMessage());
				}
			}
			
		});

		setSize(300,300);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GoodsTable();
	}

}
