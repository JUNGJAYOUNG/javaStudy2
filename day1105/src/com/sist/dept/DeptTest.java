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
	
	//jtable 띄워주는 메소드
	public void printDept() {
		//이전 조회 목록에 이어서 뜨지 않게 rowData를 초기화해준다.
		rowData.clear();
		//dao의 조회메소드를 불러와서 데이터를 조회해온다.
		ArrayList<DeptVo> list = dao.listDept();
		
		//불러온 list에서 한행씩 꺼내온다
		for(DeptVo d:list) {
			//각 행은 Vector형으로 만들어서 table에 띄운다.
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
		
		colNames.add("부서번호:");
		colNames.add("부서이름:");
		colNames.add("부서위치:");
		
		table = new JTable(rowData,colNames);
		JScrollPane jsp = new JScrollPane(table);
		
		jtf_no = new JTextField();
		jtf_name = new JTextField();
		jtf_location = new JTextField();
	
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(5,2));
		p.add(new JLabel("부서번호:"));
		p.add(jtf_no);
		p.add(new JLabel("부서이름:"));
		p.add(jtf_name);
		p.add(new JLabel("부서위치:"));
		p.add(jtf_location);
		
		JButton btn_add = new JButton("추가");
		JButton btn_list = new JButton("목록");
		JButton btn_update = new JButton("수정");
		JButton btn_delete = new JButton("삭제");
		
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
					System.out.println("부서등록에 성공하였습니다.");
					printDept();
				}else {
					System.out.println("부서등록에 실패하였습니다.");
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
					System.out.println("부서수정에 성공하였습니다.");
					printDept();
				}else {
					System.out.println("부서수정에 실패하였습니다.");
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
					System.out.println("부서삭제에 성공하였습니다.");
					printDept();
				}else {
					System.out.println("부서삭제에 실패하였습니다.");
				}
			}
			
		});
		
		//테이블에있는 튜플 선택했을때 이벤트 발생하도록 하기 위해 addMouseListener
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
				
				//해당 행(Vector)을 rowData에서 가져오기
				Vector v = rowData.get(index);
				
				//v.get(0부터시작)으로 값 꺼내와서 텍스트필드에 넣기
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
