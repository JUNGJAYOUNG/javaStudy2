package com.sist.db;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.sql.*;

public class DBTest extends JFrame {
	JTextField jtf_name;
	JTextField jtf_kor;
	JTextField jtf_eng;
	JTextField jtf_math;
	
	public DBTest() {
		jtf_name = new JTextField();
		jtf_kor = new JTextField();
		jtf_eng = new JTextField();
		jtf_math = new JTextField();
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,2));
		p.add(new JLabel("이름:"));
		p.add(jtf_name);
		p.add(new JLabel("국어:"));
		p.add(jtf_kor);
		p.add(new JLabel("영어:"));
		p.add(jtf_eng);
		p.add(new JLabel("수학:"));
		p.add(jtf_math);
		
		JButton btn = new JButton("추가");
		
		add(p,BorderLayout.CENTER);
		add(btn,BorderLayout.SOUTH);
		
		setSize(400,300);
		setVisible(true);
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name=jtf_name.getText();
				int kor=Integer.parseInt(jtf_kor.getText());
				int eng=Integer.parseInt(jtf_eng.getText());
				int math=Integer.parseInt(jtf_math.getText());
				
				String sql = "insert into student values("+"'"+name+"'"+","+kor+","
				+eng+","+math+")";
				
				System.out.println(sql);
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn =DriverManager.getConnection("jdbc:oracle:thin:@192.168.219.105:1521:XE","c##sist","sist");
					
					Statement stmt = conn.createStatement();
					int re = stmt.executeUpdate(sql);
					System.out.println("re:"+re);
					stmt.close();
					conn.close();
				}catch(Exception ex) {
					System.out.println("예외발생:"+ex.getMessage());
				}
			}
			
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DBTest();
	}

}
