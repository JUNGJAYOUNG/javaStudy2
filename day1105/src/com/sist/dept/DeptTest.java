package com.sist.dept;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

public class DeptTest extends JFrame {
	
	DeptDao dao;
	
	JTextField jtf_no;
	JTextField jtf_name;
	JTextField jtf_location;
	
	JTable table;
	Vector<Vector> rowData;
	Vector colNames;
	
	//jtable ����ִ� �޼ҵ�
	public void printDept() {
		//���� ��ȸ ��Ͽ� �̾ ���� �ʰ� rowData�� �ʱ�ȭ���ش�.
		rowData.clear();
		//dao�� ��ȸ�޼ҵ带 �ҷ��ͼ� �����͸� ��ȸ�ؿ´�.
		ArrayList<DeptVo> list = dao.listDept();
		
		//�ҷ��� list���� ���྿ �����´�
		for(DeptVo d:list) {
			//�� ���� Vector������ ���� table�� ����.
			Vector v = new Vector();
			v.add(d.getNo());
			v.add(d.getName());
			v.add(d.getLocation());
			rowData.add(v);
		}
		table.updateUI();
	}
	
	
	public DeptTest() {
		dao = new DeptDao();
		colNames = new Vector();
		rowData = new Vector<Vector>();
		
		colNames.add("�μ���ȣ:");
		colNames.add("�μ��̸�:");
		colNames.add("�μ���ġ:");
		
		table = new JTable(rowData,colNames);
		JScrollPane jsp = new JScrollPane(table);
		
		jtf_no = new JTextField();
		jtf_name = new JTextField();
		jtf_location = new JTextField();
	
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(5,2));
		p.add(new JLabel("�μ���ȣ:"));
		p.add(jtf_no);
		p.add(new JLabel("�μ��̸�:"));
		p.add(jtf_name);
		p.add(new JLabel("�μ���ġ:"));
		p.add(jtf_location);
		
		JButton btn_add = new JButton("�߰�");
		JButton btn_list = new JButton("���");
		JButton btn_update = new JButton("����");
		JButton btn_delete = new JButton("����");
		
		JPanel p_btn = new JPanel();
		p_btn.add(btn_add);
		p_btn.add(btn_list);
		p_btn.add(btn_update);
		p_btn.add(btn_delete);
		
		JPanel p_center = new JPanel();
		p_center.setLayout(new BorderLayout());
		p_center.add(p, BorderLayout.CENTER);
		p_center.add(p_btn, BorderLayout.SOUTH);
		
		add(p_center, BorderLayout.CENTER);
		add(jsp, BorderLayout.SOUTH);
	
		setSize(800,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn_add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int no = Integer.parseInt(jtf_no.getText());
				String name = jtf_name.getText();
				String location = jtf_location.getText();
				
				int re=dao.insertDept(new DeptVo(no,name,location));
				
				if(re==1) {
					System.out.println("�μ���Ͽ� �����Ͽ����ϴ�.");
					printDept();
				}else {
					System.out.println("�μ���Ͽ� �����Ͽ����ϴ�.");
				}
			}
		});
		
		btn_update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(jtf_no.getText());
				String name = jtf_name.getText();
				String location = jtf_location.getText();
				
				int re=dao.updateDept(new DeptVo(no,name,location));
				
				if(re==1) {
					System.out.println("�μ������� �����Ͽ����ϴ�.");
					printDept();
				}else {
					System.out.println("�μ������� �����Ͽ����ϴ�.");
				}
				
			}
			
		});
		
		btn_list.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				printDept();
			}	
		});
		
		btn_delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int no = Integer.parseInt(jtf_no.getText());
				int re=dao.deleteDept(no);
				
				if(re==1) {
					System.out.println("�μ������� �����Ͽ����ϴ�.");
					printDept();
				}else {
					System.out.println("�μ������� �����Ͽ����ϴ�.");
				}
			}
			
		});
		
		//���̺��ִ� Ʃ�� ���������� �̺�Ʈ �߻��ϵ��� �ϱ� ���� addMouseListener
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
				int index=table.getSelectedRow();
				
				//�ش� ��(Vector)�� rowData���� ��������
				Vector v = rowData.get(index);
				
				//v.get(0���ͽ���)���� �� �����ͼ� �ؽ�Ʈ�ʵ忡 �ֱ�
				jtf_no.setText(v.get(0)+"");
				jtf_name.setText(v.get(1)+"");
				jtf_location.setText(v.get(2)+"");

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
	public static void main(String[] args) {
		new DeptTest();
	}
}
