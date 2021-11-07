package com.sist.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@192.168.0.54:1521:XE";
	String user="c##sist";
	String pwd="sist";
	
	public int insertMember(MemberVo g){
		
		int re = -1;	//int�� ��ȯ�ҰŴϱ� ���� ����
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into member values(?,?,?,?,?)";
	
		try {
			//1. jdbc����̹��� �޸𸮷� �ε��Ѵ�.
			Class.forName(driver);
			
			//2. DB������ �����Ѵ�.
			conn = DriverManager.getConnection(url,user,pwd);
			
			//3. �����ͺ��̽� ����� ������ �� �ִ� Statement ��ü�� �����մϴ�.
			//stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, g.getNo());
			pstmt.setString(2, g.getName());
			pstmt.setString(3, g.getAddr());
			pstmt.setInt(4, g.getAge());
			pstmt.setString(5, g.getPhone());
			
			//4. �����ͺ��̽� ����� �����մϴ�.
			re = pstmt.executeUpdate();			
				
		}catch (Exception ex) {
			System.out.println("���ܹ߻�:"+ex.getMessage());
		}finally {
			try {
				//5. ����ߴ� �ڿ����� �ݾ��ݴϴ�.						
				if(pstmt != null) {
					pstmt.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			}catch (Exception ex) {
				// TODO: handle exception
			}
		}
		return re;
	}
	public int updateMember(MemberVo g) {
		int re = -1;
		
		String sql = "update member set name=?,addr=?,age=?,phone=? where no=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//����̹��� �޸𸮷� �ε�
			Class.forName(driver);
			//����̹��Ŵ��� ����
			conn = DriverManager.getConnection(url, user, pwd);
			
			pstmt = conn.prepareStatement(sql);
			
			//PreparedStatement ��ü�� �������� �ʴ� ?�� ���ʴ�� ���� �����ؾ� �մϴ�.
			pstmt.setString(1, g.getName());
			pstmt.setString(2, g.getAddr());
			pstmt.setInt(3, g.getAge());
			pstmt.setString(4, g.getPhone());
			pstmt.setInt(5, g.getNo());
			
			re = pstmt.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return re;
	}
	//������ ȸ���� ��ȣ�� ������ �Ű������� ���޹޾�
	//�ش� ȸ���� ������ �����ͺ��̽����� ������ �� ����� ������ ��ȯ�ϴ� �޼ҵ� ����	
	public int deleteMember(int no) {
		int re = -1;
		String sql = "delete member where no=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			re = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}finally {
			//����ߴ� �ڿ��� �ݾ��ֱ� 
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
	//��� ȸ������� ��ȸ�Ͽ� �Ѹ��Ѹ��� ȸ���� ���vo�� �����
	//�װ��� ��� ArrayList�� ��� ��ȯ
	public ArrayList<MemberVo> listMember(){
		//MemberVo���� �ڷ���� ���� ArrayList ����
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		//member���̺��� ��� ���ڵ带 ��ȸ�� sql�� �ۼ�
		String sql = "select * from member order by no";
		
		//����� �ڿ��� null�� �ʱ�ȭ
		Connection conn = null;
		PreparedStatement pstmt = null;
		//������ �����ͼ� ���Ŵϱ� ResultSet ����
		ResultSet rs = null;
		
		//db������ ����ó�� �������
		try {
			//db����
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {		
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String addr = rs.getString(3);
				int age = rs.getInt(4);
				String phone = rs.getString(5);
				
				//���ڵ��� ������ MemberVo��ü�� ����� list�� ��ƺ��ϴ�.
				list.add(new MemberVo(no,name,addr,age,phone));
			}
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}finally {
			try {				
				//����ߴ� �ڿ����� �ݾ��ݴϴ�.
				if(rs != null) {
					rs.close();
				}
				if(pstmt !=null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception ex) {
				
			}
		}
		return list;
	}
	
}//class end

