package com.sist.member;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

public class MemberTest extends JFrame {

	JTextField jtf_no;		//ȸ����ȣ
	JTextField jtf_name;	//�̸�
	JTextField jtf_address;	//�ּ�
	JTextField jtf_age;		//����
	JTextField jtf_phone;	//��ȭ��ȣ
	
	JTable table;
	Vector colNames;	//���̺��� �÷��̸�
	Vector<Vector> rowData;	//���̺��� ���ڵ带 ���� ���� ����
	
	public MemberTest() {
		//���̺� �� �÷��̸��� ���� ���� �����ϰ� �÷��̸� �߰�
		colNames = new Vector<String>();
		colNames.add("ȸ����ȣ");
		colNames.add("ȸ���̸�");
		colNames.add("�ּ�");
		colNames.add("����");
		colNames.add("��ȭ��ȣ");
		
		//���̺��� ���� �����͸� ��� ���� ���� ����
		rowData = new Vector<Vector>();
		//��,�� ���ͷ� ���̺� ����
		table = new JTable(rowData,colNames);
		//���̺� ��ũ�Ѿ����
		JScrollPane jsp = new JScrollPane(table);
		
		//�Է»��� ����
		jtf_no = new JTextField();
		jtf_name = new JTextField();
		jtf_address = new JTextField();
		jtf_age = new JTextField();
		jtf_phone = new JTextField();
		//�Է»��� ���� �ҳ� ����
		JPanel p = new JPanel();
		
		//��ڿ� �󺧰� �Է»��ڵ� �߰�
		p.setLayout(new GridLayout(5,2));
		p.add(new JLabel("ȸ����ȣ:"));
		p.add(jtf_no);
		p.add(new JLabel("ȸ���̸�:"));
		p.add(jtf_name);
		p.add(new JLabel("�ּ�:"));
		p.add(jtf_address);
		p.add(new JLabel("����:"));
		p.add(jtf_age);
		p.add(new JLabel("��ȭ��ȣ:"));
		p.add(jtf_phone);
		//�Է»����ҳڰ� ��ư�ҳ� ���� �����ҳ� ����
		JPanel p_center = new JPanel();
		//��ư ����
		JButton btn_add = new JButton("�߰�");
		JButton btn_list = new JButton("��ȸ");
		JButton btn_update = new JButton("����");
		JButton btn_delete = new JButton("����");
		//��ư�ҳڿ� ��ư �߰�
		JPanel p_btn = new JPanel();
		p_btn.add(btn_add);
		p_btn.add(btn_list);
		p_btn.add(btn_update);
		p_btn.add(btn_delete);
		//�����ڿ� �Է»�����ڰ� ��ư�ҳ� �߰�
		p_center.setLayout(new BorderLayout());
		p_center.add(p,BorderLayout.CENTER);
		p_center.add(p_btn,BorderLayout.SOUTH);//��ư�� �������� 
		
		//�����ӿ� ��ڵ� ��ġ
		add(p_center,BorderLayout.CENTER);
		add(jsp,BorderLayout.SOUTH);//���̺��� �������� 
		
		setSize(400,700);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//â�� ������ �ڵ����� ���α׷� ����
		
		//�� ��ư�� �̺�Ʈ �߰�
		//�߰�
		btn_add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int no=Integer.parseInt(jtf_no.getText());
				String name=jtf_name.getText();
				String address=jtf_address.getText();
				int age=Integer.parseInt(jtf_age.getText());
				String phone=jtf_phone.getText();
				
				insertMember(no,name,address,age,phone);
			}
			
		});
		//��ȸ
		btn_list.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				printMember();
			}
			
		});
		//����
		btn_update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int no=Integer.parseInt(jtf_no.getText());
				String name=jtf_name.getText();
				String address=jtf_address.getText();
				int age=Integer.parseInt(jtf_age.getText());
				String phone=jtf_phone.getText();
				
				updateMember(no,name,address,age,phone);
				
			}
			
		});
		//����
		btn_delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int no = Integer.parseInt(jtf_no.getText());
				deleteMember(no);
			}
			
		});
		//���̺� ����� �������� �̺�Ʈ�� ����Ͽ� ������ ���� ��ǰ�� ������ �Է»��ڿ� ��쵵�� �ϱ�����
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
				int index = table.getSelectedRow(); //������ ���� �ε��� ��ȯ
				
				Vector v = rowData.get(index);//rowData�� index��°�� ���� �����´�(Vector��)
				
				jtf_no.setText(v.get(0)+"");
				jtf_name.setText(v.get(1)+"");
				jtf_address.setText(v.get(2)+"");
				jtf_age.setText(v.get(3)+"");
				jtf_phone.setText(v.get(4)+"");
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}
	//ȸ���߰� �޼ҵ�
	public void insertMember(int no,String name,String address,int age,String phone) {
		
		String sql = "insert into member values("+no+",'"+name+"','"+address+"',"+age+",'"+phone+"')";
		
		Connection conn=null;
		Statement stmt=null;
		
		try {
			
			//1.jdbc����̹��� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.db ������ ����
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.219.105:1521:XE","c##sist","sist");
			
			//3.Statement ��ü�� �����Ѵ�.
			stmt = conn.createStatement();
			
			//4.�����ͺ��̽� ����� �����Ѵ�.
			//int re = stmt.executeUpdate(String sql)
			//ResultSet rs = stmt.executeQuery(String sql)
			
			int re = stmt.executeUpdate(sql);	//insert�� �ֱ⸸ �ϸ� �Ǵϱ� executeUpdate
			
			if(re==1) {
				System.out.println("��ǰ��Ͽ� �����Ͽ����ϴ�.");
				//������ �Է� �����ϸ� �Է»��ڿ� �ԷµǾ��ִ� ������ ����ֱ�
				jtf_no.setText("");			//ȸ����ȣ
				jtf_name.setText("");		//�̸�
				jtf_address.setText("");	//�ּ�
				jtf_age.setText("");		//����
				jtf_phone.setText("");		//��ȭ��ȣ
				
				//����� jtabel ����ֱ�(��ȸ)
				printMember();
			}else {
				System.out.println("��ǰ��Ͽ� �����Ͽ����ϴ�.");
			}
		
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}finally {
			try {
				//5.����� �ڿ� �ݾ��ֱ�
				if(conn!=null) {
					conn.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
			}catch(Exception ex) {
				
			}
		}	
	}
	
	//ȸ����ȸ �޼ҵ�
	public void printMember() {
		//���� ��ȸ �����Ϳ� �̾ ���� �ʵ��� Ŭ�������ش�.
		rowData.clear();
		
		String sql = "select * from member order by no";
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs = null;	//�о�� �ڷḦ ��� ���� ����
		
		try {
			
			//1.jdbc����̹��� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.db ������ ����
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.219.105:1521:XE","c##sist","sist");
			
			//3.Statement ��ü�� �����Ѵ�.
			stmt = conn.createStatement();
			
			//4.�����ͺ��̽� ����� �����Ѵ�.
			//int re = stmt.executeUpdate(String sql)
			//ResultSet rs = stmt.executeQuery(String sql)
			
			rs = stmt.executeQuery(sql);	//insert�� �ֱ⸸ �ϸ� �Ǵϱ� executeUpdate
			
			while(rs.next()) {
				int no=rs.getInt(1);
				String name=rs.getString(2);
				String address=rs.getString(3);
				int age=rs.getInt(4);
				String phone=rs.getString(5);
				
				//db�κ��� �о�� �� �����͵��� ���Ϳ� ��ƶ�
				Vector v = new Vector();
				v.add(no);
				v.add(name);
				v.add(address);
				v.add(age);
				v.add(phone);
				
				rowData.add(v);
				
				//�ٲ� ������ ���̺��� �ٽ� �����
				table.updateUI();
			}
			
		}catch(Exception e) {
			System.out.println("���ܹ߻�"+e.getMessage());
		}finally {
			try {
				//5.����� �ڿ� �ݾ��ֱ�
				if(conn!=null) {
					conn.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
			}catch(Exception ex) {
				
			}
		}
		
	}
	//ȸ�� ���� �޼ҵ�
	public void updateMember(int no,String name,String address,int age,String phone) {
		String sql = "update member set no="+no+",name='"+name+"',address='"
				+address+"',age="+age+",phone='"+phone+"' where no="+no;
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			//1.jdbc����̹��� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.db ������ ����
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.219.105:1521:XE","c##sist","sist");
			
			//3.Statement ��ü�� �����Ѵ�.
			stmt = conn.createStatement();
			
			//4.�����ͺ��̽� ����� �����Ѵ�.
			//int re = stmt.executeUpdate(String sql)
			//ResultSet rs = stmt.executeQuery(String sql)
			int re = stmt.executeUpdate(sql);
			
			if(re==1) {
				System.out.println("�����Ǿ����ϴ�.");
				printMember();
			}else {
				System.out.println("��������");
			}
			
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}finally {
			try {
				//5.����� �ڿ� �ݾ��ֱ�
				if(conn!=null) {
					conn.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
			}catch(Exception ex) {
				
			}
		}
		
	}
	
	//ȸ�� ���� �޼ҵ�
	public void deleteMember(int no) {
	
		String sql = "delete member where no="+no;
		
		Connection conn=null;
		Statement stmt=null;
		
		try {
			
			//1.jdbc����̹��� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.db ������ ����
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.219.105:1521:XE","c##sist","sist");
			
			//3.Statement ��ü�� �����Ѵ�.
			stmt = conn.createStatement();
			
			//4.�����ͺ��̽� ����� �����Ѵ�.
			int re = stmt.executeUpdate(sql);
			
			if(re==1) {
				System.out.println("�����Ͽ����ϴ�.");
				//�����ϰ��� �Է»��ڵ� ����ֱ�
				jtf_no.setText("");
				jtf_name.setText("");
				jtf_address.setText("");
				jtf_age.setText("");
				jtf_phone.setText("");
				
				printMember();
			}else {
				System.out.println("��������");
			}
		}catch(Exception e) {
			System.out.println("���ܹ߻�"+e.getMessage());
		}finally {
			try {
				//5.����� �ڿ� �ݾ��ֱ�
				if(conn!=null) {
					conn.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
			}catch(Exception ex) {
				
			}
		}	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MemberTest();
	}

}
