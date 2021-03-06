package com.sist.dept;

import java.util.ArrayList;
import java.sql.*;

//DAO: Database Access Object
//		데이터베이스 테이블에 접근하여
// 		자료를 추가, 읽기, 수정, 삭제를 담당하는 객체

public class DeptDAO {
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@192.168.219.104:1521:XE";
	private String userName="c##sist";
	private String pwd="sist";
	
	//db테이블에 추가
	public int insert(DeptVO d) {
		int re = -1;
		String sql = "insert into dept values(?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,userName,pwd);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, d.getDno());
			pstmt.setString(2, d.getDname());
			pstmt.setString(3, d.getDloc());
			
			re = pstmt.executeUpdate();
		
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			}catch(Exception ex) {	
			}
		}
		return re;
	}

	//db테이블에 수정
	public int update(DeptVO d) {
		int re = -1;
		String sql = "update dept set dname=?,dloc=? where dno=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,userName,pwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, d.getDname());
			pstmt.setString(2, d.getDloc());
			pstmt.setInt(3, d.getDno());
			
			re=pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			}catch(Exception ex) {
			}
		}
		return re;
	}
	//db테이블에 삭제
	public int delete(int dno) {
		int re = -1;
		String sql = "delete dept where dno=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,userName,pwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,dno);

			re=pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			}catch(Exception ex) {
			}
		}
		return re;
	}

	//db테이블에 읽어오기
	public ArrayList<DeptVO> listAll(){
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		String sql = "select * from dept order by dno";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,userName,pwd);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			//ResultSet에 읽어온(검색된) 모든 레코드들을 list에 담는다.
			while(rs.next()) {
		
				list.add(new DeptVO(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
		
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
				if(rs != null)
					rs.close();
			}catch(Exception ex) {
			}
		}
		return list;
	}
}
