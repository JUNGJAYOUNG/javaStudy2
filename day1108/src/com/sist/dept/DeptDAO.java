package com.sist.dept;

import java.util.ArrayList;
import java.sql.*;

//DAO: Database Access Object
//		�����ͺ��̽� ���̺� �����Ͽ�
// 		�ڷḦ �߰�, �б�, ����, ������ ����ϴ� ��ü

public class DeptDAO {
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@192.168.219.104:1521:XE";
	private String userName="c##sist";
	private String pwd="sist";
	
	//db���̺� �߰�
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
			System.out.println("���ܹ߻�:"+e.getMessage());
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

	//db���̺� ����
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
			System.out.println("���ܹ߻�:"+e.getMessage());
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
	//db���̺� ����
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
			System.out.println("���ܹ߻�:"+e.getMessage());
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

	//db���̺� �о����
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
			
			//ResultSet�� �о��(�˻���) ��� ���ڵ���� list�� ��´�.
			while(rs.next()) {
		
				list.add(new DeptVO(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
		
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
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
