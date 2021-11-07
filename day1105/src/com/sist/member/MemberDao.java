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
		
		int re = -1;	//int형 반환할거니까 변수 선언
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into member values(?,?,?,?,?)";
	
		try {
			//1. jdbc드라이버를 메모리로 로드한다.
			Class.forName(driver);
			
			//2. DB서버에 연결한다.
			conn = DriverManager.getConnection(url,user,pwd);
			
			//3. 데이터베이스 명령을 실행할 수 있는 Statement 객체를 생성합니다.
			//stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, g.getNo());
			pstmt.setString(2, g.getName());
			pstmt.setString(3, g.getAddr());
			pstmt.setInt(4, g.getAge());
			pstmt.setString(5, g.getPhone());
			
			//4. 데이터베이스 명령을 실행합니다.
			re = pstmt.executeUpdate();			
				
		}catch (Exception ex) {
			System.out.println("예외발생:"+ex.getMessage());
		}finally {
			try {
				//5. 사용했던 자원들을 닫아줍니다.						
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
			//드라이버를 메모리로 로드
			Class.forName(driver);
			//드라이버매니저 연결
			conn = DriverManager.getConnection(url, user, pwd);
			
			pstmt = conn.prepareStatement(sql);
			
			//PreparedStatement 객체에 결정되지 않는 ?에 차례대로 값을 설정해야 합니다.
			pstmt.setString(1, g.getName());
			pstmt.setString(2, g.getAddr());
			pstmt.setInt(3, g.getAge());
			pstmt.setString(4, g.getPhone());
			pstmt.setInt(5, g.getNo());
			
			re = pstmt.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
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
	//삭제할 회원의 번호를 정수로 매개변수로 전달받아
	//해당 회원의 정보를 데이터베이스에서 삭제한 후 결과를 정수로 반환하는 메소드 정의	
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
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			//사용했던 자원들 닫아주기 
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
	//모든 회원목록을 조회하여 한명한명의 회원을 멤버vo로 만들어
	//그것을 모두 ArrayList에 담아 반환
	public ArrayList<MemberVo> listMember(){
		//MemberVo형의 자료들을 담을 ArrayList 생성
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		//member테이블의 모든 레코드를 조회할 sql문 작성
		String sql = "select * from member order by no";
		
		//사용할 자원들 null로 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		//데이터 가져와서 띄울거니까 ResultSet 정의
		ResultSet rs = null;
		
		//db연결은 에러처리 해줘야함
		try {
			//db연결
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
				
				//레코드의 내용을 MemberVo객체로 만들어 list에 담아봅니다.
				list.add(new MemberVo(no,name,addr,age,phone));
			}
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {				
				//사용했던 자원들을 닫아줍니다.
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

