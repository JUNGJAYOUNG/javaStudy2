package com.sist.book;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderTestUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int search_custid = 0;
		System.out.println("검색할 고객번호를 입력하세요");
		search_custid = sc.nextInt();
		
		OrdersDAO dao = new OrdersDAO();
		ArrayList<OrdersVO> list = dao.searchOrders(search_custid);
		for(OrdersVO o:list) {
			System.out.println(o.getOrderid()+"\n"+
							   o.getCustid()+"\n"+
							   o.getBookid()+"\n"+
							   o.getSaleprice()+"\n"+
							   o.getOrderdate());
		}
	}

}
