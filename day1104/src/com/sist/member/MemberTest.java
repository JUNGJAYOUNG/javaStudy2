package com.sist.member;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

public class MemberTest extends JFrame {

	JTextField jtf_no;		//회원번호
	JTextField jtf_name;	//이름
	JTextField jtf_address;	//주소
	JTextField jtf_age;		//나이
	JTextField jtf_phone;	//전화번호
	
	JTable table;
	Vector colNames;	//테이블의 컬럼이름
	Vector<Vector> rowData;	//테이블의 레코드를 위한 벡터 선언
	
	public MemberTest() {
		//테이블에 들어갈 컬럼이름을 위한 벡터 생성하고 컬럼이름 추가
		colNames = new Vector<String>();
		colNames.add("회원번호");
		colNames.add("회원이름");
		colNames.add("주소");
		colNames.add("나이");
		colNames.add("전화번호");
		
		//테이블의 실제 데이터를 담기 위한 벡터 생성
		rowData = new Vector<Vector>();
		//행,열 벡터로 테이블 생성
		table = new JTable(rowData,colNames);
		//테이블에 스크롤씌우기
		JScrollPane jsp = new JScrollPane(table);
		
		//입력상자 생성
		jtf_no = new JTextField();
		jtf_name = new JTextField();
		jtf_address = new JTextField();
		jtf_age = new JTextField();
		jtf_phone = new JTextField();
		//입력상자 넣을 팬넬 생성
		JPanel p = new JPanel();
		
		//펜넬에 라벨과 입력상자들 추가
		p.setLayout(new GridLayout(5,2));
		p.add(new JLabel("회원번호:"));
		p.add(jtf_no);
		p.add(new JLabel("회원이름:"));
		p.add(jtf_name);
		p.add(new JLabel("주소:"));
		p.add(jtf_address);
		p.add(new JLabel("나이:"));
		p.add(jtf_age);
		p.add(new JLabel("전화번호:"));
		p.add(jtf_phone);
		//입력상자팬넬과 버튼팬넬 넣을 센터팬넬 생성
		JPanel p_center = new JPanel();
		//버튼 생성
		JButton btn_add = new JButton("추가");
		JButton btn_list = new JButton("조회");
		JButton btn_update = new JButton("수정");
		JButton btn_delete = new JButton("삭제");
		//버튼팬넬에 버튼 추가
		JPanel p_btn = new JPanel();
		p_btn.add(btn_add);
		p_btn.add(btn_list);
		p_btn.add(btn_update);
		p_btn.add(btn_delete);
		//쏀더펜넬에 입력상자펜넬과 버튼팬넬 추가
		p_center.setLayout(new BorderLayout());
		p_center.add(p,BorderLayout.CENTER);
		p_center.add(p_btn,BorderLayout.SOUTH);//버튼을 남쪽으로 
		
		//프레임에 펜넬들 배치
		add(p_center,BorderLayout.CENTER);
		add(jsp,BorderLayout.SOUTH);//테이블을 남쪽으로 
		
		setSize(400,700);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//창을 닫으면 자동으로 프로그램 종료
		
		//각 버튼에 이벤트 추가
		//추가
		btn_add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int no=Integer.parseInt(jtf_no.getText());
				String name=jtf_name.getText();
				String address=jtf_address.getText();
				int age=Integer.parseInt(jtf_age.getText());
				String phone=jtf_phone.getText();
				
				insertMember(no,name,address,age,phone);
			}
			
		});
		//조회
		btn_list.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				printMember();
			}
			
		});
		//수정
		btn_update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int no=Integer.parseInt(jtf_no.getText());
				String name=jtf_name.getText();
				String address=jtf_address.getText();
				int age=Integer.parseInt(jtf_age.getText());
				String phone=jtf_phone.getText();
				
				updateMember(no,name,address,age,phone);
				
			}
			
		});
		//삭제
		btn_delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int no = Integer.parseInt(jtf_no.getText());
				deleteMember(no);
			}
			
		});
		//테이블 목록을 눌렀을때 이벤트를 등록하여 선택한 행의 상품의 정보를 입력상자에 띄우도록 하기위함
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
				int index = table.getSelectedRow(); //선택한 행의 인덱스 반환
				
				Vector v = rowData.get(index);//rowData의 index번째의 행을 꺼내온다(Vector형)
				
				jtf_no.setText(v.get(0)+"");
				jtf_name.setText(v.get(1)+"");
				jtf_address.setText(v.get(2)+"");
				jtf_age.setText(v.get(3)+"");
				jtf_phone.setText(v.get(4)+"");
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}
	//회원추가 메소드
	public void insertMember(int no,String name,String address,int age,String phone) {
		
		String sql = "insert into member values("+no+",'"+name+"','"+address+"',"+age+",'"+phone+"')";
		
		Connection conn=null;
		Statement stmt=null;
		
		try {
			
			//1.jdbc드라이버를 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.db 서버에 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.219.105:1521:XE","c##sist","sist");
			
			//3.Statement 객체를 생성한다.
			stmt = conn.createStatement();
			
			//4.데이터베이스 명령을 실행한다.
			//int re = stmt.executeUpdate(String sql)
			//ResultSet rs = stmt.executeQuery(String sql)
			
			int re = stmt.executeUpdate(sql);	//insert는 넣기만 하면 되니까 executeUpdate
			
			if(re==1) {
				System.out.println("상품등록에 성공하였습니다.");
				//데이터 입력 성공하면 입력상자에 입력되어있던 데이터 비워주기
				jtf_no.setText("");			//회원번호
				jtf_name.setText("");		//이름
				jtf_address.setText("");	//주소
				jtf_age.setText("");		//나이
				jtf_phone.setText("");		//전화번호
				
				//변경된 jtabel 띄워주기(조회)
				printMember();
			}else {
				System.out.println("상품등록에 실패하였습니다.");
			}
		
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				//5.사용한 자원 닫아주기
				if(conn!=null) {
					conn.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
			}catch(Exception ex) {
				
			}
		}	
	}
	
	//회원조회 메소드
	public void printMember() {
		//이전 조회 데이터에 이어서 뜨지 않도록 클리어해준다.
		rowData.clear();
		
		String sql = "select * from member order by no";
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs = null;	//읽어온 자료를 담기 위한 변수
		
		try {
			
			//1.jdbc드라이버를 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.db 서버에 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.219.105:1521:XE","c##sist","sist");
			
			//3.Statement 객체를 생성한다.
			stmt = conn.createStatement();
			
			//4.데이터베이스 명령을 실행한다.
			//int re = stmt.executeUpdate(String sql)
			//ResultSet rs = stmt.executeQuery(String sql)
			
			rs = stmt.executeQuery(sql);	//insert는 넣기만 하면 되니까 executeUpdate
			
			while(rs.next()) {
				int no=rs.getInt(1);
				String name=rs.getString(2);
				String address=rs.getString(3);
				int age=rs.getInt(4);
				String phone=rs.getString(5);
				
				//db로부터 읽어온 행 데이터들을 벡터에 담아라
				Vector v = new Vector();
				v.add(no);
				v.add(name);
				v.add(address);
				v.add(age);
				v.add(phone);
				
				rowData.add(v);
				
				//바뀐 내용의 테이블을 다시 띄워라
				table.updateUI();
			}
			
		}catch(Exception e) {
			System.out.println("예외발생"+e.getMessage());
		}finally {
			try {
				//5.사용한 자원 닫아주기
				if(conn!=null) {
					conn.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
			}catch(Exception ex) {
				
			}
		}
		
	}
	//회원 수정 메소드
	public void updateMember(int no,String name,String address,int age,String phone) {
		String sql = "update member set no="+no+",name='"+name+"',address='"
				+address+"',age="+age+",phone='"+phone+"' where no="+no;
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			//1.jdbc드라이버를 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.db 서버에 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.219.105:1521:XE","c##sist","sist");
			
			//3.Statement 객체를 생성한다.
			stmt = conn.createStatement();
			
			//4.데이터베이스 명령을 실행한다.
			//int re = stmt.executeUpdate(String sql)
			//ResultSet rs = stmt.executeQuery(String sql)
			int re = stmt.executeUpdate(sql);
			
			if(re==1) {
				System.out.println("수정되었습니다.");
				printMember();
			}else {
				System.out.println("수정실패");
			}
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				//5.사용한 자원 닫아주기
				if(conn!=null) {
					conn.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
			}catch(Exception ex) {
				
			}
		}
		
	}
	
	//회원 삭제 메소드
	public void deleteMember(int no) {
	
		String sql = "delete member where no="+no;
		
		Connection conn=null;
		Statement stmt=null;
		
		try {
			
			//1.jdbc드라이버를 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.db 서버에 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.219.105:1521:XE","c##sist","sist");
			
			//3.Statement 객체를 생성한다.
			stmt = conn.createStatement();
			
			//4.데이터베이스 명령을 실행한다.
			int re = stmt.executeUpdate(sql);
			
			if(re==1) {
				System.out.println("삭제하였습니다.");
				//삭제하고나서 입력상자들 비워주기
				jtf_no.setText("");
				jtf_name.setText("");
				jtf_address.setText("");
				jtf_age.setText("");
				jtf_phone.setText("");
				
				printMember();
			}else {
				System.out.println("삭제실패");
			}
		}catch(Exception e) {
			System.out.println("예외발생"+e.getMessage());
		}finally {
			try {
				//5.사용한 자원 닫아주기
				if(conn!=null) {
					conn.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
			}catch(Exception ex) {
				
			}
		}	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MemberTest();
	}

}
