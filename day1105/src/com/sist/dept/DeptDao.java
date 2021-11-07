package com.sist.dept;

import java.sql.*;
import java.util.ArrayList;

public class DeptDao {
	//����Ŭ db�� �����ϱ� ���� �ʿ��� ������ ��������� ����
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.219.104:1521:XE";
	String user = "c##sist";
	String pwd = "sist";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	//������ ��ȯ�ϴ� ��ȸ�޼ҵ忡�� ���
	ResultSet rs = null;
	
	//����(���������κ��� �޾ƿ� ���� �Ű������� ����)
	public int insertDept(DeptVo d) {
		int re = -1;
		
		String sql = "insert into dept values(?,?,?)";
		//db���� �κ��� ����ó�� ������Ѵ�
		try {
			//1. jdbc����̹��� �޸𸮷� �ε�
			Class.forName(driver);
			//2. DB������ �����Ѵ�.
			conn = DriverManager.getConnection(url,user,pwd);
			//3. Statement ��ü ����
			pstmt = conn.prepareStatement(sql);
			//4. sql���� ?�κп� �� ��� ä���ֱ�
			pstmt.setInt(1,d.getNo());
			pstmt.setString(2,d.getName());
			pstmt.setString(3,d.getLocation());
			
			//5. �����ͺ��̽� ��� ����
			re = pstmt.executeUpdate();

		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}finally {// ����ߴ� �ڿ� finally���� �ݾ��ֱ�
			//close()�� ���ܹ߻���Ŵ���� try catch�ʿ�
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
	//����
	public int updateDept(DeptVo d) {
		//�������� ��ȯ�ϱ� ���� ������ ���� ����
		int re = -1;
		
		//������ ���ڵ带 ã�Ƽ�! �ش� ���ڵ��� ������ ����������ϱ� ������ where ��
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
			System.out.println("���ܹ߻�:"+e.getMessage());
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
	//��ȸ
	public ArrayList<DeptVo> listDept() {
		
		ArrayList<DeptVo> list = new ArrayList<DeptVo>();
		
		String sql = "select * from dept order by no";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			pstmt = conn.prepareStatement(sql);
			//������ �������� Ŀ������ rs����
			rs = pstmt.executeQuery();
			
			//���������Ͱ� �ִ� ����
			while(rs.next()) {
				//rs�� �÷��ε����� 1���� ����
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String location = rs.getString(3);
				
				list.add(new DeptVo(no,name,location));
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
	//����
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
			System.out.println("���ܹ߻�:"+e.getMessage());
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
