package com.sist.goods;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class GoodsTest extends JFrame {
	
	JTextField jtf_no;		//상품번호
	JTextField jtf_item;	//상품명
	JTextField jtf_qty;		//수량
	JTextField jtf_price;	//단가
	
	JTable table;				//모든 상품목록을 엑셀과 같은 모양으로 
	Vector colNames;	//테이블의 컬럼이름을 위한 벡터를 선언
	Vector<Vector> rowData;	//테이블의 데이터를 위한 벡터 선언
	
	//데이터베이스에 연결하여 goods테이블의 모든 상품을 읽어와서 조회하여
	//테이블에 출력하는 메소드
	
	public void printGoods() {
		
		//새로운 상품을 등록하여 계속하여 호출될 수 있으니
		//rowData를 먼저 깨끗이 비워준다.
		rowData.clear();
		
		String sql = "select * from goods";
		
		//데이터베이스 연결과 필요한 변수들을 선언
		Connection conn = null;	//DB서버에 연결하기 위한 변수
		Statement stmt = null;	//데이터베이스 명령을 실행하기 위한 변수
		ResultSet rs = null;	//읽어온 자료를 담기 위한 변수
		
		try {
			//1.JDBC 드라이버를 메모리로 로드한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.DB서버에 연결한다.
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.219.105:1521:XE","c##sist","sist");
			//3.Statement 객체를 생성한다.
			stmt = conn.createStatement();
			//4.데이터베이스 명령을 실행한다.
			//사용하는 메소드 두가지
			//int re = executeUpdate(String sql)
			//ResultSet rs = executeQuery(String sql)
			rs = stmt.executeQuery(sql);
			
			//5.일처리를 한다
			//검색한 자료가 있는만큼 반복실행하여 한 행씩 읽어와서 그것을
			//벡터로 만들어 그벡터를 테이블의 자료를 위한 rowData에 담는다.
			//ResultSet의 결과에서 특정 레코드를 가리키는 커서가 있다
			//이 커서를 한 행씩 옮겨주는 메소드가 next()이다.
			//메소드는 다음의 레코드가 있어서 성공적으로 옮겨지면 true 반환
			//다음의 레코드가 더이상 없으면 false 반환
			while(rs.next()) {
				//현재 커서가 바라보고잇는 속성값을 읽어오기 위해서는 자료형에 따라
				//get~~~() 메소드를 사용한다.
				//칼럼 값이 문자열이라면 getString, 정수형이라면 getInt...
				//이때 매개변수로 컬럼의 인덱스나, 컬럼 이름을 문자열로 전달할 수 있다. 
				//여기서 인덱스는 1부터 시작한다.
				
				int no = rs.getInt(1);
				String item = rs.getString(2);
				int qty = rs.getInt(3);
				int price = rs.getInt(4);
				
				//벡터를 하나 만들고 그 벡터에 no, item, qty, price를 담는다.
				Vector v = new Vector();
				v.add(no);
				v.add(item);
				v.add(qty);
				v.add(price);
				
				//그 벡터를 rowData에 담는다.
				rowData.add(v);
				
				//바뀐 내용으로 테이블을 다시 그린다.
				//처음 테이블을 만들때에는 rowData벡터가 비어있었다.
				//나중에 테이블의 데이터인 rowData에 바뀐 자료를 적용하기
				//위해서는 updateUI를 호출해주어야 한다.
				table.updateUI();
				
			}
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				//사용했던 자원들을 닫아준다.
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception ex) {
				
			}
		}
		
	}
	public GoodsTest() {
		
		//테이블에 들어갈 컬럼이름을 위한 벡터를 생성하고 자료를 추가한다.
		colNames = new Vector<String>();
		colNames.add("상품번호");
		colNames.add("상품명");
		colNames.add("수량");
		colNames.add("단가");
		
		//테이블에 들어갈 실제데이터를 담기 위한 벡터를 생성하고 자료를 추가함
		rowData= new Vector<Vector>();
		
		//컬럼이름이 있는 colName벡터와 실제데이터 있는 rowData벡터를 갖고
		//엑셀과 같은 화면의 테이블을 생성
		table = new JTable(rowData,colNames);
		
		//테이블의 자료가 너무 많아서 한 화면에 보이지 않을떄에 자동으로 스크롤을
		//만들어주는 스크롤팬을 생성
		JScrollPane jsp = new JScrollPane(table);
		
		jtf_no = new JTextField();
		jtf_item = new JTextField();
		jtf_qty = new JTextField();
		jtf_price = new JTextField();
		
		//입력상자들과 무엇을 입력해야하는지 설명하는 라벨들을 담기 위한 패널 생성
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,2));
		
		//라벨과 입력상자(텍스트필드)들을 패널에 차례로 담는다
		p.add(new JLabel("상품번호:"));
		p.add(jtf_no);
		p.add(new JLabel("상품이름:"));
		p.add(jtf_item);
		p.add(new JLabel("상품수량:"));
		p.add(jtf_qty);
		p.add(new JLabel("상품단가:"));
		p.add(jtf_price);
		
		JButton btn_add = new JButton("추가");
		JButton btn_list = new JButton("목록");
		
		//버튼들을 담을 패널 생성
		JPanel p2 = new JPanel();
		p2.add(btn_add);
		p2.add(btn_list);
		
		//입력상자들이 있는 패널과 버튼이 있는 패널을 담기위한 패널
		JPanel p_center = new JPanel();
		
		p_center.setLayout(new BorderLayout());
		p_center.add(p,BorderLayout.CENTER);
		p_center.add(p2,BorderLayout.SOUTH);
		
		//프레임의 가운데에 입력상자와 버튼을 담고있는 p_center패널을 담는다
		add(p_center,BorderLayout.CENTER);
		//테이블을 담고 있는 스크롤팬을 프레임의아랫쪽에 담는다
		add(jsp,BorderLayout.SOUTH);
		
		setSize(800,600);
		setVisible(true);
		
		//창을 닫으면 프로그램도 종료하도록 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//"목록"버튼을 누르면
		//데이터베이스 연결하여 모든 상품목록을 읽어와서 테이블에 출력하는
		//메소드를 호출
		
		btn_list.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				printGoods();
			}
			
		});
		
		//추가 버튼을 누르면 사용자가 입력한 상품이 추가되도록
		btn_add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int no = Integer.parseInt(jtf_no.getText());
				String item = jtf_item.getText();
				int qty = Integer.parseInt(jtf_qty.getText());
				int price = Integer.parseInt(jtf_price.getText());
				
				String sql 	= "insert into goods values("+no+",'"+item+"'"+","+qty+","+price+")";
				
				//finally에서도 접근할 수 있도록 trycatch문 밖에 미리 선언
				Connection conn = null;
				Statement stmt = null;
				
				try {
					//1.jdbc드라이버를 메모리로 로드
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					//2.DB서버에 연결
					conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.219.105:1521:XE","c##sist","sist");
				
					//3.
					stmt = conn.createStatement();

					//4.데이터베이스 명령을 실행한다.
					int re = stmt.executeUpdate(sql);
					
					if(re==1) {
						System.out.println("상품등록에 성공하였습니다.");	
						jtf_no.setText("");
						jtf_item.setText("");
						jtf_qty.setText("");
						jtf_price.setText("");
						
						printGoods();
					}else {
						System.out.println("상품등록에 실패하였습니다.");
					}
				}catch(Exception ex) {
					System.out.println("예외발생:"+ex.getMessage());
				}finally {
					
					try {
					//5.사용했던 자원들을 닫아준다.
						if(stmt != null)
							stmt.close();
						else if(conn != null)
							conn.close();
					}catch(Exception ex) {
						
					}
				}
			}});	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GoodsTest();
	}

}
