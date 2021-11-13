package com.sist.orders;
import java.sql.*;
import java.util.ArrayList;

public class OrderDAO {
	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@192.168.219.104:1521:XE";
	String user="c##madang";
	String pwd="madang";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//����ȣ�� �Ű������� �޾� �� ���� �ֹ��� ��� �ֹ������� ����Ʈ�� ��ȯ�ϴ� �޼ҵ�
	public ArrayList<OrderVO> searchOrder(int custid){
		ArrayList<OrderVO> list = new ArrayList<OrderVO>();
		
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
				String orderdate=rs.getString(5);
				
				list.add(new OrderVO(orderid,custid2,bookid,saleprice,orderdate));
			}
			
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
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
