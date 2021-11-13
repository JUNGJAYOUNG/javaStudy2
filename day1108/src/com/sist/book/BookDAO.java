package com.sist.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAO {
	
	//출판사명을 매개변수로 전달받아 해당 출판사의 모든 목록을 검색하여 arraylist로 반환하는 메소드정의
	public ArrayList<BookVO> searchBook(String publisher){
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		
		String sql = "select * from book where publisher=? order by price desc";
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url ="jdbc:oracle:thin:@192.168.219.104:1521:XE";
		String userName="c##madang";
		String pwd="madang";
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, pwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, publisher);
			rs = pstmt.executeQuery();
			int bookid = 0;
			String bookname = "";
			String publi = "";
			int price = 0;
		
			while(rs.next()) {
				bookid = rs.getInt(1);
				bookname = rs.getString(2);
				publi = rs.getString(3);
				price = rs.getInt(4);
				list.add(new BookVO(bookid,bookname,publi,price));
			}
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
				
			}
		}
		return list;
	}
}
