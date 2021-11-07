package com.sist.dept;

import java.sql.*;
import java.util.ArrayList;

public class DeptDao {
	//오라클 db와 연결하기 위해 필요한 변수들 멤버변수로 선언
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.219.104:1521:XE";
	String user = "c##sist";
	String pwd = "sist";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	//데이터 반환하는 조회메소드에서 사용
	ResultSet rs = null;
	
	//삽입(프레임으로부터 받아올 값을 매개변수로 선언)
	public int insertDept(DeptVo d) {
		int re = -1;
		
		String sql = "insert into dept values(?,?,?)";
		//db연결 부분은 예외처리 해줘야한다
		try {
			//1. jdbc드라이버를 메모리로 로드
			Class.forName(driver);
			//2. DB서버에 연결한다.
			conn = DriverManager.getConnection(url,user,pwd);
			//3. Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//4. sql문의 ?부분에 들어갈 요소 채워주기
			pstmt.setInt(1,d.getNo());
			pstmt.setString(2,d.getName());
			pstmt.setString(3,d.getLocation());
			
			//5. 데이터베이스 명령 실행
			re = pstmt.executeUpdate();

		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {// 사용했던 자원 finally에서 닫아주기
			//close()가 예외발생시킴으로 try catch필요
			try {
				if(conn!=null)
					conn.close();
				if(pstmt!=null)
					pstmt.close();
			}catch(Exception ex) {
				
			}
		}
		return re;
	}
	//수정
	public int updateDept(DeptVo d) {
		//성공여부 반환하기 위한 정수형 변수 생성
		int re = -1;
		
		//선택한 레코드를 찾아서! 해당 레코드의 내용을 수정해줘야하기 때문에 where 들어감
		String sql = "update dept set name=?,location=? where no=?";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, d.getName());
			pstmt.setString(2, d.getLocation());
			pstmt.setInt(3, d.getNo());
			
			re = pstmt.executeUpdate();
				
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				if(conn!=null)
					conn.close();
				if(pstmt!=null)
					pstmt.close();
			}catch(Exception ex) {
				
			}	
		}
		return re;
	}
	//조회
	public ArrayList<DeptVo> listDept() {
		
		ArrayList<DeptVo> list = new ArrayList<DeptVo>();
		
		String sql = "select * from dept order by no";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			pstmt = conn.prepareStatement(sql);
			//가져올 데이터의 커서역할 rs선언
			rs = pstmt.executeQuery();
			
			//다음데이터가 있는 동안
			while(rs.next()) {
				//rs의 컬럼인덱스는 1부터 시작
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String location = rs.getString(3);
				
				list.add(new DeptVo(no,name,location));
			}
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				if(conn!=null)
					conn.close();
				if(pstmt!=null)
					pstmt.close();
				if(rs!=null)
					rs.close();
			}catch(Exception ex) {
				
			}
		}
		return list;
	}
	//삭제
	public int deleteDept(int no) {
		int re=-1;
		
		String sql = "delete dept where no=?";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			re=pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				if(conn!=null)
					conn.close();
				if(pstmt!=null)
					pstmt.close();
			}catch(Exception ex) {	
			}	
		}

		return re;
	}
}//class end
