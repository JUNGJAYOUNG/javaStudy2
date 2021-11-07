package com.sist.db;

import java.sql.DriverManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

//gui로 만들어본다
//모든 학생의 목록을 텍스트에리어에 출력
//나머지 화면구성은 자유롭게

public class AllStudent extends JFrame implements ActionListener{
	JTextArea jta;
	JTextField jtf;
	
	public AllStudent() {
		jta = new JTextArea();
		JPanel p = new JPanel();
		jtf = new JTextField(10);
		
		setLayout(new BorderLayout());
		p.setLayout(new FlowLayout());
		
		JButton btn = new JButton("전체조회");
		JButton btn_clear = new JButton("초기화");
		JButton btn_search = new JButton("검색");
		
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
					
					//1.jdbc 드라이버를 메모리로 로드한다.
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					//2.db서버에 연결
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.219.105","c##sist","sist");
					
					//3.데이터베이스 명령을 실행할 Statement 객체를 생성
					Statement stmt = conn.createStatement();
					
					//4.데이터베이스 명령을 실행한다.
					ResultSet rs = stmt.executeQuery(sql);
					
					//레코드가 있는만큼 커서를 한 행씩 옮긴다.
					while(rs.next()) {
						String name= rs.getString(1);
						int kor = rs.getInt(2);
						int eng = rs.getInt(3);
						int math = rs.getInt(4);
						jta.append(name+","+kor+","+eng+","+math+"\n");	
					}
					
					//5.사용했던 자원들을 닫아준다.
					rs.close();
					stmt.close();
					conn.close();
					
				}catch(Exception ex) {
					System.out.println("예외발생:"+ex.getMessage());
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
