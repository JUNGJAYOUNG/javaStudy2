package com.sist.book;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBook extends JFrame{
	BookDAO dao;
	
	JTextField jtf_publi;
	JTable table;
	Vector colNames;
	Vector<Vector> rowData;
	
	public void printBook(String publisher) {
		rowData.clear();
		
		ArrayList<BookVO> list = dao.searchBook(publisher);
		rowData.add(colNames);
		for(BookVO b:list) {
			Vector v = new Vector();
			v.add(b.getBookid());
			v.add(b.getBookname());
			v.add(b.getPublisher());
			v.add(b.getPrice());
			rowData.add(v);
		}
		table.updateUI();
	}
	
	public SearchBook() {
		
		dao = new BookDAO();
		
		jtf_publi = new JTextField(15);
		JButton btn_search = new JButton("검색");
		
		setLayout(new BorderLayout());
		
		JPanel p_search= new JPanel();
		
		p_search.add(new JLabel("출판사명:"));
		p_search.add(jtf_publi);
		
		colNames= new Vector();
		
		colNames.add("도서번호");
		colNames.add("도서명");
		colNames.add("출판사");
		colNames.add("가격");
		
		rowData= new Vector<Vector>();
		
		table= new JTable(rowData,colNames);
		
		add(p_search,BorderLayout.NORTH);
		add(table,BorderLayout.CENTER);
		add(btn_search,BorderLayout.SOUTH);
		
		setTitle("도서검색");
		setSize(400,500);
		setVisible(true);
		
		btn_search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String publisher=jtf_publi.getText();
				printBook(publisher);
			}
		});	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SearchBook();
	}	

}
