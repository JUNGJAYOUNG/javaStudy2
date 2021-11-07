package com.sist.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@192.168.0.54:1521:XE";
	String user="c##sist";
	String pwd="sist";
	
	//삭제할 회원의 번호를 정수로 매개변수로 전달받아
	//해당 회원의 정보를 데이터베이스에서 삭제한 후 결과를 정수로 반환하는 메소드 정의	
	public int deleteBook(int no) {
		int re=-1;
		String sql = "delete book where no=?";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,no);
			
			re = pstmt.executeUpdate();	
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally{
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				
			}
		}
		return re;
	}
	
}
