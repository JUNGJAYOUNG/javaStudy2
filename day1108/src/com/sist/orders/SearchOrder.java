package com.sist.orders;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchOrder extends JFrame{
	OrderDAO dao;
	
	JTextField jtf_custid;
	JTable table;
	Vector colNames;
	Vector<Vector> rowData;
	
	public void printOrder(int custid) {
		rowData.clear();
		
		ArrayList<OrderVO> list = dao.searchOrder(custid);
		
		for(OrderVO o:list) {
			Vector v = new Vector();
			v.add(o.getOrderid());
			v.add(o.getCustid());
			v.add(o.getBookid());
			v.add(o.getSaleprice());
			v.add(o.getOrderdate());
			rowData.add(v);
		}
		table.updateUI();
	}
	
	public SearchOrder() {
		
		dao = new OrderDAO();
		
		jtf_custid = new JTextField(15);
		JButton btn_search = new JButton("검색");
		
		setLayout(new BorderLayout());
		
		JPanel p_search= new JPanel();
		
		p_search.add(new JLabel("고객번호:"));
		p_search.add(jtf_custid);
		
		colNames = new Vector();
		
		colNames.add("주문번호");
		colNames.add("고객번호");
		colNames.add("도서번호");
		colNames.add("판매가격");
		colNames.add("주문날짜");
		
		rowData = new Vector<Vector>();
		
		table= new JTable(rowData,colNames);
		JScrollPane jsp = new JScrollPane(table);
		
		add(p_search,BorderLayout.NORTH);
		add(jsp,BorderLayout.CENTER);
		add(btn_search,BorderLayout.SOUTH);
		
		setTitle("도서검색");
		setSize(400,600);
		setVisible(true);
		
		btn_search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int custid=Integer.parseInt(jtf_custid.getText());
				printOrder(custid);
			}
		});	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SearchOrder();
	}	

}
