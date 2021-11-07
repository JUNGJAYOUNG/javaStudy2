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
	
	JTextField jtf_no;		//��ǰ��ȣ
	JTextField jtf_item;	//��ǰ��
	JTextField jtf_qty;		//����
	JTextField jtf_price;	//�ܰ�
	
	JTable table;				//��� ��ǰ����� ������ ���� ������� 
	Vector colNames;	//���̺��� �÷��̸��� ���� ���͸� ����
	Vector<Vector> rowData;	//���̺��� �����͸� ���� ���� ����
	
	//�����ͺ��̽��� �����Ͽ� goods���̺��� ��� ��ǰ�� �о�ͼ� ��ȸ�Ͽ�
	//���̺� ����ϴ� �޼ҵ�
	
	public void printGoods() {
		
		//���ο� ��ǰ�� ����Ͽ� ����Ͽ� ȣ��� �� ������
		//rowData�� ���� ������ ����ش�.
		rowData.clear();
		
		String sql = "select * from goods";
		
		//�����ͺ��̽� ����� �ʿ��� �������� ����
		Connection conn = null;	//DB������ �����ϱ� ���� ����
		Statement stmt = null;	//�����ͺ��̽� ����� �����ϱ� ���� ����
		ResultSet rs = null;	//�о�� �ڷḦ ��� ���� ����
		
		try {
			//1.JDBC ����̹��� �޸𸮷� �ε��Ѵ�.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.DB������ �����Ѵ�.
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.219.105:1521:XE","c##sist","sist");
			//3.Statement ��ü�� �����Ѵ�.
			stmt = conn.createStatement();
			//4.�����ͺ��̽� ����� �����Ѵ�.
			//����ϴ� �޼ҵ� �ΰ���
			//int re = executeUpdate(String sql)
			//ResultSet rs = executeQuery(String sql)
			rs = stmt.executeQuery(sql);
			
			//5.��ó���� �Ѵ�
			//�˻��� �ڷᰡ �ִ¸�ŭ �ݺ������Ͽ� �� �྿ �о�ͼ� �װ���
			//���ͷ� ����� �׺��͸� ���̺��� �ڷḦ ���� rowData�� ��´�.
			//ResultSet�� ������� Ư�� ���ڵ带 ����Ű�� Ŀ���� �ִ�
			//�� Ŀ���� �� �྿ �Ű��ִ� �޼ҵ尡 next()�̴�.
			//�޼ҵ�� ������ ���ڵ尡 �־ ���������� �Ű����� true ��ȯ
			//������ ���ڵ尡 ���̻� ������ false ��ȯ
			while(rs.next()) {
				//���� Ŀ���� �ٶ󺸰��մ� �Ӽ����� �о���� ���ؼ��� �ڷ����� ����
				//get~~~() �޼ҵ带 ����Ѵ�.
				//Į�� ���� ���ڿ��̶�� getString, �������̶�� getInt...
				//�̶� �Ű������� �÷��� �ε�����, �÷� �̸��� ���ڿ��� ������ �� �ִ�. 
				//���⼭ �ε����� 1���� �����Ѵ�.
				
				int no = rs.getInt(1);
				String item = rs.getString(2);
				int qty = rs.getInt(3);
				int price = rs.getInt(4);
				
				//���͸� �ϳ� ����� �� ���Ϳ� no, item, qty, price�� ��´�.
				Vector v = new Vector();
				v.add(no);
				v.add(item);
				v.add(qty);
				v.add(price);
				
				//�� ���͸� rowData�� ��´�.
				rowData.add(v);
				
				//�ٲ� �������� ���̺��� �ٽ� �׸���.
				//ó�� ���̺��� ���鶧���� rowData���Ͱ� ����־���.
				//���߿� ���̺��� �������� rowData�� �ٲ� �ڷḦ �����ϱ�
				//���ؼ��� updateUI�� ȣ�����־�� �Ѵ�.
				table.updateUI();
				
			}
			
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}finally {
			try {
				//����ߴ� �ڿ����� �ݾ��ش�.
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
		
		//���̺� �� �÷��̸��� ���� ���͸� �����ϰ� �ڷḦ �߰��Ѵ�.
		colNames = new Vector<String>();
		colNames.add("��ǰ��ȣ");
		colNames.add("��ǰ��");
		colNames.add("����");
		colNames.add("�ܰ�");
		
		//���̺� �� ���������͸� ��� ���� ���͸� �����ϰ� �ڷḦ �߰���
		rowData= new Vector<Vector>();
		
		//�÷��̸��� �ִ� colName���Ϳ� ���������� �ִ� rowData���͸� ����
		//������ ���� ȭ���� ���̺��� ����
		table = new JTable(rowData,colNames);
		
		//���̺��� �ڷᰡ �ʹ� ���Ƽ� �� ȭ�鿡 ������ �������� �ڵ����� ��ũ����
		//������ִ� ��ũ������ ����
		JScrollPane jsp = new JScrollPane(table);
		
		jtf_no = new JTextField();
		jtf_item = new JTextField();
		jtf_qty = new JTextField();
		jtf_price = new JTextField();
		
		//�Է»��ڵ�� ������ �Է��ؾ��ϴ��� �����ϴ� �󺧵��� ��� ���� �г� ����
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,2));
		
		//�󺧰� �Է»���(�ؽ�Ʈ�ʵ�)���� �гο� ���ʷ� ��´�
		p.add(new JLabel("��ǰ��ȣ:"));
		p.add(jtf_no);
		p.add(new JLabel("��ǰ�̸�:"));
		p.add(jtf_item);
		p.add(new JLabel("��ǰ����:"));
		p.add(jtf_qty);
		p.add(new JLabel("��ǰ�ܰ�:"));
		p.add(jtf_price);
		
		JButton btn_add = new JButton("�߰�");
		JButton btn_list = new JButton("���");
		
		//��ư���� ���� �г� ����
		JPanel p2 = new JPanel();
		p2.add(btn_add);
		p2.add(btn_list);
		
		//�Է»��ڵ��� �ִ� �гΰ� ��ư�� �ִ� �г��� ������� �г�
		JPanel p_center = new JPanel();
		
		p_center.setLayout(new BorderLayout());
		p_center.add(p,BorderLayout.CENTER);
		p_center.add(p2,BorderLayout.SOUTH);
		
		//�������� ����� �Է»��ڿ� ��ư�� ����ִ� p_center�г��� ��´�
		add(p_center,BorderLayout.CENTER);
		//���̺��� ��� �ִ� ��ũ������ �������ǾƷ��ʿ� ��´�
		add(jsp,BorderLayout.SOUTH);
		
		setSize(800,600);
		setVisible(true);
		
		//â�� ������ ���α׷��� �����ϵ��� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//"���"��ư�� ������
		//�����ͺ��̽� �����Ͽ� ��� ��ǰ����� �о�ͼ� ���̺� ����ϴ�
		//�޼ҵ带 ȣ��
		
		btn_list.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				printGoods();
			}
			
		});
		
		//�߰� ��ư�� ������ ����ڰ� �Է��� ��ǰ�� �߰��ǵ���
		btn_add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int no = Integer.parseInt(jtf_no.getText());
				String item = jtf_item.getText();
				int qty = Integer.parseInt(jtf_qty.getText());
				int price = Integer.parseInt(jtf_price.getText());
				
				String sql 	= "insert into goods values("+no+",'"+item+"'"+","+qty+","+price+")";
				
				//finally������ ������ �� �ֵ��� trycatch�� �ۿ� �̸� ����
				Connection conn = null;
				Statement stmt = null;
				
				try {
					//1.jdbc����̹��� �޸𸮷� �ε�
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					//2.DB������ ����
					conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.219.105:1521:XE","c##sist","sist");
				
					//3.
					stmt = conn.createStatement();

					//4.�����ͺ��̽� ����� �����Ѵ�.
					int re = stmt.executeUpdate(sql);
					
					if(re==1) {
						System.out.println("��ǰ��Ͽ� �����Ͽ����ϴ�.");	
						jtf_no.setText("");
						jtf_item.setText("");
						jtf_qty.setText("");
						jtf_price.setText("");
						
						printGoods();
					}else {
						System.out.println("��ǰ��Ͽ� �����Ͽ����ϴ�.");
					}
				}catch(Exception ex) {
					System.out.println("���ܹ߻�:"+ex.getMessage());
				}finally {
					
					try {
					//5.����ߴ� �ڿ����� �ݾ��ش�.
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
