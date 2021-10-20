package com.sist.exam02;

import java.util.StringTokenizer;

public class StringTestSplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = "홍길동/20/서울/010-1234-5678";
		String []arr= data.split("/"); //분리된 데이터를 저장한 배열 반환됨
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		System.out.println("================");
		StringTokenizer st = new StringTokenizer(data,"/");
		while(st.hasMoreTokens()) {
			String str = st.nextToken();
			System.out.println(str);
		}
		
	}

}
