package com.sist.db;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class GoodsTable extends JFrame{
	JTextField jtf_mdNum;	//상품번호
	JTextField jtf_name;	//상품명	
	JTextField jtf_quantity;//수량
	JTextField jtf_price;	//단가
	
	public GoodsTable() {
		
		jtf_mdNum = new JTextField(10);
		jtf_name = new JTextField(10);
		jtf_quantity = new JTextField(10);
		jtf_price = new JTextField(10);
		
		JPanel p = new JPanel();
		
		p.setLayout(new GridLayout(4,2));
	
		p.add(new JLabel("상품번호:"));
		p.add(jtf_mdNum);
		p.add(new JLabel("상품명:"));
		p.add(jtf_name);
		p.add(new JLabel("수량:"));
		p.add(jtf_quantity);
		p.add(new JLabel("단가:"));
		p.add(jtf_price);
		
		JButton btn = new JButton("추가");
		
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
					
					//1.jdbc 드라이버를 메모리로 로드한다.
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					//2.db서버에 연결
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.219.105:1521:XE","c##sist","sist");
					
					//3.데이터베이스 명령을 실행할 Statement 객체를 생성
					Statement stmt = conn.createStatement();
					
					//4.데이터베이스 명령을 실행한다.
					ResultSet rs = stmt.executeQuery(sql);
					
					//5.사용했던 자원들을 닫아준다.
					rs.close();
					stmt.close();
					conn.close();
					
				}catch(Exception ex) {
					System.out.println("예외발생:"+ex.getMessage());
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
