package com.sist.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class OrdersDAO {
	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@192.168.219.104:1521:XE";
	String user="c##madang";
	String pwd="madang";
	
	public ArrayList<OrdersVO> searchOrders(int custid){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<OrdersVO> list = new ArrayList<OrdersVO>();
		
		String sql = "select * from orders where custid=?";
		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,custid);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int orderid=rs.getInt(1);
				int custid2=rs.getInt(2);
				int bookid=rs.getInt(3);
				int saleprice=rs.getInt(4);
				Date orderdate=rs.getDate(5);
				
				list.add(new OrdersVO(orderid,custid2,bookid,saleprice,orderdate));
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
}

